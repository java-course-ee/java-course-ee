package edu.javacourse.spring;

import edu.javacourse.spring.resource.SimpleBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.*;

public class SpringExample {

    public static void main(String[] args) {
        SpringExample se = new SpringExample();
        try {
            se.demoSpring();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void demoSpring() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});

        // Вариант прямого обращения к ресурсу - приведены примеры нескольких протоколов
        Resource template = context.getResource("edu/javacourse/spring/resource/test1.txt");
        Resource template2 = context.getResource("classpath:edu/javacourse/spring/resource/test2.txt");
        //Resource template = context.getResource("file://edu/javacourse/spring/resource/test1.txt");
        //Resource template = context.getResource("http://gemini-systems.ru/spring/resource/test1.txt");
        File f = template.getFile();
        System.out.println("File name:" + f.getAbsolutePath());

        SimpleBean sb = context.getBean("simpleResourceBean", SimpleBean.class);
        System.out.println("Resource:" + sb.getTemplate().getFile().getAbsolutePath());

        InputStream is = template2.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("line = " + line);
        }


    }
}
