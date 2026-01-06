package edu.njpi.dc.dm.service;

import java.util.List;
import edu.njpi.dc.dm.domain.ReviewHistory;

/**
 * 审核日志Service接口
 * 
 * @author njpidc
 * @date 2025-12-19
 */
public interface IReviewHistoryService 
{
    /**
     * 查询审核日志
     * 
     * @param id 审核日志主键
     * @return 审核日志
     */
    public ReviewHistory selectReviewHistoryById(Long id);

    /**
     * 查询审核日志列表
     * 
     * @param reviewHistory 审核日志
     * @return 审核日志集合
     */
    public List<ReviewHistory> selectReviewHistoryList(ReviewHistory reviewHistory);

    /**
     * 新增审核日志
     * 
     * @param reviewHistory 审核日志
     * @return 结果
     */
    public int insertReviewHistory(ReviewHistory reviewHistory);

    /**
     * 修改审核日志
     * 
     * @param reviewHistory 审核日志
     * @return 结果
     */
    public int updateReviewHistory(ReviewHistory reviewHistory);

    /**
     * 批量删除审核日志
     * 
     * @param ids 需要删除的审核日志主键集合
     * @return 结果
     */
    public int deleteReviewHistoryByIds(Long[] ids);

    /**
     * 删除审核日志信息
     * 
     * @param id 审核日志主键
     * @return 结果
     */
    public int deleteReviewHistoryById(Long id);
}
