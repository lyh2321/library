package com.louyh.m.dao.library;

import com.louyh.m.domain.library.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category, String>, JpaSpecificationExecutor<Category> {
}
