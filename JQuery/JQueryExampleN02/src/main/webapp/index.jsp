<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-1.7.1.js"></script>
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
            $(function(){
                $('#q1').click(function(){
                    $(this).hide();
                });
				
                $('#q2').click(function(){
                    $(this).hide(3000);
                });
                
                //                 $('#q2').click(function(){
                //                    $(this).hide(3000, function(){
                //                         $(this).show();
                //                    });
                //                });
				
                $('#q3').click(function(){
                    $(this).fadeOut();
                });
				
                $('#q4').click(function(){
                    $(this).fadeOut(3000);
                });
				
                $('#but1').click(function(){
                    $('#div1').toggle();
                });
				
                $('#but2').click(function(){
                    $('#div1').slideToggle();
                });
				
                //                $('#div1').mouseover(function(){
                //                    $(this).css('background-color', 'blue');
                //                });
                //				
                //                $('#div1').mouseout(function(){
                //                    $(this).css('background-color', 'aquamarine');
                //                });
				
//                				$('#div1').hover(function(){
//                					$(this).css('background-color', 'blue');
//                				}, function(){
//                					$(this).css('background-color', 'aquamarine');
//                				});
				
                				$('#div1').hover(function(){
                					$(this).toggleClass('aqua-blue');
                				});
            })
        </script>
    </head>
    <body>
        <div id="q1" class="quiart">click me to hide</div>
        <div id="q2" class="quiart">click me to hide slowly</div>
        <div id="q3" class="quiart">click me to fadein</div>
        <div id="q4" class="quiart">click me to fadein slowly</div>

        <br>
        <br>

        <button id="but1">click to toggle aquamarine div</button>
        <button id="but2">click to slide aquamarine div</button>
        <div id="div1" class="aqua"></div>
    </body>
</html>
