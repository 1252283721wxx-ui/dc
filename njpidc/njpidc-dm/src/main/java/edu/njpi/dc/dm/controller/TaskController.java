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
import edu.njpi.dc.dm.controller.domain.Task;
import edu.njpi.dc.dm.controller.service.ITaskService;
import edu.njpi.dc.common.utils.poi.ExcelUtil;
import edu.njpi.dc.common.core.page.TableDataInfo;

/**
 * 数据采集任务分配表Controller
 * 
 * @author yuu
 * @date 2025-11-12
 */
@RestController
@RequestMapping("/dm/task")
public class TaskController extends BaseController
{
    @Autowired
    private ITaskService taskService;

    /**
     * 查询数据采集任务分配表列表
     */
    @PreAuthorize("@ss.hasPermi('dm:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(Task task)
    {
        startPage();
        List<Task> list = taskService.selectTaskList(task);
        return getDataTable(list);
    }

    /**
     * 导出数据采集任务分配表列表
     */
    @PreAuthorize("@ss.hasPermi('dm:task:export')")
    @Log(title = "数据采集任务分配表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Task task)
    {
        List<Task> list = taskService.selectTaskList(task);
        ExcelUtil<Task> util = new ExcelUtil<Task>(Task.class);
        util.exportExcel(response, list, "数据采集任务分配表数据");
    }

    /**
     * 获取数据采集任务分配表详细信息
     */
    @PreAuthorize("@ss.hasPermi('dm:task:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return success(taskService.selectTaskByTaskId(taskId));
    }

    /**
     * 新增数据采集任务分配表
     */
    @PreAuthorize("@ss.hasPermi('dm:task:add')")
    @Log(title = "数据采集任务分配表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Task task)
    {
        return toAjax(taskService.insertTask(task));
    }

    /**
     * 修改数据采集任务分配表
     */
    @PreAuthorize("@ss.hasPermi('dm:task:edit')")
    @Log(title = "数据采集任务分配表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Task task)
    {
        return toAjax(taskService.updateTask(task));
    }

    /**
     * 删除数据采集任务分配表
     */
    @PreAuthorize("@ss.hasPermi('dm:task:remove')")
    @Log(title = "数据采集任务分配表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(taskService.deleteTaskByTaskIds(taskIds));
    }
}
