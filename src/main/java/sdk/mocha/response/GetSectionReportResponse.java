package sdk.mocha.response;

public class GetSectionReportResponse {
    public String sectionName;
    public String sectionScore;
    public String candidateScore;
    public String candidateTimeTaken;
    public String sectionTime;
    public Integer noOfQuestionsInSection;
    public Integer noOfAnsweredQuestions;
    public Integer noOfNotAnsweredQuestions;
    public Integer noOfSkippedQuestions;
    public Integer noOfCorrectQuestions;
    public Integer noOfWrongQuestions;
    public Integer negativeMarks;

    @Override
    public String toString() {
        return "GetSectionReportResponse{" +
                "sectionName='" + sectionName + '\'' +
                ", sectionScore='" + sectionScore + '\'' +
                ", candidateScore='" + candidateScore + '\'' +
                ", candidateTimeTaken='" + candidateTimeTaken + '\'' +
                ", sectionTime='" + sectionTime + '\'' +
                ", noOfQuestionsInSection=" + noOfQuestionsInSection +
                ", noOfAnsweredQuestions=" + noOfAnsweredQuestions +
                ", noOfNotAnsweredQuestions=" + noOfNotAnsweredQuestions +
                ", noOfSkippedQuestions=" + noOfSkippedQuestions +
                ", noOfCorrectQuestions=" + noOfCorrectQuestions +
                ", noOfWrongQuestions=" + noOfWrongQuestions +
                ", negativeMarks=" + negativeMarks +
                '}';
    }
}
