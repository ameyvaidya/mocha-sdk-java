package sdk.mocha.response;

import java.util.List;

public class GetSectionReportResponseREST extends CommonResponseREST {
    public List<GetSectionReportResponse> result;

    @Override
    public String toString() {
        return "GetSectionReportResponseREST{" +
                "result=" + result +
                '}';
    }
}
