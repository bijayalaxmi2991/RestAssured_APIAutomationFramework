package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.requests.ProfileUpdateRequest;
import com.api.models.responses.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class UpdateProfileAPITest {
    @Test(description="Verify Get Profile API call")
    public void updateProfileTest() {
        //First login
        //Then Get Profile service works

        LoginRequest loginRequest = new LoginRequest("uday123", "uday123");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        Assert.assertTrue(loginResponse.getToken() != null);
        String token = loginResponse.getToken();
        System.out.println(token);

        UserManagementService userManSer = new UserManagementService();
        ProfileUpdateRequest updateRequest = new ProfileUpdateRequest.Builder()
                .firstName("Ahaan")
                .lastName("Sharma")
                .email("Ahaanshama1213@gmail.com")
                .mobileNumber("9892343323")
                .build();
        response = userManSer.updateProfile(token,updateRequest);
        System.out.println(response.asPrettyString());
    }
}
