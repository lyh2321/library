package com.louyh.m.model;

import com.louyh.m.domain.user.UserInfo;

import java.util.List;

public class CalendarVO {
    private Integer year;
    private Integer month;
    private String startdate;
    private String enddate;
    private List<CalendarDetailVO> calendarDetailVOS;
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public List<CalendarDetailVO> getCalendarDetailVOS() {
        return calendarDetailVOS;
    }

    public void setCalendarDetailVOS(List<CalendarDetailVO> calendarDetailVOS) {
        this.calendarDetailVOS = calendarDetailVOS;
    }
}
