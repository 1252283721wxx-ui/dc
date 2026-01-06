package edu.njpi.dc.dm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.njpi.dc.dm.mapper.ReviewItemMapper;
import edu.njpi.dc.dm.domain.ReviewItem;
import edu.njpi.dc.dm.service.IReviewItemService;

/**
 * 审核菜单表Service业务层处理
 * 
 * @author njpidc
 * @date 2025-12-19
 */
@Service
public class ReviewItemServiceImpl implements IReviewItemService 
{
    @Autowired
    private ReviewItemMapper reviewItemMapper;

    /**
     * 查询审核菜单表
     * 
     * @param id 审核菜单表主键
     * @return 审核菜单表
     */
    @Override
    public ReviewItem selectReviewItemById(Long id)
    {
        return reviewItemMapper.selectReviewItemById(id);
    }

    /**
     * 查询审核菜单表列表
     * 
     * @param reviewItem 审核菜单表
     * @return 审核菜单表
     */
    @Override
    public List<ReviewItem> selectReviewItemList(ReviewItem reviewItem)
    {
        return reviewItemMapper.selectReviewItemList(reviewItem);
    }

    /**
     * 新增审核菜单表
     * 
     * @param reviewItem 审核菜单表
     * @return 结果
     */
    @Override
    public int insertReviewItem(ReviewItem reviewItem)
    {
        return reviewItemMapper.insertReviewItem(reviewItem);
    }

    /**
     * 修改审核菜单表
     * 
     * @param reviewItem 审核菜单表
     * @return 结果
     */
    @Override
    public int updateReviewItem(ReviewItem reviewItem)
    {
        return reviewItemMapper.updateReviewItem(reviewItem);
    }

    /**
     * 批量删除审核菜单表
     * 
     * @param ids 需要删除的审核菜单表主键
     * @return 结果
     */
    @Override
    public int deleteReviewItemByIds(Long[] ids)
    {
        return reviewItemMapper.deleteReviewItemByIds(ids);
    }

    /**
     * 删除审核菜单表信息
     * 
     * @param id 审核菜单表主键
     * @return 结果
     */
    @Override
    public int deleteReviewItemById(Long id)
    {
        return reviewItemMapper.deleteReviewItemById(id);
    }
}
