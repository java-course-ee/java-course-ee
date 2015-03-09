<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jersey test</title>
</head>
<body>

<form action="rest/regions/add" method="post">
    <p>
        Name : <input type="text" name="name"/>
    </p>

    <p>
        Population : <input type="text" name="population"/>
    </p>
    <input type="submit" value="Add Region"/>
</form>

</body>
</html>