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
}
