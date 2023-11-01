package Features;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;

public class apisClass
{
    public Response getAPI(String endpoint)
    {
        System.out.println("----------------------------------------");
        System.out.println("GET API\nRequest:\n"+baseURI+endpoint);
        System.out.println("Response:");
        Response response =
        when().
                get(endpoint).
        then().
                log().status().
                log().body().
                extract().response();
        return response;
    }

    public Response postAPI(JSONObject request, String item1, String item1Value, String item2, String item2Value, String header,
                            String headerValue, String endpoint)
    {
        System.out.println("----------------------------------------\nPost API");

        //Enter request Body
        request.put(item1, item1Value);
        request.put(item2, item2Value);

        System.out.println("Request:\n"+request.toJSONString());

        System.out.println("Response:");
        Response response = given().
                header(header, headerValue).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post(endpoint).
        then().
                log().status().
                log().body().
                extract().response();
        return response;
    }

    public Response putAPI(JSONObject request, String item1, String item1Value, String item2, String item2Value, String header,
                           String headerValue, String endpoint)
    {
        System.out.println("----------------------------------------\nPut API");

        //Enter request Body
        request.put(item1, item1Value);
        request.put(item2, item2Value);

        System.out.println("Request:\n"+request.toJSONString());

        System.out.println("Response:");
        Response response = given().
                header(header, headerValue).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                put(endpoint).
        then().
                log().status().
                log().body().
                extract().response();
        return response;
    }

    public Response patchAPI(JSONObject request, String item1, String item1Value, String item2, String item2Value, String header,
                           String headerValue, String endpoint)
    {
        System.out.println("----------------------------------------\nPatch API");

        //Enter request Body
        request.put(item1, item1Value);
        request.put(item2, item2Value);

        System.out.println("Request:\n"+request.toJSONString());

        System.out.println("Response:");
        Response response = given().
                header(header, headerValue).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                patch(endpoint).
        then().
                log().status().
                log().body().
                extract().response();
        return response;
    }

    public Response deleteAPI(String endpoint)
    {
        System.out.println("----------------------------------------");
        System.out.println("Delete API\nRequest:\n"+baseURI+endpoint);
        System.out.println("Response:");
        Response response =
                when().
                        delete(endpoint).
                then().
                        log().status().
                        log().body().
                        extract().response();
        return response;
    }
}
