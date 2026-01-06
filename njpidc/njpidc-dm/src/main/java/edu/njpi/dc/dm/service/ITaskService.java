package edu.njpi.dc.dm.controller.service;

import java.util.List;
import edu.njpi.dc.dm.controller.domain.Task;

/**
 * 数据采集任务分配表Service接口
 * 
 * @author yuu
 * @date 2025-11-12
 */
public interface ITaskService 
{
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
     * 批量删除数据采集任务分配表
     * 
     * @param taskIds 需要删除的数据采集任务分配表主键集合
     * @return 结果
     */
    public int deleteTaskByTaskIds(Long[] taskIds);

    /**
     * 删除数据采集任务分配表信息
     * 
     * @param taskId 数据采集任务分配表主键
     * @return 结果
     */
    public int deleteTaskByTaskId(Long taskId);
}
