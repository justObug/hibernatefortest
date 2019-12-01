package com.example.springbootforautomation;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


@SpringBootApplication
public class SpringbootforautomationApplication {
    //global
    public static boolean started = false;

    private static ApplicationContext ac;

    public static ApplicationContext get(){
        return ac;
    }


    public static void main(final String[] args) throws Exception {
        ac = SpringApplication.run(SpringbootforautomationApplication.class, args);
        started = true;

        ApplicationHome ah = new ApplicationHome(SpringbootforautomationApplication.class);
        File jarFile = ah.getSource();
        String url = jarFile.getParent().toString();
        InputStream testngStream = SpringbootforautomationApplication.class.getClassLoader().getResourceAsStream("testng.xml");
        File testngFile = new File( url + "/testng.xml");
        try{
            FileUtils.copyInputStreamToFile(testngStream, testngFile);
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(url);
        org.testng.TestNG.main(new String[]{url + "/testng.xml"});
    }

}