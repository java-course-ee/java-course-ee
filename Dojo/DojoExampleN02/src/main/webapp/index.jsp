<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="js/dojo.js.uncompressed.js" data-dojo-config="async: true"></script>
		<style type="text/css">
			.quiart{
				width: 200px;
				background-color: red;
				margin-bottom: 20px;
			}

			.aqua {
				background-color: aquamarine;
				width: 100px;
				height: 100px;
			}

			.aqua-blue {
				background-color: blue;
			}
		</style>
		<script type="text/javascript">
			
			// hide
//			require(["dojo", "dojo/domReady!"], function(dojo) {
//				dojo.query('#q1').on("click", function(){
//					dojo.query(this).style("display", "none");
//				});
//			});

			require(["dojo/query", "dojo/on", "dojo/dom-style", "dojo/domReady!"], function(query, on, domStyle) {
				on(query('#q1'), "click", function(){
					domStyle.set('q1', "display", "none");
				});
                                
			});

			// no hide with duration

			// fadeOut
			require(["dojo", "dojo/_base/fx", "dojo/domReady!"], function(dojo, fx) {
				dojo.query('#q3').on("click", function(){
					fx.fadeOut({
						node: this
					}).play();
				});
			});
			
			//fadeout slowly
			require(["dojo", "dojo/_base/fx", "dojo/domReady!"], function(dojo, fx) {
				dojo.query('#q4').on("click", function(){
					fx.fadeOut({
						node: this,
						duration: 3000
					}).play();
				});
			});

			// mouse
			require(["dojo", "dojo/mouse", "dojo/domReady!"], function(dojo, mouse) {
				dojo.query('#div1').on(mouse.enter, function(){
					dojo.query(this).style("background-color", "blue");
				});
				
				dojo.query('#div1').on(mouse.leave, function(){
					dojo.query(this).style("background-color", "aquamarine");
				});
			});
		</script>
    </head>
    <body>
        <div id="q1" class="quiart">click me to hide</div>
		<div id="q3" class="quiart">click me to fadeout</div>
		<div id="q4" class="quiart">click me to fadeout slowly</div>

		<br>
		<br>
		
		<div id="div1" class="aqua"></div>
    </body>
</html>
