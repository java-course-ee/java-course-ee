package ru.gemini.bean;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 26.04.13
 */
public class BookStore {

    private static List<Book> books;

    static {
        books = new LinkedList<Book>();
        addBook(new Book("Voina i mir", "Tolstoy", 100));
        addBook(new Book("Prestuplenie i nakazanie", "Dostoevsky", 120));
        addBook(new Book("Evgeny Onegin", "Pushkin", 100));
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static void addBook(Book book) {
        books.add(book);
    }

    public static int getBooksSize() {
        return books.size();
    }

    public static Book getBook(Integer number) {
        for (Book book : books) {
            if (book.getNumber().equals(number))
                return book;
        }
        return null;
    }


}
