package com.mortimer.library.repository;

import com.mortimer.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Book, Long> {
    Optional<List<Book>> findByNameContainingIgnoreCase(String name);
    //Optional<List<Book>> findByAuthorContainingIgnoreCase(String author);
}
