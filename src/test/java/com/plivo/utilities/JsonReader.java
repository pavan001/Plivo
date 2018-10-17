package com.plivo.utilities;

import com.jayway.jsonpath.JsonPath;

import java.io.File;


public class JsonReader {


    public String fileName;
    private File jsonFile;

    public JsonReader(String fileName) {

        this.fileName = fileName;
    }

    public String getTestData(String data) {
        try {
            jsonFile = new File(fileName);
            return JsonPath.read(jsonFile, "$." + data);
        } catch (Exception e) {
            return null;
        }


    }


}
