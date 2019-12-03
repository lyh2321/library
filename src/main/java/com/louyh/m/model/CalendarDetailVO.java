package com.louyh.m.model;

import com.louyh.m.domain.task.TaskDetail;

import java.util.List;

public class CalendarDetailVO {
    private Integer category;
    private List<String> day;
    private List<String> date;
    private List<List<TaskDetail>> taskDetails;


    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }

    public List<List<TaskDetail>> getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(List<List<TaskDetail>> taskDetails) {
        this.taskDetails = taskDetails;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public List<String> getDay() {
        return day;
    }

    public void setDay(List<String> day) {
        this.day = day;
    }
}
