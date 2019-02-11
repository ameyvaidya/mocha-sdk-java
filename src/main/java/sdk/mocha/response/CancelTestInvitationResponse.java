package sdk.mocha.response;

public class CancelTestInvitationResponse {
    public Long testInvitationId;
    public String status;

    @Override
    public String toString() {
        return "CancelTestInvitationResponse{" +
                "testInvitationId=" + testInvitationId +
                ", status='" + status + '\'' +
                '}';
    }
}
