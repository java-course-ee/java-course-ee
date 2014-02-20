<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" href="css/smoothness/jquery-ui-1.8.17.custom.css" rel="stylesheet" />	
		<script type="text/javascript" src="development-bundle/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="development-bundle/ui/jquery-ui-1.8.17.custom.js"></script>
		<script type="text/javascript">
			$(function(){
				$('#button').click(function(){
					$.get("MyServlet", {
						"MyParam1": $('#field1').val(),
						"MyParam2": $('#field2').val()
					}, function(data){
						$('#response').text('Returned value from server: ' + data);
					});
				});
			});
		</script>
    </head>
    <body>

		<input id="field1"> +
        <input id="field2">
        <button id="button">=</button>
		<span id="response"></span>
    </body>
</html>
