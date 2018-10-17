package com.plivo.utilities;

import io.restassured.response.Response;
import org.testng.Assert;

public class BaseAssertion {

    public static void verifyTrue(boolean flag) {
        Assert.assertTrue(flag);
    }

    public static void verifyFalse(boolean flag) {
        Assert.assertFalse(flag);
    }

    public static void verifyStatusCode(Response response, int status) {
        Assert.assertEquals(TestUtils.getStatusCode(response), status);
    }

    public static void verifyStatusMessage(Response response, String status) {
        Assert.assertEquals(TestUtils.getStatusCode(response), status);
    }
}
