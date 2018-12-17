package com.github.api;


import com.github.api.Pojo_Files.CreateRepository;
import com.github.api.Pojo_Files.CreateRepositoryResponse;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import org.junit.Assert;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class Repository_Scenarios {
    @BeforeClass
    public void setBaseUri () {

        RestAssured.baseURI = "https://api.github.com";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("PramatiImaginea");
        authScheme.setPassword("Sprinklr123");
        RestAssured.authentication = authScheme;
    }

    @Test
    public void CreateRepository()  {

        Random randomGenerator = new Random();
        System.out.println(randomGenerator.nextInt(10000));
        int value = randomGenerator.nextInt(10000);

        CreateRepository payload = new CreateRepository();
        payload.setName(value);
        System.out.println(payload.getName());
        CreateRepositoryResponse response  = given()
                .header("content-type", "application/json")
                .body(payload)
                .when()
                .post("/user/repos")
        .as(CreateRepositoryResponse.class);

        System.out.println(response.getId());
        System.out.println(response.getName());
        Assert.assertEquals(payload.getName(),response.getName());


    }

}
