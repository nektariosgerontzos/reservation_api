package com.nekos.cruddemo.repository;

import com.nekos.cruddemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
