package sdk.mocha.response;

public class TestResponse {
    public Long testId;
    public String testName;
    public String accessKey;
    public Integer duration;
    public Integer questions;
    public String testStatus;
    public String testOwner;
    public String testTopics;

    @Override
    public String toString() {
        return "TestResponse{" +
                "testId=" + testId +
                ", testName='" + testName + '\'' +
                ", accessKey='" + accessKey + '\'' +
                ", duration=" + duration +
                ", questions=" + questions +
                ", testStatus='" + testStatus + '\'' +
                ", testOwner='" + testOwner + '\'' +
                ", testTopics='" + testTopics + '\'' +
                '}';
    }
}
