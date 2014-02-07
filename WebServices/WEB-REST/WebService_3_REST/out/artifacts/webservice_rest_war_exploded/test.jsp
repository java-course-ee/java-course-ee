<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jersey test</title>
</head>
<body>

<form action="rest/hello/add" method="post">
    <p>
        Name : <input type="text" name="name" />
    </p>
    <p>
        Age : <input type="text" name="age" />
    </p>
    <input type="submit" value="Add User" />
</form>

</body>
</html>