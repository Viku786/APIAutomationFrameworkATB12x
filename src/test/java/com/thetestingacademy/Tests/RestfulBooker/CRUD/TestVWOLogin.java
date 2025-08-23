package com.thetestingacademy.Tests.RestfulBooker.CRUD;

import com.thetestingacademy.Base.BaseTest;
import com.thetestingacademy.EndPoints.APIConstants;
import com.thetestingacademy.POJOS.ResponsePojo.LoginResponse;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestVWOLogin extends BaseTest {

    @Test
    public void test_VWO_Login_Positive(){
        // Setup will first and making the request - Part - 1
        requestSpecification.baseUri(APIConstants.APP_VWO_URL);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.setLoginData()).log().all()
                .post();

        //Extraction Part - 2
        LoginResponse loginResponse = payloadManager.getLoginData(response.asString());

        // Validation and verification via the AssertJ, TestNG Part - 3
        assertActions.verifyStatusCode(response,200);

        System.out.println(loginResponse.getAccountId());
        assertActions.verifyStringKeyNotNull(loginResponse.getAccountId());
        assertActions.verifyStringKey(loginResponse.getName(),"Vikash Singh");


    }

}
