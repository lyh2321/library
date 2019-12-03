package com.louyh.m.domain.library;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_lb_chapterdetail")
public class ChapterDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    @Column(name = "detail", columnDefinition = "TEXT", nullable = true)
    private String detail;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
