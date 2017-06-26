package edu.javacourse.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author Artem Pronchakov artem.pronchakov@ocrv.ru
 */
public class Main {
    public static void main(String[] args) throws Exception {
        StatisticsBean statisticsBean = new StatisticsBean();
        MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("edu.javacourse.jmx:name=Statistics");
        mbeanServer.registerMBean(statisticsBean, objectName);

        System.out.println("Press any key to exit...");
        System.in.read();
    }
}
