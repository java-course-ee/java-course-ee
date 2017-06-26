package edu.javacourse.mockito;

import java.util.List;

/**
 * @author Artem Pronchakov artem.pronchakov@ocrv.ru
 */
public interface DAO {

    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book getBookByName(String name);

}
