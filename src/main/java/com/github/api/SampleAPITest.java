package com.github.api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleAPITest {

    //@Test
    public void exampleTest() {
        Response res = RestAssured.get("http://restapi.demoqa.com/utilities/weather/city/Chennai");
        Assert.assertEquals(200, res.getStatusCode());
        ResponseBody body= res.getBody();
        System.out.println("Code is "+body.asString());

       /* Assert.assertEquals("", jp.get("email"));
        Assert.assertEquals("Onur", jp.get("firstName"));
        Assert. assertEquals("Baskirt", jp.get("lastName"));*/
    }
    @Test
    public void exampleInBDDTest() {
        Response response = given()
                .header("content-type", "application/json")
                .when()
                .get("http://restapi.demoqa.com/utilities/weather/city/Chennai").then().extract().response();
        System.out.println(response.asString());


    }




}
