<%@ include file="../include.jsp" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="/style.css"/>"/>
</head>
<body>

<h2>Logged id users area!</h2>

<p>You are currently logged in.</p>

<p><a href="<c:url value="/home.jsp"/>">Return to the home page.</a></p>

<p><a href="<c:url value="/logout"/>">Log out.</a></p>


<p>

    <shiro:hasPermission name="user:view">
        You have "user:view" permission
    </shiro:hasPermission>

</p>

</body>
</html>