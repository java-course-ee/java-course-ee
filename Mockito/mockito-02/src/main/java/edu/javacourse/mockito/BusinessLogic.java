package edu.javacourse.mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Pronchakov artem.pronchakov@ocrv.ru
 */
public class BusinessLogic {

    private DAO dao;

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    public Book getFullBook(Book book) {
        if (book.getId() != null) {
            Book bookById = dao.getBookById(book.getId());
            return bookById;
        } else if (book.getName() != null) {
            return dao.getBookByName(book.getName());
        } else {
            return null;
        }
    }
}
