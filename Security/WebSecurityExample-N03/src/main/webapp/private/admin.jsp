<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/public/header.jsp"/>

<c:forEach items="${books}" var="book">
    <li><span style="color: #00008b; font-size: 20px;">${book.author} - ${book.title} - ${book.price}</span></li>
</c:forEach>
<br/>
<hr/>
<br/>

<form method="post" action="/admin">


    Title: <input type="text" name="title"><br/>
    Author: <input type="text" name="author"><br/>
    Price <input tpe="text" name="price"><br/><br/>

    <input type="submit">

</form>