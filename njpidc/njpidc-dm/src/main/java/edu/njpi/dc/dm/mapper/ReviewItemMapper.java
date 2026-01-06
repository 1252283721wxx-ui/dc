package edu.njpi.dc.dm.mapper;

import java.util.List;
import edu.njpi.dc.dm.domain.ReviewItem;

/**
 * 审核菜单表Mapper接口
 * 
 * @author njpidc
 * @date 2025-12-19
 */
public interface ReviewItemMapper 
{
    /**
     * 查询审核菜单表
     * 
     * @param id 审核菜单表主键
     * @return 审核菜单表
     */
    public ReviewItem selectReviewItemById(Long id);

    /**
     * 查询审核菜单表列表
     * 
     * @param reviewItem 审核菜单表
     * @return 审核菜单表集合
     */
    public List<ReviewItem> selectReviewItemList(ReviewItem reviewItem);

    /**
     * 新增审核菜单表
     * 
     * @param reviewItem 审核菜单表
     * @return 结果
     */
    public int insertReviewItem(ReviewItem reviewItem);

    /**
     * 修改审核菜单表
     * 
     * @param reviewItem 审核菜单表
     * @return 结果
     */
    public int updateReviewItem(ReviewItem reviewItem);

    /**
     * 删除审核菜单表
     * 
     * @param id 审核菜单表主键
     * @return 结果
     */
    public int deleteReviewItemById(Long id);

    /**
     * 批量删除审核菜单表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReviewItemByIds(Long[] ids);
}
