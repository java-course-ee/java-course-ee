<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<body>

<c:forEach items="${users}" var="u">
    ${u.login} - ${u.email} &nbsp;&nbsp; <a href="/users/${u.userId}.html">View</a> <br/>
</c:forEach>
</body>
</html>