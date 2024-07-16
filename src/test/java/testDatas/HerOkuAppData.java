package testDatas;

import org.json.JSONObject;

public class HerOkuAppData {
        /*
                https://restful-booker.herokuapp.com/booking url’ine
                asagidaki body'ye sahip bir POST request gonderdigimizde
                donen response’un bookingid haric asagidaki gibi oldugunu test edin.
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
               Expected response body
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
                                            },
                            "additionalneeds":"wi-fi"
                                    }
                          }
     */

    public static JSONObject innerDataOlustur(String checkIn, String checkOut){
        JSONObject innerData=new JSONObject();
        innerData.put("checkin",checkIn);
        innerData.put("checkout",checkOut);

        return innerData;
    }

    public static JSONObject reqDataOlustur(String firstname,String lastname, int totalprice, boolean depositpaid,JSONObject bookingdates,String additionalneeds){
        JSONObject reqData=new JSONObject();
        reqData.put("firstname" , firstname);
        reqData.put("lastname" , lastname);
        reqData.put("totalprice" ,totalprice);
        reqData.put("depositpaid",depositpaid);
        reqData.put("bookingdates",bookingdates);
        reqData.put("additionalneeds",additionalneeds);


        return reqData;
    }
    public static JSONObject expDataOlustur(int bookingid,String firstname,String lastname, int totalprice, boolean depositpaid,JSONObject bookingdates, String additionalneeds){
        JSONObject expData=new JSONObject();
        expData.put("bookingid",bookingid);
        JSONObject booking=reqDataOlustur(firstname,lastname,totalprice,depositpaid,bookingdates,additionalneeds);
        expData.put("booking",booking);


        return expData;
    }
}
