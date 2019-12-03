package com.louyh.m.domain.library;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_lb_chapter")
public class Chapter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    private String id;

    private String name;

    private Integer number;

    private Integer sorts;

    private String ctdt;

    private String obligate1;

    private String obligate2;

    @Column(name = "websiteid")
    private String websiteId;

    public String getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSorts() {
        return sorts;
    }

    public void setSorts(Integer sorts) {
        this.sorts = sorts;
    }

    public String getCtdt() {
        return ctdt;
    }

    public void setCtdt(String ctdt) {
        this.ctdt = ctdt;
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
