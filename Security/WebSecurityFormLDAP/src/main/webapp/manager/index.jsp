<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manager</title>
</head>
<body>
<h1>Hello <%=request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "Guest" %></h1>
</body>
</html>
