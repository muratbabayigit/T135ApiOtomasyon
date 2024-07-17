package tests;

import baseUrl.BaseUrlJSONPlace;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.POJO_jsonPlace;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class P27_pojoClassPUT extends BaseUrlJSONPlace {
    /*
     https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body'e sahip bir PUT request yolladigimizda
    donen response'in
    status kodunun 200,
    content type'inin "application/json; charset=utf-8",
    Connection header degerinin "keep-alive"
    ve response body'sinin asagida verilen ile ayni oldugunu test ediniz
     Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Response body : // expected data
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */
 @Test
    public void test(){
     specJsonPlace.pathParams("pp1","posts","pp2","70");
     POJO_jsonPlace reqPOJO=new POJO_jsonPlace("Ahmet","Merhaba",10,70);

     POJO_jsonPlace expPOJO=new POJO_jsonPlace("Ahmet","Merhaba",10,70);
     Response response=given().contentType(ContentType.JSON).spec(specJsonPlace).when().body(reqPOJO).put("/{pp1}/{pp2}");

    POJO_jsonPlace resPOJO=response.as(POJO_jsonPlace.class);

     assertEquals(expPOJO.getTitle(),resPOJO.getTitle());
     assertEquals(expPOJO.getBody(),resPOJO.getBody());
     assertEquals(expPOJO.getId(),resPOJO.getId());
     assertEquals(expPOJO.getUserId(),resPOJO.getUserId());
     assertEquals(JsonPlaceData.statusCode,response.getStatusCode());
     assertEquals(JsonPlaceData.contentType,response.getContentType());
     assertEquals(JsonPlaceData.header,response.getHeader("Connection"));


 }

}
