package com.api.tests;

import com.api.base.AuthService;
import com.api.models.requests.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class SignUpAPITest {

    @Test(description="Verify signUp API")
    public void signUpTest(){
        SignUpRequest signUpReq = new SignUpRequest.Builder()
                .username("Diksha332456")
                .email("Disha324ds5@gmail.com")
                .firstName("Diksha")
                .lastName("Bhatt")
                .password("disha123")
                .mobileNumber("9888888876")
                .build();
        AuthService authServ = new AuthService();
        Response response = authServ.signUp(signUpReq);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
    }

}
