<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/dojo/1.7.1/dijit/themes/claro/claro.css">
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/dojo/1.7.1/dojo/dojo.js" data-dojo-config="isDebug: true, async: true, parseOnLoad: true"></script>
		<script type="text/javascript">
			require(["dojo", "dijit/Calendar", "dojo/domReady!"], function(dojo, Calendar){
				var cal = new Calendar({
					value: new Date(),
					onChange:function(date){
						dojo.byId('formatted').innerHTML=dojo.date.locale.format(date, {
							formatLength: 'full',
							selector:'date'
						});
					}
				}, "cal");
			});
		</script>
    </head>
    <body class="claro">
		<div id="cal"></div>
		<p id="formatted"></p>
    </body>
</html>
