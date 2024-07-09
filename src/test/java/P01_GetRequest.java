import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P01_GetRequest {
    /*
    https://restful-booker.herokuapp.com/booking/10
    url’ine bir GET request gonderdigimizde donen Response’un,
 	status code’unun 200,
	ve content type’inin application/json; charset=utf-8,
	ve Server isimli Header’in degerinin Cowboy,
	ve status Line’in HTTP/1.1 200 OK
	ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz
     */

    /*
    Tüm API sorguları 4 işlemden oluşur
    1-Endpoint hazırlama
    2-Gerekli ise Expected Data hazırlanır.
    3-Actual Data obje içine kaydedilir
    4-Assertion işlemleri yapılır
     */

    @Test
    public void Test01(){
        //1-Endpoint hazırlama
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2-Gerekli ise Expected Data hazırlanır.
        //Expected Data soruda verilmemiş

       // 3-Actual Data obje içine kaydedilir

        Response response=given().when().get(url);

       // System.out.println(response.prettyPrint());
        // System.out.println(response.prettyPeek());

        System.out.println("Status Code: "+response.statusCode());
        System.out.println("Content Type: "+response.contentType());
        System.out.println("Server: "+response.header("Server"));
        System.out.println("Status line: "+response.statusLine());
        System.out.println("Test Time: "+response.getTime());


    }


}
