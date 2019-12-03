package com.louyh.m.service.calendar.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.louyh.m.dao.system.RedisService;
import com.louyh.m.dao.task.TaskDao;
import com.louyh.m.dao.task.TaskDetailDao;
import com.louyh.m.domain.task.Task;
import com.louyh.m.domain.task.TaskDetail;
import com.louyh.m.domain.user.UserInfo;
import com.louyh.m.model.AjaxResult;
import com.louyh.m.model.CalendarDetailVO;
import com.louyh.m.model.CalendarVO;
import com.louyh.m.model.Search;
import com.louyh.m.service.calendar.CalendarService;
import com.louyh.m.util.Utils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private RedisService redisService;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private TaskDetailDao taskDetailDao;


    @Override
    public List<Map> getCalendar(UserInfo userInfo, String sdt, String edt) {
        List<Map> list = Lists.newArrayList();
        List<Integer> year = null;
        List<Integer> month = null;
        List<Integer> day = null;
        List<Integer> hour = null;
        List<Integer> minute = null;
        List<Integer> second = null;


        Search search = new Search();
        search.addEqual("userid", userInfo.getId());
        search.addEqual("status", 1);
        search.addLessOrEqual("datetime", Utils.sdfdatee.parseDateTime(edt).toString(Utils.sdfdate) + " 23:59:59");
        search.addGreaterOrEqual("datetime", Utils.sdfdatee.parseDateTime(sdt).toString(Utils.sdfdate) + " 00:00:00");
        search.addSortAsc("creatdate");
        List<Task> taskList = taskDao.findAll(search.getSpecification());
        for (Task task : taskList) {

            Map map = Maps.newHashMap();
            map.put("data", Utils.java2MapRetain(task));

            search = new Search();
            search.addEqual("taskid", task.getId());
            search.addEqual("status", 1);
            search.addEqual("userid", userInfo.getId());
            List<TaskDetail> taskdetails = taskDetailDao.findAll(search.getSpecification());

            year = Lists.newArrayList();
            month = Lists.newArrayList();
            day = Lists.newArrayList();
            hour = Lists.newArrayList();
            minute = Lists.newArrayList();
            second = Lists.newArrayList();

            for (TaskDetail taskDetail : taskdetails) {
                if (!year.contains(taskDetail.getYear())) {
                    year.add(taskDetail.getYear());
                }
                if (!month.contains(taskDetail.getMonth())) {
                    month.add(taskDetail.getMonth() - 1);
                }
                if (!day.contains(taskDetail.getDay())) {
                    day.add(taskDetail.getDay());
                }
//                if (!hour.contains(taskDetail.getHour())) {
//                    hour.add(taskDetail.getHour());
//                }
//                if (!minute.contains(taskDetail.getMinute())) {
//                    minute.add(taskDetail.getMinute());
//                }
//                if (!second.contains(taskDetail.getSecond())) {
//                    second.add(taskDetail.getSecond());
//                }
            }

            Map schedule = Maps.newHashMap();
            schedule.put("month", month);
            schedule.put("year", year);
            schedule.put("dayOfMonth", day);
            map.put("schedule", schedule);

            list.add(map);
        }

        return list;
    }

    @Override
    public AjaxResult createcalendar(UserInfo userInfo, Integer year, Integer month, Integer day, Task task) {
        String datetime = year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day);

        task.setUserid(userInfo.getId());
        task.setStatus(1);
        task.setCreatdate(Utils.now());
        task.setCreatuserid(userInfo.getId());
        task.setDatetime(datetime);
        task.setLastct(Utils.now());
        taskDao.save(task);

        TaskDetail taskDetail = new TaskDetail();
        taskDetail.setTaskid(task.getId());
        taskDetail.setUserid(userInfo.getId());
        taskDetail.setYear(year);
        taskDetail.setMonth(month);
        taskDetail.setDay(day);
        taskDetail.setStatus(1);
        taskDetail.setCreatdate(Utils.now());
        taskDetail.setCreatuserid(userInfo.getId());
        taskDetail.setDatetime(datetime);
        taskDetailDao.save(taskDetail);
        return AjaxResult.OK(task.getId());
    }

    @Override
    public AjaxResult updatecalendar(UserInfo userInfo, Task task) {
        Task oldtask = taskDao.getOne(task.getId());
        oldtask.setTitle(task.getTitle());
        oldtask.setLocation(task.getLocation());
        oldtask.setColor(task.getColor());
        oldtask.setCalendar(task.getCalendar());
        oldtask.setDescription(task.getDescription());
        oldtask.setIcon(task.getIcon());
        oldtask.setLastct(Utils.now());
        taskDao.save(oldtask);
        return AjaxResult.OK();
    }

    @Override
    public void reomvecalendar(String id) {
        Task task = taskDao.getOne(id);
        task.setStatus(0);
        taskDao.save(task);
    }
}
