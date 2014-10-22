<%-- 
    Document   : list
    Created on : Jan 6, 2012, 11:06:31 PM
    Author     : APronchakov <artem.pronchakov@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список операций</title>
</head>
<body>
<h2>Информация по счету ${fromAccount}</h2>
<table border="1" bordercolor="#000000" style="background-color: whitesmoke;" width="500" cellpadding="1"
       cellspacing="0">
    <thead>
    <tr>
        <th colspan="3">Список входящих операций</th>
    </tr>
    <tr>
        <th>От кого</th>
        <th>Сумма</th>
        <th>Комментарий</th>
    </tr>
    </thead>
    <tbody
    <c:forEach items="${fromAccount.incommingTransfers}" var="transfer">
        <tr>
            <td>${transfer.sendersAccount.owner.firstName} ${transfer.sendersAccount.owner.lastName}</td>
            <td style="color: blue;">${transfer.amount}</td>
            <td>${transfer.comment}</td>
        </tr>
    </c:forEach>
    <c:if test="${fn:length(fromAccount.incommingTransfers) == 0}">
        <tr>
            <td colspan="3" align="center" style="color:red;">Транзакций нет</td>
        </tr>
    </c:if>
    </tbody>
</table>

<table style="margin-top: 50px;background-color: whitesmoke;" border="1" bordercolor="#000000" width="500"
       cellpadding="1" cellspacing="0">
    <thead>
    <tr>
        <th colspan="3">Список исходящих операций</th>
    </tr>
    <tr>
        <th>Кому</th>
        <th>Сумма</th>
        <th>Комментарий</th>
    </tr>
    </thead>
    <tbody
    <c:forEach items="${fromAccount.outcommingTransfers}" var="transfer">
        <tr>
            <td>${transfer.recieversAccount.owner.firstName} ${transfer.recieversAccount.owner.lastName}</td>
            <td style="color: red;"> -${transfer.amount}</td>
            <td>${transfer.comment}</td>
        </tr>
    </c:forEach>
    <c:if test="${fn:length(fromAccount.outcommingTransfers) == 0}">
        <tr>
            <td colspan="3" align="center" style="color:red;">Транзакций нет</td>
        </tr>
    </c:if>
    </tbody>
</table>
<%@include file="WEB-INF/jspf/links.jspf" %>
</body>
</html>
