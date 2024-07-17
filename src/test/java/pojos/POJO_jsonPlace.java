package pojos;

public class POJO_jsonPlace {

    //1- Tüm variable'lar private olarak oluşturulur

    private String title;
    private String body;
    private int userId;
    private int id;

    //2- tüm variable'lar için getter ve setter methodu oluşturalım

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //3-Tüm variable'ları içeren bir parametreli constructor oluşturalım

    public POJO_jsonPlace(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    //4-Deafult constructor yeniden oluşturulur

    public POJO_jsonPlace() {
    }

    //5-toString Override

    @Override
    public String toString() {
        return "POJO_jsonPlace{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
