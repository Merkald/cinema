package cinema.exeptions;

public class AuthenticationExeption extends RuntimeException {
    public AuthenticationExeption(String message, Throwable throwable) {
        super(message, throwable);
    }

    public AuthenticationExeption(String message) {
        super(message);
    }
}
