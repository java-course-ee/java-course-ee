<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Project</td>
        <td>Users</td>
        <td>Actions</td>
    </tr>
    <c:forEach items="${tasks}" var="t">
        <tr>
            <td><c:out value="${t.name}"/></td>
            <td><c:out value="${t.project.name}"/></td>
            <td>
                <c:forEach var="u" items="${t.users}">
                    <c:out value="${u.name}"/>&nbsp;
                </c:forEach>
            </td>
            <td><a href="tasks/edit/${t.taskId}">Edit</a>&nbsp;<a href="tasks/delete/${t.taskId}">Delete</a></td>

        </tr>
    </c:forEach>
</table>
<br>

<form:form commandName="task" method="POST">
    <form:hidden path="taskId"/>

    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name"/></td>

        </tr>

        <tr>
            <td>Project</td>
            <td><form:select path="project" items="${projects}" itemLabel="name" itemValue="projectId"/></td>
            <td><form:errors path="project"/></td>
        </tr>

        <tr>
            <td>Users</td>
            <td><form:select path="users" items="${users}" multiple="multiple" size="5" itemLabel="name"
                             itemValue="userId"/></td>
            <td><form:errors path="users"/></td>
        </tr>

        <tr>
            <td></td>
            <td align="right"><input type="submit" value="submit"></td>
            <td></td>
        </tr>


    </table>


</form:form> 