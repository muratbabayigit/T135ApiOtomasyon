package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.openqa.selenium.json.Json;

public class P08_JsonPathUsing {
    /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
                    "streetAddress": "naist street",
                    "city": "Nara",
                    "postalCode": "630-0192"
                },
    "phoneNumbers": [
                    {
                        "type": "iPhone",
                        "number": "0123-4567-8888"
                    },
                    {
                        "type": "home",
                        "number": "0123-4567-8910"
                    }
                    ]
    }


     */

    @Test
    public void test() {

        JSONObject iPhone=new JSONObject();
        iPhone.put("type","iPhone");
        iPhone.put("number", "0123-4567-8888");

        JSONObject home=new JSONObject();
        home.put("type","home");
        home.put("number", "0123-4567-8910");

        JSONObject address=new JSONObject();
        address.put( "streetAddress","naist street");
        address.put("city","Nara");
        address.put("postalCode","630-0192");

        JSONArray phoneNumbers=new JSONArray();
        phoneNumbers.put(0,iPhone);
        phoneNumbers.put(1,home);

        JSONObject kisiBilgisi=new JSONObject();
        kisiBilgisi.put("firstName","John");
        kisiBilgisi.put("lastName","doe");
        kisiBilgisi.put("age",26);
        kisiBilgisi.put("address",address);
        kisiBilgisi.put("phoneNumbers",phoneNumbers);




    }
}
