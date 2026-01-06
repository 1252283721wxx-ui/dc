package edu.njpi.dc.dm.controller.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import edu.njpi.dc.common.annotation.Excel;
import edu.njpi.dc.common.core.domain.BaseEntity;

/**
 * 任务明细对象 dm_task_dept
 *
 * @author yuu
 * @date 2025-11-12
 */
public class TaskDept extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 任务详情ID
     */
    private Long detailId;

    /**
     * 任务ID
     */
    @Excel(name = "任务ID")
    private Long taskId;

    /**
     * 部门ID
     */
    @Excel(name = "部门ID")
    private Long deptId;
    /**
     * 部门名称
     */
    @Excel(name = "部门名称")
    private String deptName;

    /**
     * 指派用户
     */
    @Excel(name = "指派用户")
    private String assignedUser;

    /**
     * 指派日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "指派日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date assignedDate;

    /**
     * 截止日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dueDate;

    /**
     * 优先级（1高 2中 3低）
     */
    @Excel(name = "优先级", readConverterExp = "1=高,2=中,3=低")
    private String priority;

    /**
     * 任务进度（0-100）
     */
    @Excel(name = "任务进度", readConverterExp = "0=-100")
    private Long progress;

    /**
     * 状态（0未开始 1进行中 2已完成）
     */
    @Excel(name = "状态", readConverterExp = "0=未开始,1=进行中,2=已完成")
    private String detailStatus;

    /**
     * 完成日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completionDate;

    /**
     * 完成备注
     */
    @Excel(name = "完成备注")
    private String completionNote;

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Long getProgress() {
        return progress;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }

    public String getDetailStatus() {
        return detailStatus;
    }

    public void setDetailStatus(String detailStatus) {
        this.detailStatus = detailStatus;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public String getCompletionNote() {
        return completionNote;
    }

    public void setCompletionNote(String completionNote) {
        this.completionNote = completionNote;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("detailId", getDetailId())
                .append("taskId", getTaskId())
                .append("deptId", getDeptId())
                .append("assignedUser", getAssignedUser())
                .append("assignedDate", getAssignedDate())
                .append("dueDate", getDueDate())
                .append("priority", getPriority())
                .append("progress", getProgress())
                .append("detailStatus", getDetailStatus())
                .append("completionDate", getCompletionDate())
                .append("completionNote", getCompletionNote())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
