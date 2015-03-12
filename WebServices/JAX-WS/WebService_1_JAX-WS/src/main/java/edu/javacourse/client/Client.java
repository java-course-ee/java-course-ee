package edu.javacourse.client;

import edu.javacourse.webservice.Region;
import edu.javacourse.webservice.RegionService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * Author: Georgy Gobozov
 * Date: 14.07.13
 */
public class Client {


    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9999/ws/regionService?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://webservice.javacourse.edu/", "RegionServiceImplService");

        Service service = Service.create(url, qname);

        RegionService regionService = service.getPort(RegionService.class);

        System.out.println(regionService.getRegionByName("Voronezh"));

        Region[] regions = regionService.getAllRegions();
        for (Region region : regions) {
            System.out.println("region = " + region);
        }

    }

}
