<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/public/header.jsp"/>


<h3>Available books</h3>
<ul>
    <c:forEach items="${books}" var="book">
        <li><img src="../img/books.jpg"> &nbsp; <span
                style="color: #00008b; font-size: 20px;">${book.author} - ${book.title}</span> &nbsp; <a
                href="/order?bookId=${book.number}">order book</a></li>
    </c:forEach>
</ul>

