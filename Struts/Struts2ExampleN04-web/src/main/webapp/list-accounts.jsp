<%-- 
    Document   : list-accounts
    Created on : Jan 9, 2012, 6:19:57 PM
    Author     : APronchakov <artem.pronchakov@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список счетов</title>
</head>
<body>
<p>Выберите счет по которому хотите посмотреть операции:</p>
<s:form action="list-transfers">
    <s:select list="person.accountList" listKey="id" name="fromAccountVal" value="счет"/>
    <s:submit value="Показать операции"/>
</s:form>
</body>
</html>
