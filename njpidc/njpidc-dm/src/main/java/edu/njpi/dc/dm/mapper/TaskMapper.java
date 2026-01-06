package edu.njpi.dc.dm.controller.mapper;

import java.util.List;

import edu.njpi.dc.dm.controller.domain.Task;
import edu.njpi.dc.dm.controller.domain.TaskDept;

/**
 * 数据采集任务分配表Mapper接口
 *
 * @author yuu
 * @date 2025-11-12
 */
public interface TaskMapper {
    /**
     * 查询数据采集任务分配表
     *
     * @param taskId 数据采集任务分配表主键
     * @return 数据采集任务分配表
     */
    public Task selectTaskByTaskId(Long taskId);

    /**
     * 查询数据采集任务分配表列表
     *
     * @param task 数据采集任务分配表
     * @return 数据采集任务分配表集合
     */
    public List<Task> selectTaskList(Task task);

    /**
     * 新增数据采集任务分配表
     *
     * @param task 数据采集任务分配表
     * @return 结果
     */
    public int insertTask(Task task);

    /**
     * 修改数据采集任务分配表
     *
     * @param task 数据采集任务分配表
     * @return 结果
     */
    public int updateTask(Task task);

    /**
     * 删除数据采集任务分配表
     *
     * @param taskId 数据采集任务分配表主键
     * @return 结果
     */
    public int deleteTaskByTaskId(Long taskId);

    /**
     * 批量删除数据采集任务分配表
     *
     * @param taskIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTaskByTaskIds(Long[] taskIds);

    /**
     * 批量删除任务明细
     *
     * @param taskIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTaskDeptByTaskIds(Long[] taskIds);

    /**
     * 批量新增任务明细
     *
     * @param dmTaskDeptList 任务明细列表
     * @return 结果
     */
    public int batchTaskDept(List<TaskDept> dmTaskDeptList);


    /**
     * 通过数据采集任务分配表主键删除任务明细信息
     *
     * @param taskId 数据采集任务分配表ID
     * @return 结果
     */
    public int deleteTaskDeptByTaskId(Long taskId);

    public List<TaskDept> selectTaskDeptList(TaskDept taskDept);
}
