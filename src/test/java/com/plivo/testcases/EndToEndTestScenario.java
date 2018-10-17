package com.plivo.testcases;

import com.plivo.constants.EndPoints;
import com.plivo.constants.Url;
import com.plivo.testbase.RestAssuredSetup;
import com.plivo.utilities.BaseAssertion;
import com.plivo.utilities.HttpMethods;
import com.plivo.utilities.JsonReader;
import com.plivo.utilities.PayloadGenerator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTestScenario extends RestAssuredSetup {

    Response response;
    JsonReader json = new JsonReader(System.getProperty("user.dir") + "/resources/authid.json");
    String src;
    String dst;
    String uuid;


    @Test(priority = 1)
    public void getAllNumbers() {
        response = HttpMethods.getRequest(Url.getEndPoint(EndPoints.GET_NUMBERS), json.getTestData("authid"));
        BaseAssertion.verifyStatusCode(response, 200);
        src = PayloadGenerator.getValueForTheKeyAsString(response, "objects[0].number");
        dst = PayloadGenerator.getValueForTheKeyAsString(response, "objects[1].number");

    }


    @Test(priority = 2)
    public void postMessage() {
        String payload = "{\"src\":\"" + src + "\" ,\"dst\":\"" + dst + "\",\"text\":\"hello\",\"type\":\"sms\"}";
        response = HttpMethods.postRequest(Url.getEndPoint(EndPoints.POST_MESSAGE), json.getTestData("authid"), payload);
        BaseAssertion.verifyStatusCode(response, 202);
        uuid = PayloadGenerator.getValueForTheKeyAsString(response, "message_uuid[0]");


    }

    @Test(priority = 3)
    public void getMessageDetails() {
        response = HttpMethods.getRequest(Url.getEndPoint(EndPoints.GET_MESSAGE_DETAILS), json.getTestData("authid"), "message_uuid", uuid);
        BaseAssertion.verifyStatusCode(response, 200);
    }

    @Test(priority = 4)
    public void getPricing() {
        response = HttpMethods.getRequestWithQueryParam(Url.getEndPoint(EndPoints.GET_PRICING), json.getTestData("authid"), "country_iso", "US");
        String outboundrate = PayloadGenerator.getValueForTheKeyAsString(response, "message.outbound.rate");
        String rate = PayloadGenerator.getValueForTheKeyAsString(response, "message.outbound_networks_list[0].rate");
        BaseAssertion.verifyStatusCode(response, 200);
        Assert.assertEquals(outboundrate, rate);
    }


    @Test(priority = 5)
    public void accountdetails() {
        response = HttpMethods.getRequests(Url.getEndPoint(EndPoints.GET_ACCOUNT_DETAILS), json.getTestData("authid"));
        BaseAssertion.verifyStatusCode(response, 200);
        String cashcredits = PayloadGenerator.getValueForTheKeyAsString(response, "message_credits");


    }


}
