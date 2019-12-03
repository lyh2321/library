package com.louyh.m.domain.library;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_lb_book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    private String id;

    private String ctdt;

    private Integer number;

    private String name;

    @Column(name = "authorid")
    private String authorId;

    private String introduction;

    private String obligate1;

    private String obligate2;

    @Column(name = "categoryid")
    private String categoryId;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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

    public String getCtdt() {
        return ctdt;
    }

    public void setCtdt(String ctdt) {
        this.ctdt = ctdt;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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
