package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class P14_2_PutRequestSoftAssert {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    aşağıdaki body ile bir put request gönderdiğimizde

                  {
              "title": "Ahmet",
              "body": "Merhaba",
              "userId": 10,
              "id": 70
              }
        donen response değerinin aşağıdaki ile aynı olduğunu test ediniz

        Response Body
                       {
                   "title": "Ahmet",
                   "body": "Merhaba",
                   "userId": 10,
                   "id": 70
                   }
     */

    @Test
    public void test(){

        String url="https://jsonplaceholder.typicode.com/posts/70";
        JSONObject reqBody=new JSONObject();
        reqBody.put("title", "Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put( "userId",10);
        reqBody.put("id",70);

        JSONObject expData=new JSONObject();
        expData=reqBody;

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);

        JsonPath resJP=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(resJP.get("title"),expData.get("title"));
        softAssert.assertEquals(resJP.get("body"),expData.get("body"));
        softAssert.assertEquals(resJP.get("userId"),expData.get("userId"));
        softAssert.assertEquals(resJP.get("id"),expData.get("id"));

        softAssert.assertAll();


    }
}
