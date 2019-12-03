package com.louyh.m.dao.system;

import com.louyh.m.domain.system.Dict;
import com.louyh.m.domain.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DictDao extends JpaRepository<Dict, String>, JpaSpecificationExecutor<Dict> {
}
