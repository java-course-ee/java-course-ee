package ru.gemini.bean;

/**
 * Author: Georgy Gobozov
 * Date: 26.04.13
 */
public class Book {

    private Integer number;
    private String title;
    private String author;
    private Integer price;


    public Book(String title, String author, Integer price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.number = BookStore.getBooksSize() + 1;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
