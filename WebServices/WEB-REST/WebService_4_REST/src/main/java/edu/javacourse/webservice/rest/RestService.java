package edu.javacourse.webservice.rest;

import javax.ws.rs.core.Response;
import java.io.File;
import java.net.URISyntaxException;

/**
 * Author: Georgy Gobozov
 * Date: 14.07.13
 */

@Path("/get")
public class RestService {


    @GET
    @Path("/file")
    @Produces("text/plain")
    public Response getFile() throws URISyntaxException {

        File file = new File(getClass().getResource("textFile.txt").toURI());
        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename='" + file.getName() + "'");
        return response.build();
    }

    @GET
    @Path("/image")
    @Produces("image/png")
    public Response getImage() throws URISyntaxException {
        File file = new File(getClass().getResource("logo.png").toURI());
        Response.ResponseBuilder response = Response.ok(file);
        response.header("Content-Disposition", "attachment; filename='" + file.getName() + "'");
        return response.build();
    }


}
