package com.louyh.m.model;

import com.louyh.m.domain.task.TaskDetail;

import java.util.List;

public class TaskDayVO {
    private Integer date;
    private List<TaskDetail> list;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public List<TaskDetail> getList() {
        return list;
    }

    public void setList(List<TaskDetail> list) {
        this.list = list;
    }
}
