package tests;


import baseUrl.BaseUrlHerokuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoHerOkuAppBookingdates;
import pojos.PojoHerOkuAppExpBody;
import pojos.PojoHerOkuAppReqBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class P28_POJOClassPOST extends BaseUrlHerokuApp {
/*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ahmet",
    	                "lastname" : "Bulut",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }


    	            	Response Body // expected data
    	            {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                        ,
                        "additionalneeds":"wi-fi"
                    }
     */

    @Test
    public void test01(){

        //1-EndPoint ve ReqBody Hazırlama
        specHerOkuApp.pathParam("pp1","booking");

        PojoHerOkuAppBookingdates bookingdatesPOJO=new PojoHerOkuAppBookingdates("2021-06-01","2021-06-10");
        PojoHerOkuAppReqBody reqBodyPOJO=new PojoHerOkuAppReqBody("Ahmet","Bulut",500,false,bookingdatesPOJO,"wi-fi");

        //2- Expected Body Hazırlama
        PojoHerOkuAppReqBody bookingPOJO=new PojoHerOkuAppReqBody("Ahmet","Bulut",500,false,bookingdatesPOJO,"wi-fi");
        PojoHerOkuAppExpBody expBodyPOJO=new PojoHerOkuAppExpBody(24,bookingPOJO);

       // PojoHerOkuAppExpBody expBodyPOJO=new PojoHerOkuAppExpBody(24,reqBodyPOJO);

        //3-Response kaydet ve Request gönder

        Response response=given().spec(specHerOkuApp).contentType(ContentType.JSON).when().body(reqBodyPOJO).post("{pp1}");
        PojoHerOkuAppExpBody responsePOJO=response.as(PojoHerOkuAppExpBody.class);

       // assertEquals(expBodyPOJO.getBookingid(),responsePOJO.getBookingid());
        assertEquals(expBodyPOJO.getBooking().getFirstname(),responsePOJO.getBooking().getFirstname());
        assertEquals(expBodyPOJO.getBooking().getLastname(),responsePOJO.getBooking().getLastname());
        assertEquals(expBodyPOJO.getBooking().getTotalprice(),responsePOJO.getBooking().getTotalprice());
        assertEquals(expBodyPOJO.getBooking().isDepositpaid(),responsePOJO.getBooking().isDepositpaid());
        assertEquals(expBodyPOJO.getBooking().getBookingdates().getCheckin(),responsePOJO.getBooking().getBookingdates().getCheckin());
        assertEquals(expBodyPOJO.getBooking().getBookingdates().getCheckout(),responsePOJO.getBooking().getBookingdates().getCheckout());
        assertEquals(expBodyPOJO.getBooking().getAdditionalneeds(),responsePOJO.getBooking().getAdditionalneeds());





    }



}
