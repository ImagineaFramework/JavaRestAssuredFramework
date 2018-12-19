package com.github.api;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ListContributors {


    @BeforeMethod
    public void setBaseUri() {

        RestAssured.baseURI = "https://api.github.com";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("PramatiImaginea");
        authScheme.setPassword("Sprinklr123");
        RestAssured.authentication = authScheme;
    }

    @Test
    public void getContributors() {
        Response response = given()
                .header("content-type", "application/json")
                .when()
                .get("/users/contributors").then().
                        extract().response();
        int statusCode=response.getStatusCode();
        System.out.println("Status Code is "+statusCode);
        Assert.assertEquals(statusCode,200);
        System.out.println("Response code "+response.asString());
    }
}





