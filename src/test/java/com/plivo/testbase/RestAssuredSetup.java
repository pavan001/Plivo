package com.plivo.testbase;


import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;


public class RestAssuredSetup extends TestSetup {


    @BeforeSuite
    public void configure() throws IOException {

        RestAssured.baseURI = "https://api.plivo.com";


    }


}
