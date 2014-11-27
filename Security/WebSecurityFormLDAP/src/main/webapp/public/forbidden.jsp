<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Forbidden!</title>
</head>
<body>
<h1>Forbidden!</h1>
<h3>User: <%=request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "not logged in"%></h3>
</body>
</html>
