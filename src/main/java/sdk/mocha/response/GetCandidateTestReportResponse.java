package sdk.mocha.response;

import java.util.Date;

public class GetCandidateTestReportResponse {
    public String emailId;
    public String fullName;
    public Integer timeTaken;
    public String testName;
    public Integer duration;
    public Integer questions;
    public Date attemptedOn;
    public String totalScore;
    public String score;
    public Integer wv;
    public Integer tv;
    public String testStatus;
    public String reportStatus;
    public String testResult;
    public Double testCutOffPercent;
    public Double candidatePercent;
    public String reportPDFUrl;
    public Integer proctoringImagesCount;
    public Integer violatedProctoringImages;

    @Override
    public String toString() {
        return "GetCandidateTestReportResponse{" +
                "emailId='" + emailId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", timeTaken=" + timeTaken +
                ", testName='" + testName + '\'' +
                ", duration=" + duration +
                ", questions=" + questions +
                ", attemptedOn=" + attemptedOn +
                ", totalScore='" + totalScore + '\'' +
                ", score='" + score + '\'' +
                ", wv=" + wv +
                ", tv=" + tv +
                ", testStatus='" + testStatus + '\'' +
                ", reportStatus='" + reportStatus + '\'' +
                ", testResult='" + testResult + '\'' +
                ", testCutOffPercent=" + testCutOffPercent +
                ", candidatePercent=" + candidatePercent +
                ", reportPDFUrl='" + reportPDFUrl + '\'' +
                ", proctoringImagesCount=" + proctoringImagesCount +
                ", violatedProctoringImages=" + violatedProctoringImages +
                '}';
    }
}
