package sdk.mocha.response;

import java.util.List;

public class GetAllTestResponse {
    public Integer testsCount;
    public List<TestResponse> tests;

    @Override
    public String toString() {
        return "GetAllTestResponse{" +
                "testsCount=" + testsCount +
                ", tests=" + tests +
                '}';
    }
}
