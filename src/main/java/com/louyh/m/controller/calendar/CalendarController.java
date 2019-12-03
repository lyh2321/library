package com.louyh.m.controller.calendar;

import com.louyh.m.domain.task.Task;
import com.louyh.m.domain.user.UserInfo;
import com.louyh.m.model.AjaxResult;
import com.louyh.m.model.CalendarVO;
import com.louyh.m.service.calendar.CalendarService;
import com.louyh.m.util.Utils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("calendar")
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    @GetMapping("calendar.do")
    @ResponseBody
    public AjaxResult calendar(HttpServletRequest request, String sdt, String edt) {
        UserInfo userInfo = Utils.getUserInfo(request);
        List<Map> list = calendarService.getCalendar(userInfo, sdt, edt);
        return AjaxResult.OK(list);
    }

    @PostMapping("createcalendar.do")
    @ResponseBody
    public AjaxResult createcalendar(HttpServletRequest request, Integer year, Integer month, Integer day, Task task) {
        UserInfo userInfo = Utils.getUserInfo(request);
        return calendarService.createcalendar(userInfo, year, month + 1, day, task);

    }

    @PostMapping("addcalendar.do")
    @ResponseBody
    public AjaxResult addcalendar(HttpServletRequest request, String userinfoid, Integer year, Integer month, Integer day, Task task) {
        UserInfo userInfo = Utils.getUserInfo(request);
        if (year == null) {
            userInfo = new UserInfo();
            userInfo.setId(userinfoid);
            String[] split = Utils.nowDate().split("-");
            return calendarService.createcalendar(userInfo, Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), task);
        } else {
            return calendarService.createcalendar(userInfo, year, month + 1, day, task);
        }
    }

    @GetMapping("addcalendar.do")
    @ResponseBody
    public AjaxResult removecalendar(HttpServletRequest request, String id) {
        UserInfo userInfo = Utils.getUserInfo(request);
        calendarService.reomvecalendar(id);
        return AjaxResult.OK();
    }

    @PostMapping("updatecalendar.do")
    @ResponseBody
    public AjaxResult updatecalendar(HttpServletRequest request, Task task) {
        UserInfo userInfo = Utils.getUserInfo(request);
        return calendarService.updatecalendar(userInfo, task);
    }
}
