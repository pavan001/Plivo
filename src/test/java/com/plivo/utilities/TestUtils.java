package com.plivo.utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestUtils {


    public static String getResposeString(Response response) {
        String strResponse = response.getBody().asString();
        return strResponse;
    }

    public static JsonPath jsonParser(String response) {
        JsonPath jsonResponse = new JsonPath(response);
        return jsonResponse;
    }


    public static int getStatusCode(Response response) {
        int statusCode = response.getStatusCode();
        return statusCode;
    }

    public static String getStatusMessage(Response response) {
        String responseMessage = response.getStatusLine();
        return responseMessage;
    }


}
