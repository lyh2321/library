package com.louyh.m.service.userinfo;

import com.louyh.m.domain.user.UserInfo;

import java.util.List;

public interface UserinfoService {


    List<UserInfo> getLogin(String loginname, String password);
}
