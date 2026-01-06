package edu.njpi.dc.dm.controller.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import edu.njpi.dc.common.annotation.Excel;
import edu.njpi.dc.common.core.domain.BaseEntity;

/**
 * 数据采集任务分配表对象 dm_task
 * 
 * @author yuu
 * @date 2025-11-12
 */
public class Task extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务ID */
    private Long taskId;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String taskName;

    /** 对应表名 */
    @Excel(name = "对应表名")
    private String tableName;

    /** 任务描述 */
    @Excel(name = "任务描述")
    private String description;

    /** 采集类型（0自动 1手动） */
    @Excel(name = "采集类型", readConverterExp = "0=自动,1=手动")
    private String collectionType;

    /** 采集周期 */
    @Excel(name = "采集周期")
    private String collectionCycle;

    /** 任务状态（0正常 1停用） */
    @Excel(name = "任务状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 任务明细信息 */
    private List<TaskDept> dmTaskDeptList;

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }

    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public String getTaskName() 
    {
        return taskName;
    }

    public void setTableName(String tableName) 
    {
        this.tableName = tableName;
    }

    public String getTableName() 
    {
        return tableName;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setCollectionType(String collectionType) 
    {
        this.collectionType = collectionType;
    }

    public String getCollectionType() 
    {
        return collectionType;
    }

    public void setCollectionCycle(String collectionCycle) 
    {
        this.collectionCycle = collectionCycle;
    }

    public String getCollectionCycle() 
    {
        return collectionCycle;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    public List<TaskDept> getTaskDeptList()
    {
        return dmTaskDeptList;
    }

    public void setTaskDeptList(List<TaskDept> dmTaskDeptList)
    {
        this.dmTaskDeptList = dmTaskDeptList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("taskName", getTaskName())
            .append("tableName", getTableName())
            .append("description", getDescription())
            .append("collectionType", getCollectionType())
            .append("collectionCycle", getCollectionCycle())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("dmTaskDeptList", getTaskDeptList())
            .toString();
    }
}
