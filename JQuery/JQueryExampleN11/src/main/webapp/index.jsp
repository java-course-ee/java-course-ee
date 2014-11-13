<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#button').click(function () {
                $.ajax({
                    "url": "GetRandom",
                    "timeout": 2000,
                    "beforeSend": function () {
                        $('#info').text("Requesting new random value...");
                    },
                    "success": function (data, textStatus, jqXHR) {
                        $('#result').text(textStatus + ': ' + data);
                    },
                    "error": function (jqXHR, textStatus, errorThrown) {
                        $('#result').text(textStatus + ':' + errorThrown);
                    },
                    "complete": function (jqXHR, textStatus) {
                        $('#info').text("Request was completely done with status: " + textStatus);
                    }
                });
            });
        });
    </script>
</head>
<body>
<button id="button">click to get next random value</button>
<br>
Info message: <span id="info" style="color: blue"></span><br>
Result: <span id="result" style="color: red"></span><br>
</body>
</html>
