package com.api.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginAPITest2 {

    @Test(description="Verify Login API is working with valid credentials")
    public void loginTest(){
        Response response = given()
                .baseUri("http://64.227.160.186:8080")
                .header("Content-Type","application/json")
                .body("{\"username\": \"uday123\", \"password\": \"uday123\"}")
                .post("/api/auth/login");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200);

    }
}
