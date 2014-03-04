<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Upload</title>
</head>


<body>

<form:form method="post" enctype="multipart/form-data" action="/upload">
    <table>
        <tr>
            <td>Upload File:</td>
            <td><input type="file" name="file"/>
            </td>
            <td style="color: red; font-style: italic;">
                <form:errors path="file"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Upload"/>
            </td>
            <td></td>
        </tr>
    </table>
</form:form>

</body>
</html>