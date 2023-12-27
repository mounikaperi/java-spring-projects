package com.springpractice.springdatajpa.repositories;

import com.springpractice.springdatajpa.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
