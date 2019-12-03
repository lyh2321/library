package com.louyh.m.dao.task;

import com.louyh.m.domain.library.Chapter;
import com.louyh.m.domain.task.TaskDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.xml.soap.Detail;

@Repository
public interface TaskDetailDao extends JpaRepository<TaskDetail, String>, JpaSpecificationExecutor<TaskDetail> {
}
