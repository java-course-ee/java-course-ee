<%-- 
    Document   : index
    Created on : Dec 2, 2008, 1:23:36 PM
    Author     : ASaburov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DWR Page</title>
        
        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script type="text/javascript">
            var J = jQuery.noConflict();
        </script>
        <script type='text/javascript' src='dwr/interface/JDate.js'></script>
        <script type='text/javascript' src='dwr/interface/RegionFacade.js'></script>
        <script type='text/javascript' src='dwr/engine.js'></script>
        <script type='text/javascript' src='dwr/util.js'></script>
        <script type='text/javascript' src='scripts/Region.js'></script>
    </head>
    <body>
        <h2>Check DWR</h2>
        <input id="newRegion" type="text"><input type="button" onclick="addRegion();" value="Add"/>
        <input type="button" onclick="findRegion();" value="Find all"/>
        <input type="button" onclick="deleteRegion(J('[id^=regionId]').first().text());" value="Delete first"/>
        
        <table border="1" class="rowed grey">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Region</th>
                    <th>Delete link</th>
                </tr>
            </thead>
            <tbody id="regionbody">
                <tr id="pattern" style="display:none;">
                    <td><span id="regionId">ID</span></td>
                    <td><span id="regionName">Region</span></td>
                    <td><span id="regionDelete"><a id="regionDeleteLink" href="#">delete</a></span></td>
                </tr>
            </tbody>
        </table>
        
    </body>
</html>
