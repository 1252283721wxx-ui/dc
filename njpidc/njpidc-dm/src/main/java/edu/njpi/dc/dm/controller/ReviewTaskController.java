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
import edu.njpi.dc.dm.domain.ReviewTask;
import edu.njpi.dc.dm.service.IReviewTaskService;
import edu.njpi.dc.common.utils.poi.ExcelUtil;
import edu.njpi.dc.common.core.page.TableDataInfo;

/**
 * 审核任务分配表Controller
 * 
 * @author njpidc
 * @date 2025-12-19
 */
@RestController
@RequestMapping("/dm/review_task")
public class ReviewTaskController extends BaseController
{
    @Autowired
    private IReviewTaskService reviewTaskService;

    /**
     * 查询审核任务分配表列表
     */
    @PreAuthorize("@ss.hasPermi('dm:review_task:list')")
    @GetMapping("/list")
    public TableDataInfo list(ReviewTask reviewTask)
    {
        startPage();
        List<ReviewTask> list = reviewTaskService.selectReviewTaskList(reviewTask);
        return getDataTable(list);
    }

    /**
     * 导出审核任务分配表列表
     */
    @PreAuthorize("@ss.hasPermi('dm:review_task:export')")
    @Log(title = "审核任务分配表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReviewTask reviewTask)
    {
        List<ReviewTask> list = reviewTaskService.selectReviewTaskList(reviewTask);
        ExcelUtil<ReviewTask> util = new ExcelUtil<ReviewTask>(ReviewTask.class);
        util.exportExcel(response, list, "审核任务分配表数据");
    }

    /**
     * 获取审核任务分配表详细信息
     */
    @PreAuthorize("@ss.hasPermi('dm:review_task:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(reviewTaskService.selectReviewTaskById(id));
    }

    /**
     * 新增审核任务分配表
     */
    @PreAuthorize("@ss.hasPermi('dm:review_task:add')")
    @Log(title = "审核任务分配表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReviewTask reviewTask)
    {
        return toAjax(reviewTaskService.insertReviewTask(reviewTask));
    }

    /**
     * 修改审核任务分配表
     */
    @PreAuthorize("@ss.hasPermi('dm:review_task:edit')")
    @Log(title = "审核任务分配表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReviewTask reviewTask)
    {
        return toAjax(reviewTaskService.updateReviewTask(reviewTask));
    }

    /**
     * 删除审核任务分配表
     */
    @PreAuthorize("@ss.hasPermi('dm:review_task:remove')")
    @Log(title = "审核任务分配表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(reviewTaskService.deleteReviewTaskByIds(ids));
    }
}
