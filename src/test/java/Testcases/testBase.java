package Testcases;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.baseURI;

public class testBase
{
    public JSONObject request;

    @BeforeTest
    protected void setGeneralData()
    {
        baseURI = "https://reqres.in/api";
        request = new JSONObject();
    }
}
