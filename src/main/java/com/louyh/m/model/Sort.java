package com.louyh.m.model;

/**
 * 排序类
 *
 * @author songJian
 * @version 2018-3-27
 */
public class Sort {

    public static final int ASC = 201;
    public static final int DESC = 202;

    private String cname;// 字段名称
    private Integer corder;// 排序方式

    public Sort(String cname, Integer corder) {
        this.cname = cname;
        this.corder = corder;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCorder() {
        return corder;
    }

    public void setCorder(Integer corder) {
        this.corder = corder;
    }
}
