package pojos;

public class POJO_Dummy {

    private String status;
    private String message;
    private POJO_DummyDATA data;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public POJO_DummyDATA getData() {
        return data;
    }

    public void setData(POJO_DummyDATA data) {
        this.data = data;
    }

    public POJO_Dummy(String status, String message, POJO_DummyDATA data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public POJO_Dummy() {
    }

    @Override
    public String toString() {
        return "POJO_Dummy{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
