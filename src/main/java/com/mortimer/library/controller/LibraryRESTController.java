package com.mortimer.library.controller;

import com.mortimer.library.model.BookRequest;
import com.mortimer.library.model.BookResponse;
import com.mortimer.library.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class LibraryRESTController {
    private LibraryService libraryService;

    public LibraryRESTController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<BookResponse> getAllBooks(){
        return libraryService.getBookList();
    }
    @GetMapping("/nameorauthor")
    public ResponseEntity<List<BookResponse>> getBooksByName(@RequestParam String name, @RequestParam String author ){
        return libraryService.findBooks(name, author);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postBook(@RequestBody BookRequest bookRequest){
        libraryService.saveBook(bookRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        libraryService.deleteBook(id);
    }

}
