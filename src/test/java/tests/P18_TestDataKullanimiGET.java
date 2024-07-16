package tests;

import baseUrl.BaseUrlJSONPlace;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.json.Json;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class P18_TestDataKullanimiGET extends BaseUrlJSONPlace {
      /*
   https://jsonplaceholder.typicode.com/posts/22 url'ine
   bir GET request yolladigimizda
   donen response'in
       status kodunun 200
       content type'nın application/json; charset=utf-8
       Connection isimli Header değerinin keep-alive olduğunu
       ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

   Response body :(expectedData)
   {
       "userId":3,
       "id":22,
       "title":"dolor sint quo a velit explicabo quia nam",
       "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
   }
     */
    @Test
    public void test(){

        specJsonPlace.pathParams("pp1","posts","pp2",22);
        JSONObject expBody= JsonPlaceData.expectedDataOlustur();
        Response response=given().when().spec(specJsonPlace).get("{pp1}/{pp2}");
        JsonPath resJP=response.jsonPath();

        assertEquals(JsonPlaceData.statusCode,response.getStatusCode());
        assertEquals(JsonPlaceData.contentType,response.getContentType());
        assertEquals(JsonPlaceData.header,response.getHeader("Connection"));
        assertEquals(expBody.get("userId"),resJP.get("userId"));
        assertEquals(expBody.get("id"),resJP.get("id"));
        assertEquals(expBody.get("title"),resJP.get("title"));
        assertEquals(expBody.get("body"),resJP.get("body"));

    }
}
