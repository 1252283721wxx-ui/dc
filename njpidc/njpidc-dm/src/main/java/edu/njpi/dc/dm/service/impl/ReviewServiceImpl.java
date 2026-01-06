package edu.njpi.dc.dm.service.impl;

import com.alibaba.fastjson2.JSON;
import edu.njpi.dc.common.utils.SecurityUtils;
import edu.njpi.dc.common.utils.sign.Md5Utils;
import edu.njpi.dc.dm.domain.ReviewHistory;
import edu.njpi.dc.dm.domain.ReviewItem;
import edu.njpi.dc.dm.domain.ReviewTask;
import edu.njpi.dc.dm.domain.dto.ReviewSubmitDto;
import edu.njpi.dc.dm.service.IReviewHistoryService;
import edu.njpi.dc.dm.service.IReviewItemService;
import edu.njpi.dc.dm.service.IReviewService;
import edu.njpi.dc.dm.service.IReviewTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl implements IReviewService {
    @Autowired
    private IReviewHistoryService reviewHistoryService;
    @Autowired
    private IReviewItemService reviewItemService;
    @Autowired
    private IReviewTaskService reviewTaskService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int submit(ReviewSubmitDto reviewSubmitDto) {
        //1. dm_review_item
        ReviewItem reviewItem = new ReviewItem();
        reviewItem.setPkValue(reviewSubmitDto.getPkValue().toString());
        reviewItem.setTableName(reviewSubmitDto.getTableName());
        List<ReviewItem> reviewItemList = reviewItemService.selectReviewItemList(reviewItem);
        if (!reviewItemList.isEmpty()) {
            return 0;
        }
        reviewItem.setDeptId(SecurityUtils.getDeptId());
        reviewItem.setStatus("SUBMITTED");
        Map<String, Object> itemData = getDataTableNameAndPkValue(reviewSubmitDto.getTableName(), reviewSubmitDto.getPkValue());
        reviewItem.setDataHash(Md5Utils.hash(JSON.toJSONString(itemData)));
        reviewItem.setCreateBy(SecurityUtils.getLoginUser().getUsername());
        reviewItemService.insertReviewItem(reviewItem);
        //2. dm_review_task
        saveTask(reviewItem.getId(), "DEPT_REVIEWER", SecurityUtils.getDeptId(), JSON.toJSONString(itemData), reviewSubmitDto.getComment());
        //3. dm_review_history
        return saveHistory(reviewItem.getId(), "SUBMIT", SecurityUtils.getUserId(), "DATA_COLLECTOR", reviewSubmitDto.getComment(), JSON.toJSONString(itemData));
    }

    /**
     * 根据表名和主键值查询数据
     *
     * @param tableName 表名
     * @param pkValue   主键值
     * @return 查询结果的Map
     */
    private Map<String, Object> getDataTableNameAndPkValue(String tableName, Long pkValue) {
        String sql = String.format("select * from %s where id = ?", tableName);
        return jdbcTemplate.queryForMap(sql, pkValue);
    }

    private int saveTask(Long itemId, String assigneeRole, Long deptId, String snapshot, String comment) {
        ReviewTask reviewTask = new ReviewTask();
        reviewTask.setItemId(itemId);
        reviewTask.setAssigneeRole(assigneeRole);
        reviewTask.setDeptId(deptId);
        reviewTask.setStatus("OPEN");
        reviewTask.setSnapshotJson(snapshot);
        reviewTask.setComment(comment);
        return reviewTaskService.insertReviewTask(reviewTask);
    }

    private int saveHistory(Long itemId, String action, Long actorId, String actorRole, String comment, String snapshot) {
        ReviewHistory reviewHistory = new ReviewHistory();
        reviewHistory.setItemId(itemId);
        reviewHistory.setAction(action);
        reviewHistory.setActorId(actorId);
        reviewHistory.setActorRole(actorRole);
        reviewHistory.setComment(comment);
        reviewHistory.setSnapshotJson(snapshot);
        return reviewHistoryService.insertReviewHistory(reviewHistory);
    }

    @Override
    public int deptApprove(Long itemId, String comment) {
        // 1. 检查审核项是否存在
        ReviewItem reviewItem = reviewItemService.selectReviewItemById(itemId);
        if (reviewItem == null) {
            throw new RuntimeException("审核项不存在");
        }
        // 2. 检查状态是否为SUBMITTED
        if (!"SUBMITTED".equals(reviewItem.getStatus())) {
            throw new RuntimeException("审核项状态不正确，当前状态：" + reviewItem.getStatus());
        }
        // 3. 更新审核项状态为DEPT_APPROVED
        reviewItem.setStatus("DEPT_APPROVED");
        reviewItemService.updateReviewItem(reviewItem);
        // 4. 关闭部门审核任务
        closeTaskByItemId(itemId);
        // 5. 获取当前数据快照
        Map<String, Object> itemData = getDataTableNameAndPkValue(reviewItem.getTableName(), Long.parseLong(reviewItem.getPkValue()));
        // 6. 创建学校审核任务
        saveTask(itemId, "SCHOOL_REVIEWER", null, JSON.toJSONString(itemData), comment);
        // 7. 记录历史
        return saveHistory(itemId, "DEPT_APPROVE", SecurityUtils.getUserId(), "DEPT_REVIEWER", comment, JSON.toJSONString(itemData));
    }

    @Override
    public int deptReject(Long itemId, String comment) {
        // 1. 检查审核项是否存在
        ReviewItem reviewItem = reviewItemService.selectReviewItemById(itemId);
        if (reviewItem == null) {
            throw new RuntimeException("审核项不存在");
        }
        // 2. 检查状态是否为SUBMITTED
        if (!"SUBMITTED".equals(reviewItem.getStatus())) {
            throw new RuntimeException("审核项状态不正确，当前状态：" + reviewItem.getStatus());
        }
        // 3. 更新审核项状态为DEPT_REJECTED
        reviewItem.setStatus("DEPT_REJECTED");
        reviewItemService.updateReviewItem(reviewItem);
        // 4. 关闭部门审核任务
        closeTaskByItemId(itemId);
        // 5. 获取当前数据快照
        Map<String, Object> itemData = getDataTableNameAndPkValue(reviewItem.getTableName(), Long.parseLong(reviewItem.getPkValue()));
        // 6. 记录历史
        return saveHistory(itemId, "DEPT_REJECT", SecurityUtils.getUserId(), "DEPT_REVIEWER", comment, JSON.toJSONString(itemData));
    }

    @Override
    public int schoolApprove(Long itemId, String comment) {
        // 1. 检查审核项是否存在
        ReviewItem reviewItem = reviewItemService.selectReviewItemById(itemId);
        if (reviewItem == null) {
            throw new RuntimeException("审核项不存在");
        }
        // 2. 检查状态是否为DEPT_APPROVED
        if (!"DEPT_APPROVED".equals(reviewItem.getStatus())) {
            throw new RuntimeException("审核项状态不正确，当前状态：" + reviewItem.getStatus());
        }
        // 3. 更新审核项状态为SCHOOL_APPROVED
        reviewItem.setStatus("SCHOOL_APPROVED");
        reviewItemService.updateReviewItem(reviewItem);
        // 4. 关闭学校审核任务
        closeTaskByItemId(itemId);
        // 5. 获取当前数据快照
        Map<String, Object> itemData = getDataTableNameAndPkValue(reviewItem.getTableName(), Long.parseLong(reviewItem.getPkValue()));
        // 6. 记录历史
        return saveHistory(itemId, "SCHOOL_APPROVE", SecurityUtils.getUserId(), "SCHOOL_REVIEWER", comment, JSON.toJSONString(itemData));
    }

    @Override
    public int schoolReject(Long itemId, String comment) {
        // 1. 检查审核项是否存在
        ReviewItem reviewItem = reviewItemService.selectReviewItemById(itemId);
        if (reviewItem == null) {
            throw new RuntimeException("审核项不存在");
        }
        // 2. 检查状态是否为DEPT_APPROVED
        if (!"DEPT_APPROVED".equals(reviewItem.getStatus())) {
            throw new RuntimeException("审核项状态不正确，当前状态：" + reviewItem.getStatus());
        }
        // 3. 更新审核项状态为SCHOOL_REJECTED
        reviewItem.setStatus("SCHOOL_REJECTED");
        reviewItemService.updateReviewItem(reviewItem);
        // 4. 关闭学校审核任务
        closeTaskByItemId(itemId);
        // 5. 获取当前数据快照
        Map<String, Object> itemData = getDataTableNameAndPkValue(reviewItem.getTableName(), Long.parseLong(reviewItem.getPkValue()));
        // 6. 记录历史
        return saveHistory(itemId, "SCHOOL_REJECT", SecurityUtils.getUserId(), "SCHOOL_REVIEWER", comment, JSON.toJSONString(itemData));
    }

    /**
     * 关闭审核任务
     */
    private void closeTaskByItemId(Long itemId) {
        ReviewTask queryTask = new ReviewTask();
        queryTask.setItemId(itemId);
        queryTask.setStatus("OPEN");
        List<ReviewTask> tasks = reviewTaskService.selectReviewTaskList(queryTask);
        for (ReviewTask task : tasks) {
            task.setStatus("CLOSED");
            reviewTaskService.updateReviewTask(task);
        }
    }
}
