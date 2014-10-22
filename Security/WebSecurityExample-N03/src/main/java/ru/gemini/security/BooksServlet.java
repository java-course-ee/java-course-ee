package ru.gemini.security;

import ru.gemini.bean.BookStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Georgy Gobozov
 * Date: 26.04.13
 */
public class BooksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("logout") != null) {
            request.getSession().invalidate();
            response.sendRedirect("/books");
            return;
        }

        request.setAttribute("books", BookStore.getBooks());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/public/books.jsp");
        dispatcher.forward(request, response);

    }

}
