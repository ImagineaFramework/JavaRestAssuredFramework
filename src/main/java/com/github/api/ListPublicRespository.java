package com.github.api;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
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

    @Test(enabled = true)
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
        // Test 



       String jsonBody = "{" +
               "\"name\": \"Hello-World\"," +
               "\"description\": \"This is your first repository\","+
               "\"homepage\": \"https://github.com\"" +
               "\"private\": false,"+
               "\"has_issues\": true,"+
               "\"has_projects\": true,"+
               "\"has_wiki\": true  ,"+
               "}";


       /*String name= "Hello-World";
       String description = "This is your first repository";
        String homepage= "https://github.com";
        boolean privatee= false;
        boolean  has_issues= true;
        boolean  has_projects= true;
        boolean  has_wiki=true;*/

        Response response = given()
                .header("content-type", "application/json")
                .body(jsonBody)
                .when()
                .post("/user/repos");

        int statusCode=response.getStatusCode();
        System.out.println("Status Code is "+statusCode);
        Assert.assertEquals(statusCode,201);
        System.out.println("Response code "+response.asString());
    }


}
