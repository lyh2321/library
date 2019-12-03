package com.louyh.m.service.task.impl;

import com.louyh.m.dao.system.DictDao;
import com.louyh.m.dao.system.RedisService;
import com.louyh.m.dao.task.TaskDao;
import com.louyh.m.dao.task.TaskDetailDao;
import com.louyh.m.domain.system.Dict;
import com.louyh.m.domain.task.Task;
import com.louyh.m.domain.task.TaskDetail;
import com.louyh.m.domain.user.UserInfo;
import com.louyh.m.model.Search;
import com.louyh.m.service.task.TaskService;
import com.louyh.m.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private RedisService redisService;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private TaskDetailDao taskDetailDao;
    @Autowired
    private DictDao dictDao;


}
