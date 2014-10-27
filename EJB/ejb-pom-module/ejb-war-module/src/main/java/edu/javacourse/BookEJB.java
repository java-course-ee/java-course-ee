package edu.javacourse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */

@Stateless
public class BookEJB
        implements BookEJBLocal, BookEJBRemote {

    private static final Logger log = LoggerFactory.getLogger(BookEJB.class);

    @Override
    public List<Book> getBooks() {
        log.trace("Inside EJB's getBooks");
        List<Book> list = new ArrayList<Book>();
        list.add(new Book(1L, "Book1"));
        list.add(new Book(2L, "Book2"));
        list.add(new Book(3L, "Book3"));

        log.debug("Returned books: {}", list);

        log.trace("getBooks return");
        return list;
    }

}
