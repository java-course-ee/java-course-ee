<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <script type="text/javascript">


        function getXmlHttp() {
            var xmlhttp;
            try {
                xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (E) {
                    xmlhttp = false;
                }
            }
            if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
                xmlhttp = new XMLHttpRequest();
            }
            return xmlhttp;
        }

        function sayHello() {
            var xmlhttp = getXmlHttp();
            xmlhttp.open('GET', '/helloajax', false);
            xmlhttp.send(null);
            if (xmlhttp.status == 200) {
                alert(xmlhttp.responseText);

            }
        }

        function plus() {
            var xmlhttp = getXmlHttp();
            var d1value = document.getElementById("d1").value;
            var d2value = document.getElementById("d2").value;
            xmlhttp.open('GET', '/plus?d1=' + d1value + '&d2=' + d2value, false);
            xmlhttp.send(null);
            if (xmlhttp.status == 200) {
                //alert(xmlhttp.responseText);
                document.getElementById("result").innerHTML = xmlhttp.responseText;
            } else {
                alert("Error " + xmlhttp.responseText);
            }
        }


    </script>

    <title>Hello Ajax</title>
</head>
<body>
<a href="javascript:void(0);" onclick="sayHello();">Say hello ajax!</a><br/>

<input type="text" id="d1"> + <input type="text" id="d2"> = <input onclick="plus();" type="button" value="Get result">
<span id="result"></span>


</body>
</html>