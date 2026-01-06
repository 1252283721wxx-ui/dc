package edu.njpi.dc.dm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.njpi.dc.dm.mapper.ReviewHistoryMapper;
import edu.njpi.dc.dm.domain.ReviewHistory;
import edu.njpi.dc.dm.service.IReviewHistoryService;

/**
 * 审核日志Service业务层处理
 * 
 * @author njpidc
 * @date 2025-12-19
 */
@Service
public class ReviewHistoryServiceImpl implements IReviewHistoryService 
{
    @Autowired
    private ReviewHistoryMapper reviewHistoryMapper;

    /**
     * 查询审核日志
     * 
     * @param id 审核日志主键
     * @return 审核日志
     */
    @Override
    public ReviewHistory selectReviewHistoryById(Long id)
    {
        return reviewHistoryMapper.selectReviewHistoryById(id);
    }

    /**
     * 查询审核日志列表
     * 
     * @param reviewHistory 审核日志
     * @return 审核日志
     */
    @Override
    public List<ReviewHistory> selectReviewHistoryList(ReviewHistory reviewHistory)
    {
        return reviewHistoryMapper.selectReviewHistoryList(reviewHistory);
    }

    /**
     * 新增审核日志
     * 
     * @param reviewHistory 审核日志
     * @return 结果
     */
    @Override
    public int insertReviewHistory(ReviewHistory reviewHistory)
    {
        return reviewHistoryMapper.insertReviewHistory(reviewHistory);
    }

    /**
     * 修改审核日志
     * 
     * @param reviewHistory 审核日志
     * @return 结果
     */
    @Override
    public int updateReviewHistory(ReviewHistory reviewHistory)
    {
        return reviewHistoryMapper.updateReviewHistory(reviewHistory);
    }

    /**
     * 批量删除审核日志
     * 
     * @param ids 需要删除的审核日志主键
     * @return 结果
     */
    @Override
    public int deleteReviewHistoryByIds(Long[] ids)
    {
        return reviewHistoryMapper.deleteReviewHistoryByIds(ids);
    }

    /**
     * 删除审核日志信息
     * 
     * @param id 审核日志主键
     * @return 结果
     */
    @Override
    public int deleteReviewHistoryById(Long id)
    {
        return reviewHistoryMapper.deleteReviewHistoryById(id);
    }
}
