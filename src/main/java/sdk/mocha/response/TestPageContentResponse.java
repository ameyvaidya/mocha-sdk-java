package sdk.mocha.response;

public class TestPageContentResponse {
    public String testName;
    public String testDescription;
    public String testTopic;
    public String sectionDetail;
    public String testUsefulFor;

    @Override
    public String toString() {
        return "TestPageContentResponse{" +
                "testName='" + testName + '\'' +
                ", testDescription='" + testDescription + '\'' +
                ", testTopic='" + testTopic + '\'' +
                ", sectionDetail='" + sectionDetail + '\'' +
                ", testUsefulFor='" + testUsefulFor + '\'' +
                '}';
    }
}
