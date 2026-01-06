package edu.njpi.dc.dm.controller.service;

import edu.njpi.dc.dm.controller.domain.TaskDept;

import java.util.List;

public interface ITaskDeptService {

    /**
     * 根据taskIds删除TaskDept
     * @param taskIds
     * @return
     */
    int deleteTaskDeptByTaskIds(List<Long> taskIds);

    /**
     * 根据taskId删除TaskDept
     * @param taskId
     * @return
     */
    int deleteTaskDeptByTaskId(Long taskId);

    /**
     *
     * @param taskIds
     * @param deptIds
     * @return
     */
    int batchTaskDept(List<Long> taskIds, List<Long> deptIds);

    List<TaskDept> selectTaskDeptList(TaskDept taskDept);
}
