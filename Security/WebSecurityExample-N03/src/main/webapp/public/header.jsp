<%--
   Author: Georgy Gobozov
   Date: 27.04.13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<div style="background: #cd5c5c; font-size: 30px;">
    Welcome to Java-course book store!
</div>

<c:choose>
    <c:when test="${pageContext.request.userPrincipal ne null}">
        <h3>Hello ${pageContext.request.userPrincipal.name}, welcome to java-course book store!</h3>

        <a href="/books">Home</a> &nbsp;&nbsp;

        <c:if test='<%= request.isUserInRole("administrator") %>'>
            <a href="/admin">Manage books</a> &nbsp;&nbsp;
        </c:if>

        <a href="/books?logout=true">Logout</a>


    </c:when>
    <c:otherwise>
        To order books you need <a href="../auth/login.jsp">login</a> &nbsp;&nbsp;
        Force <a href="/login">login</a>
    </c:otherwise>
</c:choose>

</body>
</html>