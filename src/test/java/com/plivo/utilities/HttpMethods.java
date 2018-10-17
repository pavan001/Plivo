package com.plivo.utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class HttpMethods {


    public static Response getRequest(String uri, String authid) {

        RequestSpecification requestSpecification = RestAssured.given().log().all();
        requestSpecification.pathParam("authid", authid);
        requestSpecification.header("authorization", "Basic TUFPRFVaWVRRMFkyRk1ZSkJMT1c6TXprME16VTFNemMzTVRjMU1URXlNR1UyTTJSbFlUSXdOMlV5TXprMQ==");
        Response response = requestSpecification.get(uri);
        response.prettyPrint();
        return response;

    }

    public static Response getRequest(String uri, String authid, String pathkey, String pathvalue) {
        RequestSpecification requestSpecification = RestAssured.given().log().all();
        requestSpecification.pathParam("authid", authid);
        requestSpecification.pathParam(pathkey, pathvalue);
        requestSpecification.header("authorization", "Basic TUFPRFVaWVRRMFkyRk1ZSkJMT1c6TXprME16VTFNemMzTVRjMU1URXlNR1UyTTJSbFlUSXdOMlV5TXprMQ==");
        Response response = requestSpecification.get(uri);
        response.prettyPrint();
        return response;

    }


    public static Response getRequestWithQueryParam(String uri, String authid, String pathkey, String pathvalue) {
        RequestSpecification requestSpecification = RestAssured.given().log().all();
        requestSpecification.pathParam("authid", authid);
        requestSpecification.queryParam(pathkey, pathvalue);
        requestSpecification.header("authorization", "Basic TUFPRFVaWVRRMFkyRk1ZSkJMT1c6TXprME16VTFNemMzTVRjMU1URXlNR1UyTTJSbFlUSXdOMlV5TXprMQ==");
        Response response = requestSpecification.get(uri);
        response.prettyPrint();
        return response;

    }

    public static Response postRequest(String uri, String authid, String json) {

        RequestSpecification requestSpecification = RestAssured.given().log().all().body(json);
        requestSpecification.pathParam("authid", authid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("authorization", "Basic TUFPRFVaWVRRMFkyRk1ZSkJMT1c6TXprME16VTFNemMzTVRjMU1URXlNR1UyTTJSbFlUSXdOMlV5TXprMQ==");
        Response response = requestSpecification.post(uri);
        response.prettyPrint();
        return response;

    }


    public static Response getRequests(String uri, String authid) {

        RequestSpecification requestSpecification = RestAssured.given().log().all();
        requestSpecification.pathParam("auth_id", authid);
        requestSpecification.header("authorization", "Basic TUFPRFVaWVRRMFkyRk1ZSkJMT1c6TXprME16VTFNemMzTVRjMU1URXlNR1UyTTJSbFlUSXdOMlV5TXprMQ==");
        Response response = requestSpecification.get(uri);
        response.prettyPrint();
        return response;

    }


}
