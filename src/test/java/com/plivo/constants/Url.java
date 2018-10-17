package com.plivo.constants;

public class Url {

    public static final String BASE_URI = "https://api.plivo.com";


    public static String getEndPoint() {

        return BASE_URI;
    }

    public static String getEndPoint(String resource) {


        return BASE_URI + resource;
    }
}
