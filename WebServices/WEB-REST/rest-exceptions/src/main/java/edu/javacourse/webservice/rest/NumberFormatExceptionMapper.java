package edu.javacourse.webservice.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Intern on 06.11.14.
 */
@Provider
public class NumberFormatExceptionMapper implements ExceptionMapper<NumberFormatException> {
    @Override
    public Response toResponse(NumberFormatException e) {
        return Response.ok(new String("Ups")).build();
    }
}
