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
<p>Шаг 2:</p>

<p>Перевод срадств от <s:property value="person.firstName"/> <s:property value="person.lastName"/> к <s:property
        value="toPerson.firstName"/> <s:property value="toPerson.lastName"/>:</p>
<s:form action="do-transfer">
    <s:select listKey="id" name="fromAccountVal" list="person.accountList" label="со счета"/>
    <s:select listKey="id" name="toPersonAccountVal" list="toPerson.accountList" label="на счет"/>
    <s:textfield name="amount" label="сумма"/>
    <s:textfield name="comment" label="Комментарий"/>
    <s:submit value="Отправить перевод"/>
</s:form>
</body>
</html>