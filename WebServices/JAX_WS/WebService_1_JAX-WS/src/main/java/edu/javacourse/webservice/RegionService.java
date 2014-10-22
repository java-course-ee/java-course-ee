package edu.javacourse.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

//

/**
 * @author Georgy Gobozov
 */

@WebService
public interface RegionService {


    @WebMethod
    public Region[] getAllRegions();

    @WebMethod
    public Region getRegionByName(String name);


}
