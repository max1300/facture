package mre.spring.facture.exception;

public class SpringAuthException extends RuntimeException {

    public SpringAuthException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public SpringAuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
