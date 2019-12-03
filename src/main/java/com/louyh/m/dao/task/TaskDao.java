package com.louyh.m.dao.task;

import com.louyh.m.domain.library.Chapter;
import com.louyh.m.domain.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.xml.soap.Detail;

@Repository
public interface TaskDao extends JpaRepository<Task, String>, JpaSpecificationExecutor<Task> {
}
