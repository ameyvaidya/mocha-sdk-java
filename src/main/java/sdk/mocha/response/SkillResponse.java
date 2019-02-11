package sdk.mocha.response;

public class SkillResponse {
    public Long skillId;
    public String skillName;
    public Double candidateSkillScore;
    public Double totalSkillScore;
    public Long sectionId;
    public String sectionName;

    @Override
    public String toString() {
        return "SkillResponse{" +
                "skillId=" + skillId +
                ", skillName='" + skillName + '\'' +
                ", candidateSkillScore=" + candidateSkillScore +
                ", totalSkillScore=" + totalSkillScore +
                ", sectionId=" + sectionId +
                ", sectionName='" + sectionName + '\'' +
                '}';
    }
}
