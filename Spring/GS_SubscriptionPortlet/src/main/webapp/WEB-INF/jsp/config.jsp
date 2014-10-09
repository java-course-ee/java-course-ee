<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<portlet:defineObjects/>

<portlet:actionURL var="url"/>


<c:if test="${message ne null}"><c:out value="${message}"/></c:if>


<h2>Разделы для подписки</h2>
<table border="1" cssClass="niceform">
    <c:forEach items="${categories}" var="c">
        <tr>
            <td><c:out value="${c.title}"/></td>
            <td><c:forEach items="${c.paths}" var="p">
                    <c:out value="${p.pathValue}"/>,
                </c:forEach>
            </td>
            <td><c:out value="${c.atName}"/></td>
            <td><a href="<portlet:actionURL><portlet:param name="delete" value="${c.categoryId}"/></portlet:actionURL>">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>


<br/>

<h2>Создать новый раздел</h2>
<form:form action="${url}" commandName="category" cssClass="niceform">
    <table>
        <tr>
            <td>Заголовок категории*</td>
            <td><form:input path="title" cssStyle="width:250px"/></td>
            <td><form:errors path="title"/></td>
        </tr>
        <tr>
            <td>Пути до области WCM (web+content/...,web+content/...)*</td>
            <td><form:input path="paths" cssStyle="width:250px"/></td>
            <td><form:errors path="paths"/></td>
        </tr>
        <tr>
            <td>Имя шаблона создания</td>
            <td><form:input path="atName" cssStyle="width:250px"/></td>
            <td><form:errors path="atName"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input style="width:150px;" type="submit" name="create" value="Создать"/></td>
            <td></td>
        </tr>
    </table>


    <br/>
    <hr/>
    <br/>

    <select name="logLevel">
        <option <c:if test="${loglevel == 'INFO'}"> selected="selected"</c:if> value="INFO">INFO</option>
        <option <c:if test="${loglevel == 'DEBUG'}"> selected="selected"</c:if> value="DEBUG">DEBUG</option>
    </select>
    <input style="width:150px;" type="submit" name="setLog" value="Задать"/>
    <br/>
    <hr/>
    <br/>
    <input type="submit" name="runjob" value="Запустить рассылку для пользоватлей"/></br>
    <input type="submit" name="runjobSMI" value="Запустить рассылку для СМИ"/>
</form:form>


