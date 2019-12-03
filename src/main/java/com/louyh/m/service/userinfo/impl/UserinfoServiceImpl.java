package com.louyh.m.service.userinfo.impl;

import com.louyh.m.dao.user.UserDao;
import com.louyh.m.domain.user.UserInfo;
import com.louyh.m.model.Search;
import com.louyh.m.service.library.LibraryService;
import com.louyh.m.service.userinfo.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserInfo> getLogin(String loginname, String password) {
        Search search = new Search();
        search.addEqual("loginname", loginname);
        search.addEqual("password", password);
        return userDao.findAll(search.getSpecification());
    }
}
