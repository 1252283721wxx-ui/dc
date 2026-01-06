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
import edu.njpi.dc.dm.domain.ReviewHistory;
import edu.njpi.dc.dm.service.IReviewHistoryService;
import edu.njpi.dc.common.utils.poi.ExcelUtil;
import edu.njpi.dc.common.core.page.TableDataInfo;

/**
 * 审核日志Controller
 * 
 * @author njpidc
 * @date 2025-12-19
 */
@RestController
@RequestMapping("/dm/review_history")
public class ReviewHistoryController extends BaseController
{
    @Autowired
    private IReviewHistoryService reviewHistoryService;

    /**
     * 查询审核日志列表
     */
    @PreAuthorize("@ss.hasPermi('dm:review_history:list')")
    @GetMapping("/list")
    public TableDataInfo list(ReviewHistory reviewHistory)
    {
        startPage();
        List<ReviewHistory> list = reviewHistoryService.selectReviewHistoryList(reviewHistory);
        return getDataTable(list);
    }

    /**
     * 导出审核日志列表
     */
    @PreAuthorize("@ss.hasPermi('dm:review_history:export')")
    @Log(title = "审核日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReviewHistory reviewHistory)
    {
        List<ReviewHistory> list = reviewHistoryService.selectReviewHistoryList(reviewHistory);
        ExcelUtil<ReviewHistory> util = new ExcelUtil<ReviewHistory>(ReviewHistory.class);
        util.exportExcel(response, list, "审核日志数据");
    }

    /**
     * 获取审核日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('dm:review_history:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(reviewHistoryService.selectReviewHistoryById(id));
    }

    /**
     * 新增审核日志
     */
    @PreAuthorize("@ss.hasPermi('dm:review_history:add')")
    @Log(title = "审核日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReviewHistory reviewHistory)
    {
        return toAjax(reviewHistoryService.insertReviewHistory(reviewHistory));
    }

    /**
     * 修改审核日志
     */
    @PreAuthorize("@ss.hasPermi('dm:review_history:edit')")
    @Log(title = "审核日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReviewHistory reviewHistory)
    {
        return toAjax(reviewHistoryService.updateReviewHistory(reviewHistory));
    }

    /**
     * 删除审核日志
     */
    @PreAuthorize("@ss.hasPermi('dm:review_history:remove')")
    @Log(title = "审核日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(reviewHistoryService.deleteReviewHistoryByIds(ids));
    }
}
