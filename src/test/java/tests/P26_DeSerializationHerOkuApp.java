package tests;

import baseUrl.BaseUrlHerokuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.Test;
import testDatas.HerOkuAppData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class P26_DeSerializationHerOkuApp extends BaseUrlHerokuApp {
/*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response’un asagidaki gibi oldugunu test edin.
                            Request body
                       {
                            "firstname" : "Ahmet",
                            "lastname" : “Bulut",
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
                                "checkout":"2021-06-10",
                            "additionalneeds":"wi-fi"
                        }
         */
    @Test
    public void test(){
        specHerOkuApp.pathParam("pp1","booking");
        Map<String,Object> bookingdates= HerOkuAppData.innerMAPOlustur("2024-07-17","2024-07-24");
        Map<String,Object> reqBody=HerOkuAppData.MAPDataOlustur("Ahmet","Bulut",500.0,true,bookingdates,"wi-fi");

        Map<String,Object> expBody=HerOkuAppData.expMAPDataOlustur(24,"Ahmet","Bulut",500.0,true,bookingdates,"wi-fi");

        Response response=given().spec(specHerOkuApp).contentType(ContentType.JSON).when().body(reqBody).post("/{pp1}");

       // response.prettyPrint();
        Map<String,Object> resMAP=response.as(HashMap.class);
        assertEquals(((Map)(expBody.get("booking"))).get("firstname"),((Map)(resMAP.get("booking"))).get("firstname"));
        assertEquals(((Map)(expBody.get("booking"))).get("lastname"), ((Map)(resMAP.get("booking"))).get("lastname"));
        assertEquals(((Map)(expBody.get("booking"))).get("totalprice"), ((Map)(resMAP.get("booking"))).get("totalprice"));
        assertEquals(((Map)(expBody.get("booking"))).get("depositpaid"), ((Map)(resMAP.get("booking"))).get("depositpaid"));
        assertEquals(((Map)(expBody.get("booking"))).get("additionalneeds"), ((Map)(resMAP.get("booking"))).get("additionalneeds"));
        assertEquals(((Map)(((Map)(expBody.get("booking"))).get("bookingdates"))).get("checkin"),((Map)(((Map)(resMAP.get("booking"))).get("bookingdates"))).get("checkin"));
        assertEquals((((Map)((Map)(expBody.get("booking"))).get("bookingdates"))).get("checkout"),((Map)(((Map)(resMAP.get("booking"))).get("bookingdates"))).get("checkout"));
    }







}
