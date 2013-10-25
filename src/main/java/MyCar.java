
public class MyCar {
    private String token;

    public MyCar(String token) {
        this.token = token;
    }

    public MyCar() {
        this.token = "TEST0";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
