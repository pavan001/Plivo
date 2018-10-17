package com.plivo.utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;


public class PayloadGenerator {

    public static String generatePayLoadString(String filename) {
        System.out.println("filename + " + filename);
        String filePath = System.getProperty("user.dir") + "/resources/" + filename;

        try {

            return new String(readAllBytes(Paths.get(filePath)));
        } catch (Exception e) {
            return null;
        }
    }


    public static String getValueForTheKeyAsString(Response response, String key) {

        String stringresponse = TestUtils.getResposeString(response);
        JsonPath jsonresponse = TestUtils.jsonParser(stringresponse);
        String value = jsonresponse.get(key);
        return value;

    }

    public static int getValueForTheKeyAsInteger(Response response, String key) {

        String stringresponse = TestUtils.getResposeString(response);
        JsonPath jsonresponse = TestUtils.jsonParser(stringresponse);
        int value = jsonresponse.get(key);
        return value;

    }
}
