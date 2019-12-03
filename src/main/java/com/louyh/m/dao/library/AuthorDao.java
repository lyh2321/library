package com.louyh.m.dao.library;

import com.louyh.m.domain.library.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, String>, JpaSpecificationExecutor<Author> {
}
