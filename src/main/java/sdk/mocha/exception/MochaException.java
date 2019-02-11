package sdk.mocha.exception;

public class MochaException extends RuntimeException{
    public int statusCode;
    public String exceptionReason;
    public MochaException(String message) {
        super(message);
        exceptionReason=message;
    }

    public MochaException(String message, String exceptionReason) {
        super(message);
        this.exceptionReason=exceptionReason;
    }
}
