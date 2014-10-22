<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<portlet:defineObjects/>

<c:if test="${result ne null}">
    <div>

        <c:if test="${result.message ne null}"><c:out value="${result.message}"/><br/></c:if>
        <c:if test="${result.reason ne null}"><c:out value="${result.reason}"/></c:if>
    </div>
</c:if>

<portlet:actionURL var="url"/>

<form:form commandName="subscribe" name="subscribeForm" action="${url}" cssClass="niceform">
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
            <td style="font-weight:bold;" align="right">Ваш Email*</td>
            <td><form:input path="email" cssStyle="width:250px"/></td>
            <td></td>
        </tr>
        <tr>
            <td style="font-weight:bold;" align="right">Тип подписки</td>
            <td>

                <form:radiobutton path="type" value="USERS" label="Пользователи" cssStyle="margin-right:16px;"/> <br/>
                <form:radiobutton path="type" value="MEDIA" label="СМИ" cssStyle="margin-right:16px;"/>

            </td>
            <td></td>
        </tr>
        <c:if test="${allCategories ne null}">
            <tr>
                <td style="font-weight:bold;" align="right">Разделы*</td>
                <td>
                    <c:forEach items="${allCategories}" var="c">
                        <form:checkbox path="categories" label="${c.title}" value="${c.categoryId}"/><br/>
                    </c:forEach>
                </td>
                <td></td>
            </tr>
        </c:if>

        <tr>
            <td></td>
            <td><input style="width:100px;" type="submit" name="subscribe" value="Подписаться"/>&nbsp;
                <input style="width:100px;" type="submit" name="check" value="Проверить"/>
            </td>
            <td></td>
        </tr>

    </table>
</form:form>
