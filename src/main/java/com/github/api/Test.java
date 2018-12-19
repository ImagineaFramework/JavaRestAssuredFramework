package com.github.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.registerParser;
import static org.hamcrest.core.Is.is;

public class Test {


   @org.testng.annotations.Test
    public void listGet() {

       RestAssured.baseURI = "https://github.com/jayaprakashr7?tab=repositories";
       RequestSpecification httpRequest = RestAssured.given();
       Response response = httpRequest.get();
       int statusCode = response.getStatusCode();
       System.out.println("Code is " + statusCode);

       Assert.assertEquals(statusCode,200);

        /*ResponseBody body=response.getBody();
        String bodyOF=body.asString();
       System.out.println(bodyOF);*/
   }

}



