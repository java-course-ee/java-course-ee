function addRegion() {
    var fs = {
        regionId : null,
        regionName : J('#newRegion').val()
    };
    RegionFacade.addRegion(fs, {
        callback:function(region) {
            var id = region.regionId;
            dwr.util.cloneNode("pattern", { 
                idSuffix:id
            });
            dwr.util.setValue("regionId"+id, region.regionId);
            dwr.util.setValue("regionName"+id, region.regionName);
            J('#regionDeleteLink' + id).attr("onclick", "deleteRegion(" + id + ")");
            $("pattern" + id).style.display = "table-row";
        }
    });
}

function findRegion() {
    RegionFacade.findRegion( {
        callback:function(list) {
            dwr.util.removeAllRows("regionbody", {
                filter:function(tr) {
                    return (tr.id != "pattern");
                }
            });

            for(var i=0; i<list.length; i++) {
                var region = list[i];
                var id = region.regionId;
                dwr.util.cloneNode("pattern", { 
                    idSuffix:id
                });
                dwr.util.setValue("regionId"+id, region.regionId);
                dwr.util.setValue("regionName"+id, region.regionName);
                J('#regionDeleteLink' + id).attr("onclick", "deleteRegion(" + id + ")");
                $("pattern" + id).style.display = "table-row";
            }
        }
    });
}

function deleteRegion(id) {
    RegionFacade.deleteRegion(id, {
        callback:function() {
            J('#pattern' + id).remove();
        },
        errorHandler:function(errorString, exception) {
            var message;
            if(exception != null) {
                message=errorString + "\n" +
                (exception.cause!=null?exception.cause.message:'');
            } else {
                message=errorString;
            }
            alert(message);
        }
    });
}