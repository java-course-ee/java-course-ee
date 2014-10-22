<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login JSP Page</title>
</head>
<body>
<h1>Hello in Login Page</h1>

<form action="j_security_check" method="POST">
    <table border="0">
        <tr>
            <td>Имя пользователя:</td>
            <td><input type="text" name="j_username"></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="j_password"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Login"></td>
        </tr>
    </table>
</form>
</body>
</html>
