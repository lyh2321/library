package com.louyh.m.controller;

import com.louyh.m.constant.Constant;
import com.louyh.m.domain.task.TaskDetail;
import com.louyh.m.domain.user.UserInfo;
import com.louyh.m.model.AjaxResult;
import com.louyh.m.model.CalendarVO;
import com.louyh.m.service.calendar.CalendarService;
import com.louyh.m.service.task.TaskService;
import com.louyh.m.service.userinfo.UserinfoService;
import com.louyh.m.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class IController {
    @Autowired
    private CalendarService calendarService;
    @Autowired
    private UserinfoService userinfoService;
    @Autowired
    private TaskService taskService;


    @PostMapping("login.do")
    @ResponseBody
    public AjaxResult login(HttpServletRequest request, String loginname, String password) {
        List<UserInfo> login = userinfoService.getLogin(loginname, password);
        if (login != null && login.size() > 0) {
            UserInfo userInfo = login.get(0);
            request.getSession().setAttribute(Constant.USER_INFO, userInfo);
            return AjaxResult.OK("登录成功");
        }
        return AjaxResult.Fail("账号密码错误");
    }

    @PostMapping("out.do")
    @ResponseBody
    public AjaxResult out(HttpServletRequest request) {
        UserInfo userInfo = Utils.getUserInfo(request);
        if (userInfo != null) {
            request.getSession().removeAttribute(Constant.USER_INFO);
            return AjaxResult.OK("退出成功");
        }
        return AjaxResult.Fail("已退出");
    }


    @GetMapping("/")
    public String index(HttpServletRequest request, String loginname, String password) {

        return "";
    }
}
