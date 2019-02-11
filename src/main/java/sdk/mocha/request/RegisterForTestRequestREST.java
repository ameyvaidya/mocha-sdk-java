package sdk.mocha.request;

import org.hibernate.validator.constraints.NotBlank;

public class RegisterForTestRequestREST extends GenericRequest {
    @NotBlank
    public String emailId;
    @NotBlank
    public String fullName;
    public String callBackUrl;
    public String redirectURL;

    @Override
    public String toString() {
        return "RegisterForTestRequestREST{" +
                "emailId='" + emailId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", callBackUrl='" + callBackUrl + '\'' +
                ", redirectURL='" + redirectURL + '\'' +
                '}';
    }
}

