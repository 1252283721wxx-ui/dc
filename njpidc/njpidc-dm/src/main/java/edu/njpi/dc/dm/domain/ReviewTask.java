package edu.njpi.dc.dm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import edu.njpi.dc.common.annotation.Excel;
import edu.njpi.dc.common.core.domain.BaseEntity;

/**
 * 审核任务分配表对象 dm_review_task
 * 
 * @author njpidc
 * @date 2025-12-19
 */
public class ReviewTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** dm_review_item主键 */
    @Excel(name = "dm_review_item主键")
    private Long itemId;

    /** 角色 */
    @Excel(name = "角色")
    private String assigneeRole;

    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;

    /** OPEN,CANCELED,DONE */
    @Excel(name = "OPEN,CANCELED,DONE")
    private String status;

    /** 审核意见 */
    @Excel(name = "审核意见")
    private String comment;

    /** 快照 */
    @Excel(name = "快照")
    private String snapshotJson;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setItemId(Long itemId) 
    {
        this.itemId = itemId;
    }

    public Long getItemId() 
    {
        return itemId;
    }

    public void setAssigneeRole(String assigneeRole) 
    {
        this.assigneeRole = assigneeRole;
    }

    public String getAssigneeRole() 
    {
        return assigneeRole;
    }

    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }

    public void setSnapshotJson(String snapshotJson) 
    {
        this.snapshotJson = snapshotJson;
    }

    public String getSnapshotJson() 
    {
        return snapshotJson;
    }

    public void setCreateAt(Date createAt) 
    {
        this.createAt = createAt;
    }

    public Date getCreateAt() 
    {
        return createAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("itemId", getItemId())
            .append("assigneeRole", getAssigneeRole())
            .append("deptId", getDeptId())
            .append("status", getStatus())
            .append("comment", getComment())
            .append("snapshotJson", getSnapshotJson())
            .append("createAt", getCreateAt())
            .toString();
    }
}
