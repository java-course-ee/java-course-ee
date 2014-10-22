<%-- 
    Document   : transfer
    Created on : Jan 6, 2012, 11:04:29 PM
    Author     : APronchakov <artem.pronchakov@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Перевод средств</title>
</head>
<body>
<p>Добро пожаловать уважаемый ${person.firstName} ${person.lastName}</p>

<p>Шаг 1:</p>

<p>Перевод срадств:</p>
<s:form action="transfer-two">
    <s:select listKey="id" name="toPersonVal" list="allPersons" label="кому"/>
    <s:submit value="Далее"/>
</s:form>
</body>
</html>
