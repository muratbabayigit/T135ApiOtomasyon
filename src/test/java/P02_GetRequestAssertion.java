import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P02_GetRequestAssertion {
    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
 	status code’unun 200,
	ve content type’inin application/json; charset=utf-8,
	ve Server isimli Header’in degerinin Cowboy,
	ve status Line’in HTTP/1.1 200 OK
	olduğunu assert ediniz

     */

    @Test
    public void test(){

        //1-EndPoint hazırlanır
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2-Expected Data verilmediği için oluşturulmadı

        //3-Response kaydedilir
        Response response=given().when().get(url);

        //4-Assertion İşlemi
        response.then().assertThat()
                                    .statusCode(200)
                                    .header("Server","Cowboy")
                                    .statusLine("HTTP/1.1 200 OK")
                                    .contentType("application/json; charset=utf-8");


    }


}
