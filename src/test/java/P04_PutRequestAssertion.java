import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P04_PutRequestAssertion {
      /*

            https://jsonplaceholder.typicode.com/posts/70 url’ine
            asagidaki Json formatindaki body ile bir PUT request gonderdigimizde

            {
                "title": "Ahmet",
                "body": "Merhaba",
                "userId": 10,
                "id": 70

            }

            donen Response’un,
             status code’unun 200,
             ve content type’inin application/json; charset=utf-8,
             ve Server isimli Header’in degerinin cloudflare,
             ve status Line’in HTTP/1.1 200 OK
        */
    @Test
    public void p04PutRequest(){
        // 1-Endpoint Hazırlanır
        // (Eğer PUT,POST,PATCH işlemi yapıyorsak requestBody burada hazırlanır)

        String url="https://jsonplaceholder.typicode.com/posts/70";
        JSONObject reqBody=new JSONObject();
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);

        //2-Soruda beklenmediği için Expected Data hazırlanmadı


        //3-Response tüm bilgileri ile kayıt edilir
        Response response=given().contentType(ContentType.JSON)
                                .when().body(reqBody.toString()).put(url);

        //4-Assertion işlemleri yapılır
        response.then().assertThat()
                       .statusCode(200)
                       .statusLine("HTTP/1.1 200 OK")
                       .contentType("application/json; charset=utf-8")
                       .header("Server","cloudflare");




    }
}
