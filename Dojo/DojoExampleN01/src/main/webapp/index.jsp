<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
		<script src="http://ajax.googleapis.com/ajax/libs/dojo/1.7.1/dojo/dojo.js" data-dojo-config="async: true" type="text/javascript"></script>
		<script type="text/javascript">
			require(["dojo", "dojo/domReady!"], function(dojo) {
				alert('кол-во параграфов: ' + dojo.query('p').length);
				alert('общее кол-во элементов c классом some-class: ' + dojo.query('.some-class').length);
				alert('кол-во параграфов c классом some-class: ' + dojo.query('p.some-class').length);
				alert('содержание элемента с id=some-id: ' + dojo.query('#some-id')[0].innerHTML);
				alert('фильтры: первый элемент: ' + dojo.query('p:first-child')[0].innerHTML);
			});
		</script>
    </head>
    <body>
        <p id="some-id">Paragraph 1</p>
		<p class="some-class">Paragraph 2</p>
		<p>Paragraph 3</p>
		<p class="some-class">Paragraph 4</p>
		<span class="some-class">span 1</span>
    </body>
</html>
