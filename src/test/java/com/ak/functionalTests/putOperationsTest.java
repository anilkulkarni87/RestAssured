package com.ak.functionalTests;

import com.ak.framework.Constants;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * Created by anilkulkarni on 7/17/2017.
 */

public class putOperationsTest {
    @Test(priority = 2, enabled = false)
    public void httpPut(){
        HashMap<String,Object> jsonAsMap=new HashMap<String, Object>();
        jsonAsMap.put("id",2);
        jsonAsMap.put("title","After put operation");
        jsonAsMap.put("author","King Kong changed");
        given()
                .contentType("application/json")
                .body(jsonAsMap)
                .pathParam("id",2).
        when()
                .put(Constants.PUT_POST_WITH_ID).
        then()
                .statusCode(200)
                .log().all();
    }
}
