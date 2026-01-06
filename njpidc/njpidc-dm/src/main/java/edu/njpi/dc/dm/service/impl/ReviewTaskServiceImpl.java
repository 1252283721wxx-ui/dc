package edu.njpi.dc.dm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.njpi.dc.dm.mapper.ReviewTaskMapper;
import edu.njpi.dc.dm.domain.ReviewTask;
import edu.njpi.dc.dm.service.IReviewTaskService;

/**
 * 审核任务分配表Service业务层处理
 * 
 * @author njpidc
 * @date 2025-12-19
 */
@Service
public class ReviewTaskServiceImpl implements IReviewTaskService 
{
    @Autowired
    private ReviewTaskMapper reviewTaskMapper;

    /**
     * 查询审核任务分配表
     * 
     * @param id 审核任务分配表主键
     * @return 审核任务分配表
     */
    @Override
    public ReviewTask selectReviewTaskById(Long id)
    {
        return reviewTaskMapper.selectReviewTaskById(id);
    }

    /**
     * 查询审核任务分配表列表
     * 
     * @param reviewTask 审核任务分配表
     * @return 审核任务分配表
     */
    @Override
    public List<ReviewTask> selectReviewTaskList(ReviewTask reviewTask)
    {
        return reviewTaskMapper.selectReviewTaskList(reviewTask);
    }

    /**
     * 新增审核任务分配表
     * 
     * @param reviewTask 审核任务分配表
     * @return 结果
     */
    @Override
    public int insertReviewTask(ReviewTask reviewTask)
    {
        return reviewTaskMapper.insertReviewTask(reviewTask);
    }

    /**
     * 修改审核任务分配表
     * 
     * @param reviewTask 审核任务分配表
     * @return 结果
     */
    @Override
    public int updateReviewTask(ReviewTask reviewTask)
    {
        return reviewTaskMapper.updateReviewTask(reviewTask);
    }

    /**
     * 批量删除审核任务分配表
     * 
     * @param ids 需要删除的审核任务分配表主键
     * @return 结果
     */
    @Override
    public int deleteReviewTaskByIds(Long[] ids)
    {
        return reviewTaskMapper.deleteReviewTaskByIds(ids);
    }

    /**
     * 删除审核任务分配表信息
     * 
     * @param id 审核任务分配表主键
     * @return 结果
     */
    @Override
    public int deleteReviewTaskById(Long id)
    {
        return reviewTaskMapper.deleteReviewTaskById(id);
    }
}
