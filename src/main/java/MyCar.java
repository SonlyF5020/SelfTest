
public class MyCar {
    private final String token;

    public MyCar(String token) {
        this.token = token;
    }

    public MyCar() {
        this.token = "TEST0";
    }

    public String getToken() {
        return token;
    }
}
