package com.louyh.m.dao.library;

import com.louyh.m.domain.library.ChapterDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterDetailDao extends JpaRepository<ChapterDetail, String>, JpaSpecificationExecutor<ChapterDetail> {
}
