<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Form</title>
</head>
<body>
<s:form action="login-action">
    <s:textfield name="loginBean.username" label="Имя пользователя"/>
    <s:password name="loginBean.password" label="Пароль"/>
    <s:submit label="Войти"/>
</s:form>
</body>
</html>
