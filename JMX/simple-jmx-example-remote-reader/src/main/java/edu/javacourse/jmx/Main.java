package edu.javacourse.jmx;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * @author Artem Pronchakov artem.pronchakov@ocrv.ru
 */
public class Main {

    public static void main(String[] args) throws Exception {
        JMXServiceURL serviceUrl = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:33655/jmxrmi");
        JMXConnector jmxConnector = JMXConnectorFactory.connect(serviceUrl, null);

        MBeanServerConnection mbeanConn = jmxConnector.getMBeanServerConnection();

        ObjectName objectName = new ObjectName("edu.javacourse.jmx:name=Statistics");
        while(true) {
            Object currentTime = mbeanConn.getAttribute(objectName, "CurrentTime");
            Object randomNumber = mbeanConn.getAttribute(objectName, "RandomNumber");

            System.out.println(currentTime.getClass().getCanonicalName() + ": " + currentTime);
            System.out.println(randomNumber.getClass().getCanonicalName() + ": " + randomNumber);
            System.out.println();

            Thread.sleep(2000);
        }
    }

}
