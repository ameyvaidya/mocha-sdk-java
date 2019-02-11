package sdk.mocha.exception;

import org.apache.http.HttpStatus;

public class InternalIOException extends MochaException{
    public InternalIOException(){
        super("Internal IO exception");
        statusCode = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    }
}
