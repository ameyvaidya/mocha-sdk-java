package sdk.mocha.response;

public class ErrorResponseREST extends CommonResponseREST {
    public String result;

    @Override
    public String toString() {
        return "ErrorResponseREST{" +
                "result='" + result + '\'' +
                '}';
    }
}
