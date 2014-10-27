package edu.javacourse;

import javax.ejb.Local;
import java.util.List;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */

@Local
public interface BookEJBLocal {

    List<Book> getBooks();

}
