package com.api.tests;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class ForgotPasswordAPITest {
    @Test(description="Verify Forgot-password API response")
    public void forgotPasswordTest(){
        AuthService authServ = new AuthService();
        Response response = authServ.forgotPassword("testautomationacademy33@gmail.com");
        System.out.println(response.asPrettyString());

    }

}
