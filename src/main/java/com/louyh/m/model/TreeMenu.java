package com.louyh.m.model;

import com.google.common.collect.Lists;

import java.util.List;

public class TreeMenu {
    private String id;
    private String name;
    private String url;
    private String tag;
    private Integer status;
    private Integer seq;// 排序
    private List<TreeMenu> nodes = Lists.newArrayList();

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<TreeMenu> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeMenu> nodes) {
        this.nodes = nodes;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
