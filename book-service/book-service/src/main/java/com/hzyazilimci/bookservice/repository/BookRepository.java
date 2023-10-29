package com.hzyazilimci.bookservice.repository;

import com.hzyazilimci.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    Optional<Book> findBookByIsbn(String isbn);
    Optional<Book> findById(String id);
}
