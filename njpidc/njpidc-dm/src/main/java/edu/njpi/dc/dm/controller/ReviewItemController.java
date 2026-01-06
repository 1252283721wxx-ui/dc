package edu.njpi.dc.dm.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.njpi.dc.common.annotation.Log;
import edu.njpi.dc.common.core.controller.BaseController;
import edu.njpi.dc.common.core.domain.AjaxResult;
import edu.njpi.dc.common.enums.BusinessType;
import edu.njpi.dc.dm.domain.ReviewItem;
import edu.njpi.dc.dm.service.IReviewItemService;
import edu.njpi.dc.common.utils.poi.ExcelUtil;
import edu.njpi.dc.common.core.page.TableDataInfo;

/**
 * 审核菜单表Controller
 * 
 * @author njpidc
 * @date 2025-12-19
 */
@RestController
@RequestMapping("/dm/review_item")
public class ReviewItemController extends BaseController
{
    @Autowired
    private IReviewItemService reviewItemService;

    /**
     * 查询审核菜单表列表
     */
    @PreAuthorize("@ss.hasPermi('dm:review_item:list')")
    @GetMapping("/list")
    public TableDataInfo list(ReviewItem reviewItem)
    {
        startPage();
        List<ReviewItem> list = reviewItemService.selectReviewItemList(reviewItem);
        return getDataTable(list);
    }

    /**
     * 导出审核菜单表列表
     */
    @PreAuthorize("@ss.hasPermi('dm:review_item:export')")
    @Log(title = "审核菜单表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReviewItem reviewItem)
    {
        List<ReviewItem> list = reviewItemService.selectReviewItemList(reviewItem);
        ExcelUtil<ReviewItem> util = new ExcelUtil<ReviewItem>(ReviewItem.class);
        util.exportExcel(response, list, "审核菜单表数据");
    }

    /**
     * 获取审核菜单表详细信息
     */
    @PreAuthorize("@ss.hasPermi('dm:review_item:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(reviewItemService.selectReviewItemById(id));
    }

    /**
     * 新增审核菜单表
     */
    @PreAuthorize("@ss.hasPermi('dm:review_item:add')")
    @Log(title = "审核菜单表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReviewItem reviewItem)
    {
        return toAjax(reviewItemService.insertReviewItem(reviewItem));
    }

    /**
     * 修改审核菜单表
     */
    @PreAuthorize("@ss.hasPermi('dm:review_item:edit')")
    @Log(title = "审核菜单表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReviewItem reviewItem)
    {
        return toAjax(reviewItemService.updateReviewItem(reviewItem));
    }

    /**
     * 删除审核菜单表
     */
    @PreAuthorize("@ss.hasPermi('dm:review_item:remove')")
    @Log(title = "审核菜单表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(reviewItemService.deleteReviewItemByIds(ids));
    }
}
