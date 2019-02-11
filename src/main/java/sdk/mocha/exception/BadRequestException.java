package sdk.mocha.exception;

import org.apache.http.HttpStatus;

public class BadRequestException extends MochaException {
    public BadRequestException() {
        this("Bad request");
    }

    public BadRequestException(String message) {
        super(message);
        statusCode = HttpStatus.SC_BAD_REQUEST;
    }
}