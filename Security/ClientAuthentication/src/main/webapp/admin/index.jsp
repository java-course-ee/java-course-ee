<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Admin Zone</h1>

<h3><%=request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "Not logged in." %>
</h3>
</body>
</html>
