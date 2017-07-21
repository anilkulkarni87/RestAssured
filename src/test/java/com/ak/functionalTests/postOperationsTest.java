package com.ak.functionalTests;

import com.ak.framework.Constants;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * Created by anilkulkarni on 7/17/2017.
 * Get the max id from the existing Dataset
 * Save it in a variable and pass it on to
 * the test method.
 */
public class postOperationsTest {
    private int newId;

    @BeforeClass
    public void getMaxId() {
        newId =
                given()
                        .queryParam(Constants.SORT, "id")
                        .queryParam(Constants.ORDER, "desc")
                        .queryParam(Constants.LIMIT, 1).

                        when()
                        .get(Constants.POSTS).
                        then()
                        .extract()
                        .path("id[0]");
        newId = newId + 1;
    }
    @Test(priority = 1)
    public void httpPost(){
        HashMap<String,Object> jsonAsMap=new HashMap<String, Object>();
        Faker faker = new Faker();

        jsonAsMap.put("id", newId);
        jsonAsMap.put("title", faker.shakespeare().asYouLikeItQuote());
        jsonAsMap.put("author", faker.name().fullName());
        given()
                .contentType("application/json")
                .body(jsonAsMap).
                when()
                .post(Constants.POSTS).
                then()
                .statusCode(201);
    }
}
