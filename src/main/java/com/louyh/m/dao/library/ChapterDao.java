package com.louyh.m.dao.library;

import com.louyh.m.domain.library.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterDao extends JpaRepository<Chapter, String>, JpaSpecificationExecutor<Chapter> {
}
