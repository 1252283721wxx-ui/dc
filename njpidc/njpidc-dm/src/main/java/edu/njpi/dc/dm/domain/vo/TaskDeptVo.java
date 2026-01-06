package edu.njpi.dc.dm.controller.domain.vo;

import lombok.Data;

import java.util.List;

@Data
public class TaskDeptVo {
    private List<Long> taskIds;
    private List<Long> deptIds;

    public List<Long> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<Long> taskIds) {
        this.taskIds = taskIds;
    }

    public List<Long> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(List<Long> deptIds) {
        this.deptIds = deptIds;
    }
}
