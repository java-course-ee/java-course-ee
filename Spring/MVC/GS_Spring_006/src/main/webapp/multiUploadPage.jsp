<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Upload</title>
</head>


<body>

<form:form method="post" enctype="multipart/form-data" modelAttribute="fileBucket" action="/multiupload">
    <table>
        <tr>
            <td>Upload File 1:</td>
            <td>
                <input name="files[0]" type="file"/>
            </td>
        </tr>
        <tr>
            <td>Upload File 2:</td>
            <td>
                <input name="files[1]" type="file"/>
            </td>
        </tr>
        <tr>
            <td>Upload File 3:</td>
            <td>
                <input name="files[2]" type="file"/>
            </td>
        </tr>
        <tr>

            <td>
                <input type="submit" value="Upload"/>
            </td>
            <td></td>
        </tr>
    </table>
</form:form>

</body>
</html>