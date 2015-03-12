<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<body>
<%--<h1>Summa =  : (${one + two})</h1>--%>
<h1>Summa = : (${sum})</h1>


<c:if test="${error ne null}">
    <span style="color: red;"><h1>${error}</h1></span>
</c:if>


<form action="/sum" method="POST">
    <input type="text" name="d1"/> + <input type="text" name="d2"/> <br/>
    <input type="submit">

</form>


</body>
</html>