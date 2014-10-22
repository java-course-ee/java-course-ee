<%@ include file="include.jsp" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="/style.css"/>"/>
    <title>Apache Shiro Quickstart</title>
</head>
<body>

<h1>Apache Shiro Quickstart</h1>

<p>Hi <shiro:guest>Guest</shiro:guest><shiro:user><shiro:principal/></shiro:user>!
    ( <shiro:user><a href="<c:url value="/logout"/>">Log out</a></shiro:user>
    <shiro:guest><a href="<c:url value="/login.jsp"/>">Log in</a> (sample accounts provided)</shiro:guest> )
</p>

<p>Welcome to the Apache Shiro Quickstart sample application.
    This page represents the home page of any web application.</p>


<a href="/basic">Basic auth</a> &nbsp;
<a href="/logged">Logged in area</a> &nbsp;
<a href="/user">User area</a> &nbsp;
<a href="/admin">Admin area</a>


<h2>Roles</h2>

<p>To show some taglibs, here are the roles you have and don't have. Log out and log back in under different user
    accounts to see different roles.</p>

<h3>Roles you have</h3>

<p>
    <shiro:hasRole name="ROLE_ADMIN">ROLE_ADMIN<br/></shiro:hasRole>
    <shiro:hasRole name="ROLE_USER">ROLE_USER<br/></shiro:hasRole>
    <shiro:hasRole name="ROLE_TEST">ROLE_TEST<br/></shiro:hasRole>
</p>

<h3>Roles you DON'T have</h3>

<p>
    <shiro:lacksRole name="ROLE_ADMIN">ROLE_ADMIN<br/></shiro:lacksRole>
    <shiro:lacksRole name="ROLE_USER">ROLE_USER<br/></shiro:lacksRole>
    <shiro:lacksRole name="ROLE_TEST">ROLE_TEST<br/></shiro:lacksRole>
</p>

<p>
    <shiro:hasAnyRoles name="ROLE_ADMIN, ROLE_USER, ROLE_TEST">
        You are either a admin, user or logged in.
    </shiro:hasAnyRoles>
</p>


</body>
</html>
