package edu.njpi.dc.dm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import edu.njpi.dc.common.annotation.Excel;
import edu.njpi.dc.common.core.domain.BaseEntity;

/**
 * 审核菜单表对象 dm_review_item
 * 
 * @author njpidc
 * @date 2025-12-19
 */
public class ReviewItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 表名 */
    @Excel(name = "表名")
    private String tableName;

    /** 数据表的主键 */
    @Excel(name = "数据表的主键")
    private String pkValue;

    /** 部门 */
    @Excel(name = "部门")
    private Long deptId;

    /** DRAFT, SUBMITTED,DEPT_APPROVED,DEPT_REJECTED,SCHOOL_APPROVED,SCHOOL_REJECTED */
    @Excel(name = "DRAFT, SUBMITTED,DEPT_APPROVED,DEPT_REJECTED,SCHOOL_APPROVED,SCHOOL_REJECTED")
    private String status;

    /** 版本 */
    @Excel(name = "版本")
    private Long version;

    /** 摘要 */
    @Excel(name = "摘要")
    private String dataHash;

    /** 输入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "输入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createAt;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setTableName(String tableName) 
    {
        this.tableName = tableName;
    }

    public String getTableName() 
    {
        return tableName;
    }

    public void setPkValue(String pkValue) 
    {
        this.pkValue = pkValue;
    }

    public String getPkValue() 
    {
        return pkValue;
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

    public void setVersion(Long version) 
    {
        this.version = version;
    }

    public Long getVersion() 
    {
        return version;
    }

    public void setDataHash(String dataHash) 
    {
        this.dataHash = dataHash;
    }

    public String getDataHash() 
    {
        return dataHash;
    }

    public void setCreateAt(Date createAt) 
    {
        this.createAt = createAt;
    }

    public Date getCreateAt() 
    {
        return createAt;
    }

    public void setUpdateAt(Date updateAt) 
    {
        this.updateAt = updateAt;
    }

    public Date getUpdateAt() 
    {
        return updateAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tableName", getTableName())
            .append("pkValue", getPkValue())
            .append("deptId", getDeptId())
            .append("status", getStatus())
            .append("version", getVersion())
            .append("dataHash", getDataHash())
            .append("createBy", getCreateBy())
            .append("createAt", getCreateAt())
            .append("updateAt", getUpdateAt())
            .toString();
    }
}
