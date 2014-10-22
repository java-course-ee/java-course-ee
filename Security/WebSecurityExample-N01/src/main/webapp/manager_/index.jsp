<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manager JSP Page</title>
</head>
<body>
<h1>Hello in Manager Console!</h1>

<div>your name is '<%=request.getUserPrincipal().getName() %>'</div>
<ul>
    <li><a href="../admin/index.jsp">Admin Console</a></li>
    <li><a href="../manager_/index.jsp">Manager Console</a></li>
    <li><a href="../public/index.jsp">Public Console</a></li>
    <li><a href="../public/logout.jsp">logout</a></li>
</ul>
</body>
</html>
