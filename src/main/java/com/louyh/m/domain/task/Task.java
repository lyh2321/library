package com.louyh.m.domain.task;

import com.louyh.m.domain.system.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_tk_tack")
public class Task  {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    /**
     * 删除标记(0-删除 1-可用 2-停用)
     */
    @Column(name = "status", nullable = false)
    private Integer status;

    private String creatdate;

    private String creatuserid;
    private String userid;
    private String location;
    private String title;
    private String color;
    private String calendar;
    private String description;
    private String icon;
    private String obligate1;
    private String obligate2;
    private String datetime;
    private String lastct;

    public String getLastct() {
        return lastct;
    }

    public void setLastct(String lastct) {
        this.lastct = lastct;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(String creatdate) {
        this.creatdate = creatdate;
    }

    public String getCreatuserid() {
        return creatuserid;
    }

    public void setCreatuserid(String creatuserid) {
        this.creatuserid = creatuserid;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getObligate1() {
        return obligate1;
    }

    public void setObligate1(String obligate1) {
        this.obligate1 = obligate1;
    }

    public String getObligate2() {
        return obligate2;
    }

    public void setObligate2(String obligate2) {
        this.obligate2 = obligate2;
    }

}
