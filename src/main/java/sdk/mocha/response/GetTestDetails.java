package sdk.mocha.response;

import java.util.List;

public class GetTestDetails extends TestResponse{
    public List<SectionResponse> sections;
    public TestPageContentResponse testPageContent;

    @Override
    public String toString() {
        return "GetTestDetails{" +
                "sections=" + sections +
                ", testPageContent=" + testPageContent +
                '}';
    }
}
