package edu.njpi.dc.dm.mapper;

import java.util.List;
import edu.njpi.dc.dm.domain.ReviewTask;

/**
 * 审核任务分配表Mapper接口
 * 
 * @author njpidc
 * @date 2025-12-19
 */
public interface ReviewTaskMapper 
{
    /**
     * 查询审核任务分配表
     * 
     * @param id 审核任务分配表主键
     * @return 审核任务分配表
     */
    public ReviewTask selectReviewTaskById(Long id);

    /**
     * 查询审核任务分配表列表
     * 
     * @param reviewTask 审核任务分配表
     * @return 审核任务分配表集合
     */
    public List<ReviewTask> selectReviewTaskList(ReviewTask reviewTask);

    /**
     * 新增审核任务分配表
     * 
     * @param reviewTask 审核任务分配表
     * @return 结果
     */
    public int insertReviewTask(ReviewTask reviewTask);

    /**
     * 修改审核任务分配表
     * 
     * @param reviewTask 审核任务分配表
     * @return 结果
     */
    public int updateReviewTask(ReviewTask reviewTask);

    /**
     * 删除审核任务分配表
     * 
     * @param id 审核任务分配表主键
     * @return 结果
     */
    public int deleteReviewTaskById(Long id);

    /**
     * 批量删除审核任务分配表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReviewTaskByIds(Long[] ids);
}
