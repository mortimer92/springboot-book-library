package com.mortimer.library.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String value){
        super("No book found by: " + value);
    }

}
