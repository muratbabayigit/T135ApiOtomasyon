import io.restassured.response.Response;

import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P05_GetResponseBodyTest {
    /*
    https://jsonplaceholder.typicode.com/posts/44 url'ine
    bir GET request yolladigimizda
    donen Response’in
    status code'unun 200,
    ve content type'inin application/json; charset=utf-8,
    ve response body'sinde bulunan userId'nin 5,
     ve response body'sinde bulunan title'in "optio dolor molestias sit"
    oldugunu test edin.
     */

    @Test
    public void test() {
        //1-EndPoint Hazırlanır

        String url="https://jsonplaceholder.typicode.com/posts/44";

        //2-Expected Data hazırlanır

        //3-Response kayıt edilir
        Response respone=given().when().get(url);


        respone.prettyPrint();

        System.out.println("Assertion işlemi başlıyor...");
        respone.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                //body içerisindeki herhangi bir elementi assert ederken matchers classını kullanırız
                .body("userId",Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));
    }

}
