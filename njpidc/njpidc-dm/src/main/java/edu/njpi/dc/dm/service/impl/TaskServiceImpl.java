package edu.njpi.dc.dm.controller.service.impl;

import java.util.List;
import edu.njpi.dc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import edu.njpi.dc.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import edu.njpi.dc.dm.controller.domain.TaskDept;
import edu.njpi.dc.dm.controller.mapper.TaskMapper;
import edu.njpi.dc.dm.controller.domain.Task;
import edu.njpi.dc.dm.controller.service.ITaskService;

/**
 * 数据采集任务分配表Service业务层处理
 * 
 * @author yuu
 * @date 2025-11-12
 */
@Service
public class TaskServiceImpl implements ITaskService 
{
    @Autowired
    private TaskMapper taskMapper;

    /**
     * 查询数据采集任务分配表
     * 
     * @param taskId 数据采集任务分配表主键
     * @return 数据采集任务分配表
     */
    @Override
    public Task selectTaskByTaskId(Long taskId)
    {
        return taskMapper.selectTaskByTaskId(taskId);
    }

    /**
     * 查询数据采集任务分配表列表
     * 
     * @param task 数据采集任务分配表
     * @return 数据采集任务分配表
     */
    @Override
    public List<Task> selectTaskList(Task task)
    {
        return taskMapper.selectTaskList(task);
    }

    /**
     * 新增数据采集任务分配表
     * 
     * @param task 数据采集任务分配表
     * @return 结果
     */
    @Transactional
    @Override
    public int insertTask(Task task)
    {
        task.setCreateTime(DateUtils.getNowDate());
        int rows = taskMapper.insertTask(task);
        insertTaskDept(task);
        return rows;
    }

    /**
     * 修改数据采集任务分配表
     * 
     * @param task 数据采集任务分配表
     * @return 结果
     */
    @Transactional
    @Override
    public int updateTask(Task task)
    {
        task.setUpdateTime(DateUtils.getNowDate());
        taskMapper.deleteTaskDeptByTaskId(task.getTaskId());
        insertTaskDept(task);
        return taskMapper.updateTask(task);
    }

    /**
     * 批量删除数据采集任务分配表
     * 
     * @param taskIds 需要删除的数据采集任务分配表主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTaskByTaskIds(Long[] taskIds)
    {
        taskMapper.deleteTaskDeptByTaskIds(taskIds);
        return taskMapper.deleteTaskByTaskIds(taskIds);
    }

    /**
     * 删除数据采集任务分配表信息
     * 
     * @param taskId 数据采集任务分配表主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTaskByTaskId(Long taskId)
    {
        taskMapper.deleteTaskDeptByTaskId(taskId);
        return taskMapper.deleteTaskByTaskId(taskId);
    }

    /**
     * 新增任务明细信息
     * 
     * @param task 数据采集任务分配表对象
     */
    public void insertTaskDept(Task task)
    {
        List<TaskDept> dmTaskDeptList = task.getTaskDeptList();
        Long taskId = task.getTaskId();
        if (StringUtils.isNotNull(dmTaskDeptList))
        {
            List<TaskDept> list = new ArrayList<TaskDept>();
            for (TaskDept dmTaskDept : dmTaskDeptList)
            {
                dmTaskDept.setTaskId(taskId);
                list.add(dmTaskDept);
            }
            if (list.size() > 0)
            {
                taskMapper.batchTaskDept(list);
            }
        }
    }
}
