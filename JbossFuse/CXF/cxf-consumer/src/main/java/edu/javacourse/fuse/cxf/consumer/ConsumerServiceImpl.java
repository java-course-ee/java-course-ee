package edu.javacourse.fuse.cxf.consumer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Date;

/**
 * @author Artem Pronchakov pronchakov.artem@calisto.email
 */
@WebService(name = "ConsumerService", serviceName = "ConsumerServiceWS")
public class ConsumerServiceImpl {

    @WebMethod(operationName = "getBookByID")
    @WebResult(name = "Book")
    public Book getBookByID(@WebParam(name = "id", mode = WebParam.Mode.IN) int id) throws BookNotFoundException {
        if (id != 123) {
            throw new BookNotFoundException("The book with id " + id + " cannot be found");
        }
        return new Book(123, "Java: A Beginner's Guide, Sixth Edition", "978-0071809252", new Date());
    }

}
