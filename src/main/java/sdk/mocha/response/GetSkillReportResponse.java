package sdk.mocha.response;

import java.util.List;

public class GetSkillReportResponse {
    public Long testInvitationId;
    public Long testId;
    public String testName;
    public Double candidateScore;
    public Double totalTestScore;
    public List<SkillResponse> skills;

    @Override
    public String toString() {
        return "GetSkillReportResponse{" +
                "testInvitationId=" + testInvitationId +
                ", testId=" + testId +
                ", testName='" + testName + '\'' +
                ", candidateScore=" + candidateScore +
                ", totalTestScore=" + totalTestScore +
                ", skills=" + skills +
                '}';
    }
}
