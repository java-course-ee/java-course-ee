<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="js/dojo.js.uncompressed.js" data-dojo-config="async: true"></script>
		<script type="text/javascript">
			require(["dojo", "dojo/_base/xhr", "dojo/domReady!"], function(dojo, ajax){
				dojo.query('#button').on("click", function(){
					ajax.get({
						url: "GetRandom",
						timeout: 1000,
						load: function(data, ioargs) {
							var result = dojo.query('#result')[0];
							result.innerHTML = ioargs.xhr.status + ": " + data;
						},
						error: function(error){
							var result = dojo.query('#result')[0];
							result.innerHTML = error;
						},
						handle: function(error, ioargs){
							var message = "";
							switch(ioargs.xhr.status){
								case 200:
								message = "200: Good request. ";
								break;
								case 404:
								message = "404: The requested page was not found";
								break;
								case 500:
								message = "500: The server reported an error.";
								break;
								case 407:
								message = "407: You need to authenticate with a proxy.";
								break;
								default:
								message = "Unknown error.";
							}
							dojo.query('#info')[0].innerHTML = error + ': ' +message;
						}
					});
				});
			});
		</script>
    </head>
    <body>
		<button id="button">click to get next random value</button><br>
		Info message: <span id="info" style="color: blue"></span><br>
		Result: <span id="result" style="color: red"></span><br>
    </body>
</html>
