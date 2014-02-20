<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="css/smoothness/jquery-ui-1.8.17.custom.css" rel="stylesheet" />	
        <script type="text/javascript" src="development-bundle/jquery-1.7.1.js"></script>
        <script type="text/javascript" src="development-bundle/ui/jquery-ui-1.8.17.custom.js"></script>
        <script type="text/javascript" src="development-bundle/ui/i18n/jquery.ui.datepicker-ru.js"></script>
        <style type="text/css">
            .ui-datepicker {
                font-size:10px;
            }
        </style>
        <script type="text/javascript">
            $(function(){
                var datepickerOpts = {
                    "dateFormat": "dd.mm.yy",
                    //                    "minDate": "-3D",
                    //                    "maxDate": "+4D",
                    "changeMonth": true,
                    "changeYear": true,
                    "showOtherMonths": true,
                    "selectOtherMonths": true,
                    //                    					"numberOfMonths": 3
                    "showOn": "both",
                    "buttonImage": "development-bundle/demos/datepicker/images/calendar.gif",
                    "buttonText": "show datepicker",
                    "buttonImageOnly": true,
                    "showAnim": 'bounce'
                };
				
                $('#datepicker').datepicker(datepickerOpts);
                $('#datepicker').datepicker(datepickerOpts, $.datepicker.regional[ "ru" ]);
                $('#inlineDatepicker').datepicker({
                    "onSelect": function(dateText){
                        $('#inputForDate').val(dateText);
                    }
                });
            });
        </script>
    </head>
    <body>
        <input type="text" id="datepicker">
        <div id="inlineDatepicker"></div>
        <input type="text" id="inputForDate">
    </body>
</html>
