package edu.javacourse.mockito;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author Artem Pronchakov artem.pronchakov@ocrv.ru
 */
public class BusinessLogicTest {

    private static DAO dao;
    private static final Book book1 = new Book(1L, "Java For Junior", "123");
    private static final Book book2 = new Book(2L, "Java For Middle", "456");
    private static final Book book3 = new Book(3L, "Java For Senior", "789");

    @BeforeClass
    public static void beforeClass() {
        dao = mock(DAO.class);

        ArrayList<Book> list = new ArrayList() {{
            add(book1);
            add(book2);
            add(book3);
        }};

        when(dao.getAllBooks()).thenReturn(list);

        when(dao.getBookById(1L)).thenReturn(book1);
        when(dao.getBookById(2L)).thenReturn(book2);
        when(dao.getBookById(3L)).thenReturn(book3);

        when(dao.getBookByName("Java For Junior")).thenReturn(book1);
        when(dao.getBookByName("Java For Middle")).thenReturn(book2);
        when(dao.getBookByName("Java For Senior")).thenReturn(book3);
    }

    @Test
    public void getFullBookTest() {
        BusinessLogic logic = new BusinessLogic();
        logic.setDao(dao);

        Book actualBook1 = logic.getFullBook(new Book(1L, null, null));
        verify(dao).getBookById(1L);
        assertEquals(book1, actualBook1);


        Book actualBook2 = logic.getFullBook(new Book(null, "Java For Middle", null));
        verify(dao).getBookByName("Java For Middle");
        assertEquals(book2, actualBook2);
    }

}
