package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext filterContext) {
        logRequest(requestSpec); //Intercepted the API call before Request made
        Response response = filterContext.next(requestSpec,responseSpec); //Now API request is going to happen
        logResponse(response);

        return response;
    }

    public void logRequest(FilterableRequestSpecification requestSpec){
        logger.info("REQUEST INFO ---------------------\n"
                + requestSpec.getMethod() + ": " + requestSpec.getBaseUri()
                + "\nHEADERS: \n" + requestSpec.getHeaders()
                + "\nPAYLOAD: \n" + requestSpec.getBody());
    }

    public void logResponse(Response response){
        logger.info("RESPONSE INFO ---------------------\n"
                + "STATUS CODE: " + response.getStatusCode()
                + "\nHEADERS: \n" + response.getHeaders()
                + "\nRESPONSE: \n" + response.getBody().prettyPrint());
    }
}
