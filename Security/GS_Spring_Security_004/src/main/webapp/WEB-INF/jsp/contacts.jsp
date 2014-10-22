<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>


<h3>Contacts</h3>

<c:forEach items="${contacts}" var="contact">
    <span>${contact}</span> - <a href="<c:url value="/contacts/remove/${contact}"/>"/> Delete</a><br/>
</c:forEach>

<form action="<c:url value="/contacts"/>" method="POST">
    Contact <input type="text" name="contact"/>&nbsp;<input type="submit" value="Save">


</form>


</body>
</html>