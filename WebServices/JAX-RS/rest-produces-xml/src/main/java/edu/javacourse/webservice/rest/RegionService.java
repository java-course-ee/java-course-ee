package edu.javacourse.webservice.rest;

import model.Region;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Author: Georgy Gobozov
 * Date: 14.07.13
 */

@ApplicationPath("/rest")
@Path("/regions")
public class RegionService extends Application {


    Map<String, Region> regions = new HashMap<String, Region>();

    @PostConstruct
    public void init() {
        regions.put("1", new Region(1, "Moscow", 10000000));
        regions.put("2", new Region(2, "SPB", 7000000));
        regions.put("3", new Region(3, "Ekaterinburg", 2000000));
    }


    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Region getRegion(@PathParam("id") String id) {
        Region region = regions.get(id);
        return region != null ? region : null;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_XML)
    public List<Region> getAll() throws URISyntaxException {
        return new ArrayList<Region>(regions.values());
    }


    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_XML)
    public Collection<Region> queryFormParams(@FormParam("name") String name, @FormParam("population") int population) throws URISyntaxException {
        int next = regions.size() + 1;
        regions.put(String.valueOf(next), new Region(next, name, population));
        return getAll();
    }


}
