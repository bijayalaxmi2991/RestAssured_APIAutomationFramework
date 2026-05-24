package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.responses.LoginResponse;
import com.api.models.responses.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class GetProfileAPITest {
    @Test(description="Verify Get Profile API call")
    public void gotProfileTest(){
        //First login
        //Then Get Profile service works

        LoginRequest loginRequest = new LoginRequest("uday123","uday123");
        AuthService authService  = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        Assert.assertTrue(loginResponse.getToken() != null);
        String token = loginResponse.getToken();
        System.out.println(token);

        UserManagementService userManSer = new UserManagementService();
        response = userManSer.getProfile(token);
        UserProfileResponse userResponse = response.as(UserProfileResponse.class);
        System.out.println(userResponse.toString());
        System.out.println(userResponse.getUsername());

    }
}
