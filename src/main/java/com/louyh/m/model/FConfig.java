package com.louyh.m.model;

import java.io.Serializable;

public class FConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    // IP地址
    private String ftpHost;
    // FTP映射端口
    private int ftpPort;
    // 任务名称
    private String taskname;

    public String getFtpHost() {
        return ftpHost;
    }

    public void setFtpHost(String ftpHost) {
        this.ftpHost = ftpHost;
    }

    public int getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(int ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

}
