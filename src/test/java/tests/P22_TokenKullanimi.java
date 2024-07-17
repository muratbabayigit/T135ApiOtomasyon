package tests;

import baseUrl.BaseUrlHerokuApp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testDatas.HerOkuAppData;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;

public class P22_TokenKullanimi extends BaseUrlHerokuApp {
    static String token;
    static String bookingid;
    /*
    https://restful-booker.herokuapp.com/booking/3324 (id güncellenmeli)
    adresindeki rezervasyon bilgilerini
        -H 'Content-Type: application/json' \
        -H 'Accept: application/json' \
        -H 'Cookie: token=abc123' \ veya -H 'Authorization:Basic YWRtaW46cGFzc3dvcmQxMjM=' \
        header değerleriyle PUT request göndererek update ediniz.
        Token Oluşturma
        Content-Type: application/json header derğeriyle aşağıdaki body ile
        {
                "username" : "admin",
                "password" : "password123"
        }
        Post Request yapınız

 */
    /*
    JUNIT 4 kullanımında testleri önceliklendirme şansımız yok. Ancak test isimlendirmesi ile yapabiliyoruz
    JUNIT 5 kullanılırsa @Order(1) ile önceliklendirme yapabiliriz
     */

    @Test
    public void testA(){
        // Yeni bir booking oluşturalım
        specHerOkuApp.pathParam("pp1","booking");
        JSONObject innerBody= HerOkuAppData.innerDataOlustur("2024-07-22","2024-07-30");
        JSONObject reqBody=HerOkuAppData.reqDataOlustur("Damra","Genç",500,true,innerBody,"wi-fi");
        Response response=given().contentType(ContentType.JSON).when().spec(specHerOkuApp).body(reqBody.toString()).post("/{pp1}");
        response.prettyPrint();
        JsonPath resJP=response.jsonPath();
        bookingid=resJP.getString("bookingid");
        System.out.println("bookingid = " + bookingid);
    }

    @Test
    public void testB(){
        //tokenCreate ediyoruz
        specHerOkuApp.pathParam("pp1","auth");
        JSONObject userData=new JSONObject();
        userData.put("username", "admin");
        userData.put("password", "password123");

        Response response=given().contentType(ContentType.JSON).when().spec(specHerOkuApp)
                                                               .body(userData.toString())
                                                               .post("/{pp1}");

        JsonPath resJP=response.jsonPath();
        token=resJP.getString("token");
        System.out.println("token = " + token);

    }



 @Test
    public void testC(){
        //oluşturulan booking token kullanrak update ediliyor
        specHerOkuApp.pathParams("pp1","booking","pp2",bookingid);
        JSONObject innerBody= HerOkuAppData.innerDataOlustur("2024-07-30","2024-08-07");
        JSONObject reqBody=HerOkuAppData.reqDataOlustur("Baris","Akbaş",500,true,innerBody,"wi-fi");

        Response response=given().contentType(ContentType.JSON).when().spec(specHerOkuApp)
                                                                      .body(reqBody.toString())
                                                                      .header("Content-Type", "application/json")
                                                                      .header("Accept", "application/json")
                                                                      .header("Cookie","token="+token)
                                                                      .put("/{pp1}/{pp2}");
        response.prettyPrint();

    }

    @Test
    public void testD(){
        String authType="Basic";
        specHerOkuApp.pathParams("pp1","booking","pp2",bookingid);
        JSONObject innerBody= HerOkuAppData.innerDataOlustur("2024-08-07","2024-08-14");
        JSONObject reqBody=HerOkuAppData.reqDataOlustur("Beyza","Hanım",500,true,innerBody,"wi-fi");
        Response response=given().contentType(ContentType.JSON).when().spec(specHerOkuApp)
                .body(reqBody.toString())
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .put("/{pp1}/{pp2}");
        response.prettyPrint();
    }

}
