package com.mortimer.library.model;

public class BookRequest {
    private String name;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
