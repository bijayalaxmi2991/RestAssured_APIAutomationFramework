package com.api.tests;

import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.responses.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest3 {

    @Test(description="Verify Login API is working with valid credentials")
    public void loginTest(){
        LoginRequest loginRequest = new LoginRequest("uday123","uday123");
        AuthService authService  = new AuthService();
        Response response = authService.login(loginRequest);

        System.out.println(response.asPrettyString());
        //Deserialization of the response
        //response is in JSON object
        // .as is going to convert the JSON object into Java object and return the Java object of the class "LoginResponse"
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getRoles().get(0));

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(loginResponse.getToken() != null);
//        Assert.assertEquals(loginResponse.getEmail(), "vicky@gmail.com");
        Assert.assertEquals(loginResponse.getId(), 305);


    }
}
