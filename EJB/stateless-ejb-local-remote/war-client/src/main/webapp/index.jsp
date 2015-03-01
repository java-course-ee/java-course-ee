<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books</title>
</head>
<body>

<h3>Book Class:${bookClass}</h3>
<h3>Bean Class:${beanClass}</h3>
<h3>Books list (${interface}):</h3>
<ul>
    <c:forEach items="${books}" var="book">
        <li>${book.id} - ${book.name}</li>
    </c:forEach>
</ul>

</body>
</html>
