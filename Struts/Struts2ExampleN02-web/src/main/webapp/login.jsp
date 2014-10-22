<%-- 
    Document   : index
    Created on : Jan 4, 2012, 9:42:40 PM
    Author     : APronchakov <artem.pronchakov@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Form</title>
    <s:head/>
</head>
<body>
<s:form action="login-action">
    <s:textfield key="loginBean.username"/>
    <s:textfield key="loginBean.password"/>
    <s:submit key="enter"/>
</s:form>
</body>
</html>
