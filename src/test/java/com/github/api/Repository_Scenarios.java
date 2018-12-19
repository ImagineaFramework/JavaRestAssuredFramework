package com.github.api;


import com.github.api.Pojo_Files.CreateAndModifyRepository;
import com.github.api.Pojo_Files.OutcomeRepositoryResponse;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import org.junit.Assert;
import org.omg.CORBA.TIMEOUT;
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
    public void CreateRepositoryAndListoutReposAndEdit()  {

        Random randomGenerator = new Random();
        int value = randomGenerator.nextInt(10000);

        CreateAndModifyRepository payload = new CreateAndModifyRepository();
        payload.setName(String.valueOf(value));
        System.out.println("Repo Need to be Created:"+payload.getName());

        // Below Code will create Repo
        OutcomeRepositoryResponse response  = given()
                .header("content-type", "application/json")
                .body(payload)
                .when()
                .post("/user/repos")
            .as(OutcomeRepositoryResponse.class);

        Assert.assertEquals("Expected Name and Actual Name is Not Same",payload.getName(),response.getName());

        // Below Code will List Repos Present
        OutcomeRepositoryResponse[] listResponse = given()
                .header("content-type", "application/json")
                .when()
                .get("/user/repos")
                .as(OutcomeRepositoryResponse[].class);
        System.out.println("Length of Response   :"+listResponse.length);
        for(OutcomeRepositoryResponse repoResponse : listResponse){
            System.out.println("ID   :"+repoResponse.getId());
            System.out.println("Name :"+repoResponse.getName());
        }

        CreateAndModifyRepository modifyPayload = new CreateAndModifyRepository();
        modifyPayload.setName(value+"Modified");
        System.out.println("Repo Need to be Modified with this name:"+modifyPayload.getName());

        // Below Code will modify Repo which created in first step
        OutcomeRepositoryResponse modifyResponse  = given()
                .header("content-type", "application/json")
                .body(modifyPayload)
                .when()
                .patch("/repos/pramatiimaginea/"+payload.getName())
                .as(OutcomeRepositoryResponse.class);

        System.out.println("Modified Response Name is :"+modifyResponse.getName());


        Assert.assertEquals("Verified Modified Name is not Present",modifyPayload.getName(),modifyResponse.getName());

    }

    @Test
    public void CreateRepositoryAndDeleteRepository()  {

        Random randomGenerator = new Random();
        int value = randomGenerator.nextInt(10000);

        CreateAndModifyRepository payload = new CreateAndModifyRepository();
        payload.setName(String.valueOf(value));
        System.out.println("Repo Need to be Created:"+payload.getName());

        // Below Code will create Repo
        OutcomeRepositoryResponse response  = given()
                .header("content-type", "application/json")
                .body(payload)
                .when()
                .post("/user/repos")
                .as(OutcomeRepositoryResponse.class);

        Assert.assertEquals("Expected Name and Actual Name is Not Same",payload.getName(),response.getName());

        // Below Code will Delete Repo which created in first step

        System.out.println("Repo Need to be Deleted:"+payload.getName());
        Response resp  = given()
                .when()
                .delete("repos/pramatiimaginea/"+response.getName())
                .then()
                .statusCode(204)
                .extract().response();

//        System.out.println("Modified Response Name is :"+modifyResponse.getName());


//        Assert.assertEquals("Verified Modified Name is not Present",modifyPayload.getName(),modifyResponse.getName());

    }


}
