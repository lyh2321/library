package com.louyh.m.dao.library;

import com.louyh.m.domain.library.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, String>, JpaSpecificationExecutor<Book> {
}
