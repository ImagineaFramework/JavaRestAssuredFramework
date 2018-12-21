package com.github.utils;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.PropertyConfigurator;
//import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ServerUtils {

//    final static Logger logger = Logger.getLogger(ServerUtils.class);
//    logger.warn("This is warn : " );
//

//		logger.error("This is error : " + parameter);
//		logger.fatal("This is fatal : " + parameter);

//    Logger logger = Logger.getLogger(ServerUtils.class);
//    String log4jConfigFile = System.getProperty("user.dir")+ File.separator + "log4j.properties";
//    PropertyConfigurator.configure(log4jConfigFile);
//    BasicConfigurator.configure();
//    logger.info("This is my first log4j's statement");
//    static Logger logger = Logger.getLogger(ServerUtils.class);
////public static void get
////    Logger
//    public static void setLogger(Logger logger) {
//        ServerUtils.logger = logger;
//    }
//
//    public static Logger getLogger() {
//        return logger;
//    }
    //    logger.debug("This is debug message");
//
//    logger.info("This is info message");
//    logger.warn("This is warn message");
//    logger.fatal("This is fatal message");
//    logger.error("This is error message");

    InputStream inputStream;
    @BeforeClass
    public void setBaseUri () throws IOException {

        Properties prop = new Properties();
        InputStream input = null;

        try {
//            Properties prop = new Properties();
            String propFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }


        } catch (IOException ex) {

            ex.printStackTrace();
            // get the property value and print it out
        }
//        RestAssured.baseURI = "https://api.github.com";
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(prop.getProperty("username"));
        authScheme.setPassword(prop.getProperty("password"));
        RestAssured.authentication = authScheme;

    }

}
