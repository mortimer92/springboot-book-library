package com.mortimer.library.service;

import com.mortimer.library.model.Book;
import com.mortimer.library.model.BookRequest;
import com.mortimer.library.model.BookResponse;
import com.mortimer.library.repository.LibraryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {
    private LibraryRepository libRepository;

    public LibraryService(LibraryRepository libRepository) {
        this.libRepository = libRepository;
    }

    public void saveBook(BookRequest bookRequest){
        Book book = new Book();//make it with a builder ? maybe it works for either request/response
        book.setName(bookRequest.getName());
        book.setAuthor(bookRequest.getAuthor());
        libRepository.save(book);
    }

    public List<BookResponse> getBookList() {
        List<BookResponse> allBooks =libRepository.findAll().stream()
                .map(book -> {
                    BookResponse response = new BookResponse();
                    response.setName(book.getName());
                    response.setAuthor(book.getAuthor());
                    return response;
                }).collect(Collectors.toList());
        return allBooks;
    }
}
