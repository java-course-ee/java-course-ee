package edu.javacourse.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Intern
 */
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        req.setAttribute("myname", name);

        List<Book> books = new ArrayList<Book>();

        books.add(new Book(1L, "Java for beginners", new Date()));
        books.add(new Book(2L, "Java for professionals", new Date()));
        books.add(new Book(3L, "Java for Experts", new Date()));

        req.setAttribute("books", books);

        getServletContext().getRequestDispatcher("/books.jsp").forward(req, resp);
    }
}
