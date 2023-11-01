package Testcases;

import Features.apisClass;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testCasesClass extends testBase
{
    static Features.apisClass apisClass;
    String endpoint;
    Response response;

    @Test(priority = 1, dataProvider = "getAPIs", dataProviderClass = dataProviderClass.class)
    public void getAPI(String url, String statusCode)
    {
        apisClass = new apisClass();
        endpoint = url;
        response = apisClass.getAPI(endpoint);
        //Assertions
        Assert.assertEquals(response.statusCode(), Integer.parseInt(statusCode));
        if(response.statusCode() == 200)
        {
            Assert.assertEquals(response.jsonPath().getString("data[1].id"), "8");
            Assert.assertEquals(response.jsonPath().getString("data[4].first_name"), "George");
            Assert.assertTrue(response.jsonPath().getString("data.last_name").contains("Ferguson"));
            Assert.assertTrue(response.jsonPath().getString("data.last_name").contains("Edwards"));
            Assert.assertEquals(response.jsonPath().getString("total"), "12");
        }
    }

    /*
    @Test(priority = 2)
    public void getAPI2()
    {
        apisClass = new apisClass();
        endpoint = "/unknown/23";
        response = apisClass.getAPI(endpoint);
        //Assertions
        Assert.assertEquals(response.statusCode(), 404);
    }
     */

    @Test(priority = 2, dataProvider = "postAPIs", dataProviderClass = dataProviderClass.class)
    public void postApi(String url, String bodyItem1, String bodyItem1Value, String bodyItem2, String bodyItem2Value, String header,
                        String headerValue, String statusCode, String responseItem, String responseItemValue)
    {
        apisClass = new apisClass();
        endpoint = url;
        response = apisClass.postAPI(request, bodyItem1, bodyItem1Value, bodyItem2, bodyItem2Value, header, headerValue, endpoint);
        //Assertions
        Assert.assertEquals(response.statusCode(), Integer.parseInt(statusCode));
        Assert.assertTrue(response.jsonPath().getString(responseItem).contains(responseItemValue));
    }

    @Test(priority = 3, dataProvider = "putAPIs", dataProviderClass = dataProviderClass.class)
    public void putAPI(String url, String bodyItem1, String bodyItem1Value, String bodyItem2, String bodyItem2Value, String header,
                       String headerValue, String statusCode, String responseItem, String responseItemValue)
    {
        apisClass = new apisClass();
        endpoint = url;
        response = apisClass.putAPI(request, bodyItem1, bodyItem1Value, bodyItem2, bodyItem2Value, header, headerValue, endpoint);
        //Assertions
        Assert.assertEquals(response.statusCode(), Integer.parseInt(statusCode));
        Assert.assertTrue(response.jsonPath().getString(responseItem).contains(responseItemValue));
    }

    @Test(priority = 4, dataProvider = "putAPIs", dataProviderClass = dataProviderClass.class)
    public void patchAPI(String url, String bodyItem1, String bodyItem1Value, String bodyItem2, String bodyItem2Value, String header,
                         String headerValue, String statusCode, String responseItem, String responseItemValue)
    {
        apisClass = new apisClass();
        endpoint = url;
        response = apisClass.patchAPI(request, bodyItem1, bodyItem1Value, bodyItem2, bodyItem2Value, header,
                headerValue, endpoint);
        //Assertions
        Assert.assertEquals(response.statusCode(), Integer.parseInt(statusCode));
        Assert.assertTrue(response.jsonPath().getString(responseItem).contains(responseItemValue));
    }

    @Test(priority = 5, dataProvider = "deleteAPIs", dataProviderClass = dataProviderClass.class)
    public void deleteAPI(String url, String statusCode)
    {
        apisClass = new apisClass();
        endpoint = url;
        response = apisClass.deleteAPI(endpoint);
        //Assertions
        Assert.assertEquals(response.statusCode(), Integer.parseInt(statusCode));
    }
}
