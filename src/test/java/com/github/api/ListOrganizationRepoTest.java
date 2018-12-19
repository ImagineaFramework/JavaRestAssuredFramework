package com.github.api;

import com.github.api.Pojo_Files.OrgRepo;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
//import io.restassured.response.Response;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class ListOrganizationRepoTest {
    public  String org="SprinklrOrg";


    //@Parameters({"Username","Password"})
    @BeforeClass
    public void setBaseUri () {

        RestAssured.baseURI = "https://api.github.com";
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("PramatiImaginea");
        authScheme.setPassword("Sprinklr123");
        RestAssured.authentication = authScheme;
    }
/*@Test
        public void getList_OrgRepo(){
    Response res= given()
            .header("content-type", "application/json").param("org",org)
            .when()
            .get("/orgs/:org/repos").then().statusCode(200).extract().response();
    System.out.println(res.asString());
}*/
@Test
public void createOrgRepo(){
String RepoName="Test 3";
    OrgRepo repo=new OrgRepo();
repo.setName(RepoName);
    System.out.println("New Repo name is :"+repo.getName());
    repo=given()
            .header("content-type", "application/json")
            .body(repo)
            .when()
            .post("/orgs/"+org+"/repos")
            .as(OrgRepo.class);
    System.out.println(repo.toString());

}
       /* @Test
        public void validateResponse(){

            *//*Response res= given()
                    .header("content-type", "application/json").param("org",org)
                    .when()
                    .get("/orgs/:org/repos").then().statusCode(200).extract().response();*//*
//            System.out.println(res.asString());
            OrgRepo[] resp;
            resp = given()

                    .header("content-type", "application/json")
                    .param("org",org)
                    .when()
                    .get("/orgs/"+org+"/repos")
        //            .get()
                    .as(OrgRepo[].class);
            for(OrgRepo repResponse : resp){
                System.out.println("ID   :"+repResponse.getId());
                System.out.println("Name :"+repResponse.getName());
            }
//            System.out.println(resp.length);
//            System.out.println(resp[0].getName());
        //            .then().statusCode(200).extract().response();
        //    System.out.println(resp.asString());
        //    OrgRepo obj= get("/orgs/SprinklrOrg/repos").as(OrgRepo.class);
//            System.out.println(resp.length);

        //    System.out.println(obj.getName());

        }
*/
}
