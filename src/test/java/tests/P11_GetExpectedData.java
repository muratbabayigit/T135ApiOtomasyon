package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class P11_GetExpectedData {

        /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine
        bir GET request yolladigimizda
        donen response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
        "userId":3,
        "id":22,
        "title":"dolor sint quo a velit explicabo quia nam",
        "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }

     */

    @Test
    public void test(){

       //1-EndPoint Hazırlanır
        String url="https://jsonplaceholder.typicode.com/posts/22";

      //2-Expected Data hazırlanır
        JSONObject expData=new JSONObject();
        expData.put("userId",3);
        expData.put("id",22);
        expData.put( "title","dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

      //3-Response kaydedilir

        Response response=given().when().get(url);


      //4-Assertion yapılır
        JsonPath resJP=response.jsonPath();

        assertEquals(expData.get("userId"),resJP.get("userId"));
        assertEquals(expData.get("id"),resJP.get("id"));
        assertEquals(expData.get("title"),resJP.get("title"));
        assertEquals(expData.get("body"),resJP.get("body"));




    }
}
