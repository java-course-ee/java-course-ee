<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.js"></script>
    <script type="text/javascript">
        $(function () {

            $("#helloLink").click(function() {
                $.ajax({
                    "url": "helloajax",
                    "timeout": 2000,
                    "success": function (data, textStatus, jqXHR) {
                        $("#result").text(data);
                    }
                });
            });

            $("#sumButton").click(function() {
                var d1 = $("#d1").val();
                var d2 = $("#d2").val();
                $.ajax({
                    "url": "plus?d1=" + d1 + "&d2=" + d2,
                    "timeout": 2000,
                    "success": function (data, textStatus, jqXHR) {
                        $("#result").text(data);
                    }
                });
            });

        });
    </script>

    <title>Hello Ajax</title>
</head>
<body>
<a id="helloLink" href="#">Say hello ajax!</a><br/>

<input type="text" id="d1"> + <input type="text" id="d2"> = <a id="sumButton" href="#">Get result</a>

<br/><br/>

<span id="result"></span>


</body>
</html>