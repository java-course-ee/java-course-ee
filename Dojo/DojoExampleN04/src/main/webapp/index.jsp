<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/dojo/1.7.1/dijit/themes/claro/claro.css">
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/dojo/1.7.1/dojo/dojo.js" data-dojo-config="async: true, parseOnLoad: true"></script>
		<script type="text/javascript">
			require(["dojo/parser", "dijit/Calendar", "dojo/domReady!"]);
		</script>
    </head>
    <body class="claro">
		<div data-dojo-type="dijit.Calendar" data-dojo-props="onChange:function(){dojo.byId('formatted').innerHTML=dojo.date.locale.format(arguments[0], {formatLength: 'full', selector:'date'})}"></div>
		<p id="formatted"></p>
    </body>
</html>
