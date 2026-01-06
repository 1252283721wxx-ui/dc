package edu.njpi.dc.dm.domain.dto;


import lombok.Data;

@Data
public class ReviewSubmitDto {
    private Long pkValue;
    private String tableName;
    private String comment;

    public Long getPkValue() {
        return pkValue;
    }

    public void setPkValue(Long pkValue) {
        this.pkValue = pkValue;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
