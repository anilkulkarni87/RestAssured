package com.ak.configuration;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

/**
 * Created by anilkulkarni on 7/18/2017.
 */

public class RestAssuredConfiguration {
    @BeforeTest(alwaysRun = true)
    public void configure() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
    }
}
