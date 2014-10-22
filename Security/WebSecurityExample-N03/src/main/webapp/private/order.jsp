<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/public/header.jsp"/>

<h3>Welcome to book order page</h3>


<c:choose>
    <c:when test="${book ne null}">

        <table>
            <tr>
                <td rowspan="5">
                    <img src="../img/books.jpg">
                </td>
            </tr>
            <tr>
                <td><b>Title:</b>${book.title}</td>
            </tr>
            <tr>
                <td><b>Author:</b>${book.author}</td>
            </tr>
            <tr>
                <td><b>Price:</b>${book.price}</td>
            </tr>
            <tr>
                <td><a href="">Order book!</a></td>
            </tr>

        </table>


    </c:when>

    <c:otherwise>

        <span style="color: red; font-size: large">Book with id = ${param.bookId} not found!</span>

    </c:otherwise>
</c:choose>



