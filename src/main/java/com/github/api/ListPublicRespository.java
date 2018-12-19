package com.github.api;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsNull.notNullValue;

public class ListPublicRespository {


    @BeforeMethod
    public void setBaseUri() {

        RestAssured.baseURI = "https://api.github.com";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("PramatiImaginea");
        authScheme.setPassword("Sprinklr123");
        RestAssured.authentication = authScheme;
    }

    @Test
    public void getPublicRespository() {
        Response response = given()
                .header("content-type", "application/json")
                .when()
                .get("/repositories").then().
                        extract().response();
        int statusCode=response.getStatusCode();
        System.out.println("Status Code is "+statusCode);
        Assert.assertEquals(statusCode,200);
        System.out.println("Response code "+response.asString());
    }

   @Test(enabled = false)
    public void postPublicRespository() {

       String name= "Hello-World";
       String description = "This is your first repository";
        String homepage= "https://github.com";
        boolean privatee= false;
        boolean  has_issues= true;
        boolean  has_projects= true;
        boolean  has_wiki=true;

        Response response = given()
                .header("content-type", "application/json")
                .body(name)
                .body(description)
                .body(homepage)
                .body(privatee)
                .body(has_issues)
                .body(has_projects)
                .body(has_wiki)
                .expect()
                .body("status",notNullValue())
                .when()
                .post("/user/repos");
        int statusCode=response.getStatusCode();
        System.out.println("Status Code is "+statusCode);
        Assert.assertEquals(statusCode,201);
        System.out.println("Response code "+response.asString());
    }

}
