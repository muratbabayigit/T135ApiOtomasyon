import org.json.JSONObject;
import org.junit.Test;

public class P03_JSONObjeOlusturma {
          /*
           Asagidaki JSON Objesini olusturup konsolda yazdirin.
                     {
                     "title":"Ahmet",
                     "body":"Merhaba",
                     "userId":1
                     }
      */
    @Test
    public void test01(){

        //Json Data oluşturmak için önce JSONObject clasından bir obje oluşturuyoruz
        //Sonra Data içine istediğimiz bilgileri key,value şeklinde ekliyoruz

        JSONObject obj=new JSONObject();

        obj.put("title","Ahmet");
        obj.put("body","Merhaba");
        obj.put("userId",1);

        System.out.println("Json Data:"+obj);
    }



    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "firstname":"Jim",
        "lastname":"Brown",
        "bookingdates": {
                "checkin":"2018-01-01",
                "checkout":"2019-01-01"
                         },
        "totalprice":111,
        "depositpaid":true,
        "additionalneeds":"Breakfast"
     }
    */

    @Test
    public void test02(){


        JSONObject innerData=new JSONObject();
        innerData.put("checkin","2018-01-01");
        innerData.put("checkout","2019-01-01");

        JSONObject JsonData=new JSONObject();
        JsonData.put("firstname","Jim");
        JsonData.put("lastname","Brown");
        JsonData.put("bookingdates",innerData);
        JsonData.put("totalprice",111);
        JsonData.put("depositpaid",true);
        JsonData.put("additionalneeds","Breakfast");

        System.out.println("Json Data:"+JsonData.toString());


    }



}
