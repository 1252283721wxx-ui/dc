package edu.njpi.dc.dm.controller.service.impl;

import edu.njpi.dc.common.utils.SecurityUtils;
import edu.njpi.dc.dm.controller.domain.TaskDept;
import edu.njpi.dc.dm.controller.mapper.TaskMapper;
import edu.njpi.dc.dm.controller.service.ITaskDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskDeptServiceImpl implements ITaskDeptService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public int deleteTaskDeptByTaskIds(List<Long> taskIds) {
        return taskMapper.deleteTaskDeptByTaskIds(taskIds.toArray(new Long[0]));
    }

    @Override
    public int deleteTaskDeptByTaskId(Long taskId) {
        return taskMapper.deleteTaskDeptByTaskId(taskId);
    }

    @Override
    @Transactional
    public int batchTaskDept(List<Long> taskIds, List<Long> deptIds) {

        // 参数判空
        if (taskIds == null || taskIds.isEmpty() ||
                deptIds == null || deptIds.isEmpty()) {
            return 0; // 不插入
        }

        // 先删除任务部门数据
        deleteTaskDeptByTaskIds(taskIds);

        List<TaskDept> taskDepts = new ArrayList<>();

        for (Long deptId : deptIds) {
            for (Long taskId : taskIds) {
                TaskDept taskDept = new TaskDept();
                taskDept.setDeptId(deptId);
                taskDept.setTaskId(taskId);
                taskDept.setCreateBy(SecurityUtils.getLoginUser().getUsername());
                taskDept.setAssignedDate(new Date());
                taskDepts.add(taskDept);
            }
        }

        return taskMapper.batchTaskDept(taskDepts);
    }


    @Override
    public List<TaskDept> selectTaskDeptList(TaskDept taskDept) {
        return taskMapper.selectTaskDeptList(taskDept);
    }
}
