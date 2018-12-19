//package com.github.api.SearchApi;
//
//import com.github.api.Pojo_Files.CreateRepository;
//import com.github.api.Pojo_Files.OutcomeRepositoryResponse;
//import io.restassured.RestAssured;
//import io.restassured.authentication.PreemptiveBasicAuthScheme;
//import io.restassured.response.Response;
//import org.junit.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.Random;
//
//import static io.restassured.RestAssured.*;
//
//public class SearchRepo {
//
//    @BeforeClass
//    public void setBaseUri() {
//
//        RestAssured.baseURI = "https://api.github.com";
//        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
//        authScheme.setUserName("pramatiimaginea");
//        authScheme.setPassword("Sprinklr123");
//        RestAssured.authentication = authScheme;
//    }
//
//    @Test
//    public void SearchRepositories() {
//
//        Response response  =
//                given()
//                .header("content-type", "application/json")
//                .params("q", "Repo", "sort", "stars", "order", "asc").log().all()
//                .when()
//                .get("/search/repositories").then().extract().response();
//
//        System.out.println(response.prettyPeek().asString());
//
//
//    }
//}