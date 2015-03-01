<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books</title>
</head>
<body>

<h3>Books list(remote):</h3>
<ul>
    <c:forEach items="${books}" var="book">
        <li>${book.id} - ${book.name}</li>
    </c:forEach>
</ul>

</body>
</html>
