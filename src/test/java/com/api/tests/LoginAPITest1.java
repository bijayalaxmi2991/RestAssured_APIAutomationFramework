// http://64.227.160.186:8080/swagger-ui/index.html#/Authentication/authenticateUser
// URL: http://64.227.160.186:8080/api/auth/login
// BaseURL: http://64.227.160.186:8080
// path: /api/auth/
// endpoint: login
//"username": "uday123",
//"password": "uday123"

package com.api.tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class LoginAPITest1 {

    @Test(description="Verify Login API is working with valid credentials")
    public void loginTest(){

        RestAssured.baseURI = "http://64.227.160.186:8080";
        RequestSpecification x = RestAssured.given();
        RequestSpecification y = x.header("Content-Type","application/json");
        RequestSpecification z = y.body("{\"username\": \"uday123\", \"password\": \"uday123\"}");
        Response response = z.post("/api/auth/login");

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);

    }
}
