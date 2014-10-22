<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Logout JSP Page</title>
</head>
<body>
<% session.invalidate(); %>
<h1>You have been successfully logout</h1>
<ul>
    <li><a href="../admin/index.jsp">Admin Console</a></li>
    <li><a href="../manager_/index.jsp">Manager Console</a></li>
    <li><a href="../public/index.jsp">Public Console</a></li>
</ul>
</body>
</html>
