package edu.javacourse.web;

import java.util.Date;

public class Book {
    private Long id;
    private String name;
    private Date publishDate;

    public Book() {
    }

    public Book(Long id, String name, Date publishDate) {
        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }


}
