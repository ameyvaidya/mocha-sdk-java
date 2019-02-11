package sdk.mocha.response;

public class SectionResponse {
    public String sectionName;
    public String sectionType;
    public Integer questions;
    public Integer duration;

    @Override
    public String toString() {
        return "SectionResponse{" +
                "sectionName='" + sectionName + '\'' +
                ", sectionType='" + sectionType + '\'' +
                ", questions=" + questions +
                ", duration=" + duration +
                '}';
    }
}
