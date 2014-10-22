<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<portlet:defineObjects/>

<portlet:actionURL var="url"/>

<form:form commandName="subscribe" action="${url}" cssClass="niceform">
    <table>
        <tr>
            <td></td>
            <td>
                <form:errors path="email" cssStyle="background-color:orange;font-weight:bold;"/>
                <form:errors path="categories" cssStyle="background-color:orange;font-weight:bold;"/>
            </td>
            <td></td>
        </tr>
        <tr>
            <td style="font-weight:bold;" align="right">Ваш Email</td>
            <td><form:input path="email" readonly="true" cssStyle="width:250px"/></td>
            <td></td>
        </tr>
        <tr>
            <td style="font-weight:bold;" align="right">Тип подписки</td>
            <td>
                <form:radiobutton path="type" value="USERS" label="   Пользователи"/> <br/>
                <form:radiobutton path="type" value="MEDIA" label="   СМИ"/>

            </td>
            <td></td>
        </tr>
        <c:if test="${allCategories ne null}">
            <tr>
                <td style="font-weight:bold;" align="right">Разделы</td>
                <td>
                    <form:checkboxes path="categories" delimiter="<br/>" items="${allCategories}" itemLabel="title"
                                     itemValue="categoryId"/>
                </td>
                <td><form:errors path="categories"/></td>
            </tr>
        </c:if>
        <tr>
            <td></td>
            <td>
                <input style="width:100px;" type="submit" name="edit" value="Сохранить"/>
                <input style="width:150px;" type="submit" name="delete" value="Прекратить подписку"/>
            </td>
            <td></td>

        </tr>

    </table>
</form:form>