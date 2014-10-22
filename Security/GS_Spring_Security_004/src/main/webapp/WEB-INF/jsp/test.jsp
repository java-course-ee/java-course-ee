<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<body>

<h3>Username : ${username}</h3>

<h3>Roles : </h3>
<c:forEach items="${roles}" var="role">
    <h3>${role.authority}</h3>
</c:forEach>


<sec:authorize access="hasRole('ROLE_ADMIN')">
    <a href="<c:url value="/admin" />"> Administration</a>
</sec:authorize>

<a href="<c:url value="/contacts" />"/> Contacts</a>

<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
</body>
</html>