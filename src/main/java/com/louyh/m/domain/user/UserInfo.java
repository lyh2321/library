package com.louyh.m.domain.user;

import com.louyh.m.domain.system.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_ui_userinfo")
public class UserInfo extends BaseEntity {

    private String loginname;
    private String username;

    private String password;

    private String ctdt;

    private String enddt;


    //0普通用户 1管理用户
    private String types;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCtdt() {
        return ctdt;
    }

    public void setCtdt(String ctdt) {
        this.ctdt = ctdt;
    }

    public String getEnddt() {
        return enddt;
    }

    public void setEnddt(String enddt) {
        this.enddt = enddt;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }
}
