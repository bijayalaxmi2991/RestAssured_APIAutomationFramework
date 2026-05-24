package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.requests.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
This class is a wrapper of RestAssured
Below is handled within this class
1) Sets the Base URI
2) Creation of request
3) Handles the response
 */
public class BaseService {

    //BASE_URL - class variable as its static
    private static final String BASE_URL = "http://64.227.160.186:8080";
    //reqSpec - instance variable as its non-static
    private RequestSpecification reqSpec;

    static{
        RestAssured.filters(new LoggingFilter());
    }
    //constructor
    public BaseService(){
        reqSpec = given().baseUri(BASE_URL);
    }

    protected void setAuthToken(String token){
        reqSpec.header("Authorization", "Bearer "+token);
    }

    protected Response getRequest(String endPoint){
        return reqSpec.get(endPoint);
    }

    protected Response postRequest(Object payload, String endPoint){
        return reqSpec.contentType(ContentType.JSON).body(payload).post(endPoint);
    }

    protected Response putRequest(Object payload, String endPoint){
        return reqSpec.contentType(ContentType.JSON).body(payload).put(endPoint);
    }

    protected Response patchRequest(Object payload, String endPoint){
        return reqSpec.contentType(ContentType.JSON).body(payload).patch(endPoint);
    }


}
