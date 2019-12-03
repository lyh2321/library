package com.louyh.m.service.calendar;

import com.louyh.m.domain.task.Task;
import com.louyh.m.domain.user.UserInfo;
import com.louyh.m.model.AjaxResult;
import com.louyh.m.model.CalendarVO;

import java.util.List;
import java.util.Map;

public interface CalendarService {

    List<Map> getCalendar(UserInfo userInfo, String sdt, String edt);

    AjaxResult createcalendar(UserInfo userInfo, Integer year, Integer month, Integer day, Task task);

    AjaxResult updatecalendar(UserInfo userInfo, Task task);

    void reomvecalendar(String id);


}
