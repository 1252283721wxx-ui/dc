package edu.njpi.dc.dm.controller;

import edu.njpi.dc.common.core.controller.BaseController;
import edu.njpi.dc.common.core.domain.AjaxResult;
import edu.njpi.dc.common.core.page.TableDataInfo;
import edu.njpi.dc.dm.controller.domain.TaskDept;
import edu.njpi.dc.dm.controller.domain.vo.TaskDeptVo;
import edu.njpi.dc.dm.controller.service.ITaskDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static edu.njpi.dc.common.utils.PageUtils.startPage;

@RestController
@RequestMapping("/dm/taskdept")
public class TaskDeptController extends BaseController {

    @Autowired
    private ITaskDeptService taskDeptService;

    //批量添加任务部门
    @PostMapping("/batchadd")
    public AjaxResult batchAddTaskDept(@RequestBody TaskDeptVo taskDeptVo) {
        return AjaxResult.success(taskDeptService.batchTaskDept(taskDeptVo.getTaskIds(),taskDeptVo.getDeptIds()));
    }

    @GetMapping("/list")
    public TableDataInfo list(TaskDept taskDept) {
        startPage();
        List<TaskDept> list = taskDeptService.selectTaskDeptList(taskDept);
        return getDataTable(list);
    }
}
