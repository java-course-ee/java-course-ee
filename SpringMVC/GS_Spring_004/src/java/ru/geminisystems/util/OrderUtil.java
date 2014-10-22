package ru.geminisystems.util;


import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OrderUtil {


    public static List<Float> getCpuList(ServletContext servletContext) {
        String min = "cpu.min";
        String max = "cpu.max";
        String range = "cpu.range";
        return getProperties(servletContext, min, max, range);

    }

    public static List<Float> getHddList(ServletContext servletContext) {
        String min = "hdd.min";
        String max = "hdd.max";
        String range = "hdd.range";
        return getProperties(servletContext, min, max, range);

    }

    public static List<Float> getRamList(ServletContext servletContext) {
        String min = "ram.min";
        String max = "ram.max";
        String range = "ram.range";
        return getProperties(servletContext, min, max, range);

    }


    private static List<Float> getProperties(ServletContext servletContext, String min, String max, String range) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/classes/resources.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Float minValue = Float.parseFloat(properties.getProperty(min));
        Float maxValue = Float.parseFloat(properties.getProperty(max));
        Float rangeValue = Float.parseFloat(properties.getProperty(range));

        List<Float> list = new ArrayList<Float>();

        do {
            list.add(minValue);
            minValue += rangeValue;
        } while (minValue <= maxValue);
        return list;
    }


}
