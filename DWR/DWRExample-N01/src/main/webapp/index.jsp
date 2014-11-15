<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DWR Page</title>

    <style type="text/css">
        th, td {
            width: 150px;
            border: 1px solid black;
        }
    </style>

    <script src="http://code.jquery.com/jquery-2.1.1.js"></script>

    <script type='text/javascript' src='dwr/interface/JDate.js'></script>
    <script type='text/javascript' src='dwr/interface/RegionFacade.js'></script>
    <script type='text/javascript' src='dwr/engine.js'></script>
    <script type="text/javascript">
        function appendRegion(region) {
            var row = $('<tr id="row-' + region.regionId + '">' +
            '<td><span id="regionId">' + region.regionId + '</span></td>' +
            '<td><span id="regionName">' + region.regionName + '</span></td>' +
            '<td><span id="regionDelete"><a id="regionDeleteLink" href="#">delete</a></span></td>' +
            '</tr>').hide();

            $(row).find('#regionDeleteLink').click(function () {
                del(region.regionId);
            });

            $('#regionbody').append(row);
            $(row).fadeIn(200);
        }

        function add() {
            var newRegionData = {
                regionId: null,
                regionName: $('#newRegionName').val()
            };
            RegionFacade.addRegion(newRegionData, {
                        callback: appendRegion
                    }
            )
        }

        function find() {
            RegionFacade.findRegion({
                callback: function (list) {
                    $('#regionbody tr').remove();
                    for (var i = 0; i < list.length; i++) {
                        appendRegion(list[i])
                    }
                }
            });
        }

        function del(id) {
            RegionFacade.deleteRegion(id, {
                callback: function () {
                    $('#row-' + id).fadeOut(200, function () {
                        $(this).remove();
                    });
                },
                errorHandler: function (errorString, exception) {
                    var message;
                    if (exception != null) {
                        message = errorString + "\n" +
                        (exception.cause != null ? exception.cause.message : '');
                    } else {
                        message = errorString;
                    }
                    alert(message);
                }
            });
        }
    </script>
</head>
<body>
<h2>Check DWR</h2>
<input id="newRegionName" type="text">
<input type="button" onclick="add();" value="Add"/>
<input type="button" onclick="find();" value="Find all"/>
<input type="button" onclick="del($('[id^=regionId]').first().text());" value="Delete first"/>
<input type="button" onclick="del($('[id^=regionId]').last().text());" value="Delete last"/>

<table id="regionTable" class="rowed grey">
    <thead>
    <tr>
        <th>ID</th>
        <th>Region</th>
        <th>Delete link</th>
    </tr>
    </thead>
    <tbody id="regionbody">
    </tbody>
</table>

</body>
</html>
