package com.github.api;


import com.github.api.Pojo_Files.CreateRepository;
import com.github.api.Pojo_Files.OutcomeRepositoryResponse;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class Repository_Scenarios {
    @BeforeClass
    public void setBaseUri () {

        RestAssured.baseURI = "https://api.github.com";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("pramatiimaginea");
        authScheme.setPassword("Sprinklr123");
        RestAssured.authentication = authScheme;
    }

    @Test
    public void CreateRepositoryaAndListoutRepos()  {

        Random randomGenerator = new Random();
        int value = randomGenerator.nextInt(10000);

        CreateRepository payload = new CreateRepository();
        payload.setName(value);
        System.out.println("Repo Need to be Created:"+payload.getName());
        OutcomeRepositoryResponse response  = given()
                .header("content-type", "application/json")
                .body(payload)
                .when()
                .post("/user/repos")
            .as(OutcomeRepositoryResponse.class);

        Assert.assertEquals("Expected Name and Actual Name is Not Same",payload.getName(),response.getName());

        OutcomeRepositoryResponse[] listResponse = given()
                .header("content-type", "application/json")
                .body(payload)
                .when()
                .get("/user/repos")
                .as(OutcomeRepositoryResponse[].class);

        for(OutcomeRepositoryResponse repoResponse : listResponse){
            System.out.println("ID   :"+repoResponse.getId());
            System.out.println("Name :"+repoResponse.getName());
        }

    }

}
