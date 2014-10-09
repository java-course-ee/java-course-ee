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
<portlet:renderURL var="url" portletMode="VIEW"/>
<form:form action="${url}" cssClass="niceform">
    	<input type="submit" value="Ок"/>
</form:form>