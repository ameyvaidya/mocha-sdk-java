package sdk.mocha.response;

public class RegisterForTestResponse {
    public String testInvitationId;
    public String takeTestURL;

    @Override
    public String toString() {
        return "RegisterForTestResponse{" +
                "testInvitationId='" + testInvitationId + '\'' +
                ", takeTestURL='" + takeTestURL + '\'' +
                '}';
    }
}
