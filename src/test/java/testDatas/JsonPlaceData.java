package testDatas;

import org.json.JSONObject;

public class JsonPlaceData {
    /*
   https://jsonplaceholder.typicode.com/posts/22 url'ine
   bir GET request yolladigimizda
   donen response'in
       status kodunun 200
       content type'nın application/json; charset=utf-8
       Connection isimli Header değerinin keep-alive olduğunu
       ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

   Response body :(expectedData)
   {
       "userId":3,
       "id":22,
       "title":"dolor sint quo a velit explicabo quia nam",
       "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
   }
     */

    public static int statusCode = 200;
    public static String contentType = "application/json; charset=utf-8";
    public static String header = "keep-alive";

    public static JSONObject expectedDataOlustur() {
        JSONObject expBody = new JSONObject();
        expBody.put("userId", 3);
        expBody.put("id", 22);
        expBody.put("title", "dolor sint quo a velit explicabo quia nam");
        expBody.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expBody;

    }

    public static JSONObject dataOlustur(int userId, int id, String title, String body) {
           JSONObject data=new JSONObject();
           data.put("userId",userId);
           data.put("id",id);
           data.put("title",title);
           data.put("body",body);

           return data;
    }


}
