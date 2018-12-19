package com.github.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class WeatherAPITest {

     @Test
    public void WeatherMessageBody()
    {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Chennai");

// Retrieve the body of the Response
        ResponseBody body = response.getBody();

// By using the ResponseBody.asString() method, we can convert the  body
// into the string representation.
        System.out.println("Response Body is: " + body.asString());
        
    }
//}
}
