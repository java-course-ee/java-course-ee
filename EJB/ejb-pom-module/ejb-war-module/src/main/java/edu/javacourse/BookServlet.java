package edu.javacourse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */

@WebServlet(name = "BookServlet", urlPatterns = { "/bookServlet" })
public class BookServlet
        extends HttpServlet
{

    private static final Logger log = LoggerFactory.getLogger( BookServlet.class );

    @EJB
    private BookEJBLocal bookEJBLocal;

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
    throws ServletException, IOException
    {
        log.trace( "Servlet BookServlet doGet begin" );
        log.debug( "BookEJBLocal class: {}", bookEJBLocal == null ? "EJB not initialized" : bookEJBLocal.getClass().getCanonicalName() );

        List< Book > books = bookEJBLocal.getBooks();

        log.debug( "Books returned by EJB: {}", books );

        request.setAttribute( "books", books );

        getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response );
        log.trace( "Servlet BookServlet doGet end" );
    }

    public BookEJBLocal getBookEJBLocal()
    {
        return bookEJBLocal;
    }

    public void setBookEJBLocal( BookEJBLocal bookEJBLocal )
    {
        this.bookEJBLocal = bookEJBLocal;
    }
}
