package edu.javacourse.webservice;

import java.util.List;
//
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @author Georgy Gobozov
 */

@WebService
public interface RegionService {


    @WebMethod
    public Region [] getAllRegions();
    @WebMethod
    public Region getRegionByName(String name);



}
