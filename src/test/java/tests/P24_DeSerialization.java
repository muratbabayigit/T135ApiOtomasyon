package tests;

import baseUrl.BaseUrlJSONPlace;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testDatas.JsonPlaceData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class P24_DeSerialization extends BaseUrlJSONPlace {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }

     Response Body:(expected Body)

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }
     */
    @Test
    public void test() {
        //1-Endpoint ve Request Data hazırlandı
        specJsonPlace.pathParams("pp1", "posts", "pp2", "70");
        Map<String, Object> reqMAPBody = JsonPlaceData.mapBodyOlustur("Ahmet", "Merhaba", 10.0, 70.0);

        //2-Expected Body hazırlama
        Map<String, Object> expMAPBody = JsonPlaceData.mapBodyOlustur("Ahmet", "Merhaba", 10.0, 70.0);

        //3-Response Kaydetme

        Response response=given().contentType(ContentType.JSON).when().spec(specJsonPlace).body(reqMAPBody).put("/{pp1}/{pp2}");

        Map<String,Object> resMAP=response.as(HashMap.class); //JSOn dönen cevabı Map formatına dönüştürdük

        assertEquals(expMAPBody.get("title"),resMAP.get("title"));
        assertEquals(expMAPBody.get("body"),resMAP.get("body"));
        assertEquals(expMAPBody.get("userId"),resMAP.get("userId"));
        assertEquals(expMAPBody.get("id"),resMAP.get("id"));


    }
}
