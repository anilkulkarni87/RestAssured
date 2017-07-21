package com.ak.functionalTests;

import com.ak.framework.Constants;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by anilkulkarni on 7/17/2017.
 */
public class getOperationsTest {
    @Test(priority = 0, enabled = true)
    public void validateFirstPost(){
        given().
                when()
                .get(Constants.GET_ALL).
                then()
                .assertThat()
                .body("profile.name", equalTo("typicode"));

    }

    @Test(priority = 4, enabled = true)
    public void validateQueryParam() {
        given()
                .queryParam("id", 2).
                when()
                .get(Constants.POSTS).
                then()
                .assertThat().body("author[0]", equalTo("King Kong changed"));
    }

}
