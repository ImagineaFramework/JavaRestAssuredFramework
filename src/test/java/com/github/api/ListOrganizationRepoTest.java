package com.github.api;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ListOrganizationRepoTest {
    public  String org="SprinklrOrg";
    @BeforeClass
    public void setBaseUri () {

        RestAssured.baseURI = "https://api.github.com";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("PramatiImaginea");
        authScheme.setPassword("Sprinklr123");
        RestAssured.authentication = authScheme;
    }
@Test
        public void getList_OrgRepo(){
    Response res= given()
            .header("content-type", "application/json").param("org",org)
            .when()
            .get("/orgs/:org/repos").then().extract().response();
    System.out.println(res.asString());
}

}
