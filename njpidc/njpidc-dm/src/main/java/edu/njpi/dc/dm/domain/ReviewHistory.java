package edu.njpi.dc.dm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import edu.njpi.dc.common.annotation.Excel;
import edu.njpi.dc.common.core.domain.BaseEntity;

/**
 * 审核日志对象 dm_review_history
 * 
 * @author njpidc
 * @date 2025-12-19
 */
public class ReviewHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** dm_review_item主键 */
    @Excel(name = "dm_review_item主键")
    private Long itemId;

    /** sumbitted,dept_approved,dept_rejected,school_approved,school_rejected */
    @Excel(name = "sumbitted,dept_approved,dept_rejected,school_approved,school_rejected")
    private String action;

    /** 操作者id */
    @Excel(name = "操作者id")
    private Long actorId;

    /** 操作者角色 */
    @Excel(name = "操作者角色")
    private String actorRole;

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

    public void setAction(String action) 
    {
        this.action = action;
    }

    public String getAction() 
    {
        return action;
    }

    public void setActorId(Long actorId) 
    {
        this.actorId = actorId;
    }

    public Long getActorId() 
    {
        return actorId;
    }

    public void setActorRole(String actorRole) 
    {
        this.actorRole = actorRole;
    }

    public String getActorRole() 
    {
        return actorRole;
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
            .append("action", getAction())
            .append("actorId", getActorId())
            .append("actorRole", getActorRole())
            .append("comment", getComment())
            .append("snapshotJson", getSnapshotJson())
            .append("createAt", getCreateAt())
            .toString();
    }
}
