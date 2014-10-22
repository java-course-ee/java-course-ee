package ru.gemini.security;

import ru.gemini.bean.Book;
import ru.gemini.bean.BookStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Georgy Gobozov
 * Date: 27.04.13
 */
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookId = request.getParameter("bookId");

        if (bookId != null && request.getUserPrincipal() != null) {
            request.setAttribute("book", BookStore.getBook(Integer.parseInt(bookId)));
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/private/order.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (request.getUserPrincipal() != null && request.isUserInRole("administrator")) {
            request.setAttribute("books", BookStore.getBooks());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/private/admin.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // response.sendRedirect("/auth/404.jsp");
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");

        try {
            Book b = new Book(title, author, Integer.parseInt(price));
            BookStore.addBook(b);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/admin");


    }
}
