package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class P12_PostRequestJsonPathAssertion {

        /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response’un bookingid haric asagidaki gibi oldugunu test edin.

        Request body
        {
        "firstname" : "Hasan",
        "lastname" : "Yagmur",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
            "checkin" : "2021-06-01",
            "checkout" : "2021-06-10"
            },
        "additionalneeds" : "wi-fi"
        }

        Response Body(expData)
        {
        "bookingid":24,
        "booking":{
            "firstname":"Hasan",
            "lastname":"Yagmur",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                "checkin":"2021-06-01",
                "checkout":"2021-06-10"
                },
        "additionalneeds":"wi-fi"
        }
        }
         */
        @Test
        public void test() {
            //1-Endpoint ve Request Body Hazırlama
            String url = "https://restful-booker.herokuapp.com/booking";
            JSONObject reqData = new JSONObject();
            JSONObject bookingDates = new JSONObject();
            bookingDates.put("checkin", "2021-06-01");
            bookingDates.put("checkout", "2021-06-10");

            reqData.put("firstname", "Hasan");
            reqData.put("lastname", "Yagmur");
            reqData.put("totalprice", 500);
            reqData.put("depositpaid", false);
            reqData.put("bookingdates", bookingDates);
            reqData.put("additionalneeds", "wi-fi");

            //2-ExpData hazırlanır
            JSONObject expData = new JSONObject();
            expData.put("bookingid", 24);
            expData.put("booking", reqData);

            //3-Response kaydedilir
            Response response = given().contentType(ContentType.JSON).when().body(reqData.toString()).post(url);

            //4-Assertion işlemleri yapılır
            JsonPath resJP = response.jsonPath();
            assertEquals(expData.getJSONObject("booking").get("firstname"), resJP.get("booking.firstname"));
            assertEquals(expData.getJSONObject("booking").get("lastname"), resJP.get("booking.lastname"));
            assertEquals(expData.getJSONObject("booking").get("totalprice"), resJP.get("booking.totalprice"));
            assertEquals(expData.getJSONObject("booking").get("depositpaid"), resJP.get("booking.depositpaid"));
            assertEquals(expData.getJSONObject("booking").get("additionalneeds"), resJP.get("booking.additionalneeds"));
            assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"), resJP.get("booking.bookingdates.checkin"));
            assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"), resJP.get("booking.bookingdates.checkout"));


        }


    }

