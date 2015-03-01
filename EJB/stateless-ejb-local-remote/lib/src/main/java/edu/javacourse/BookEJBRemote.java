package edu.javacourse;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Intern on 23.10.14.
 */

@Remote
public interface BookEJBRemote {

    List<Book> getBooks();

}
