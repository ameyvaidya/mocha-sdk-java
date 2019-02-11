import sdk.mocha.request.RegisterForTestRequestREST;
import sdk.mocha.response.*;
import sdk.mocha.services.MochaClient;

public class Main {
    public static void testDummy() {

        // Get all test
        GetAllTestResponseREST getAllTestResponseRESTObj = (GetAllTestResponseREST) doRequest("/v2/org/tests", "GET", null);

        // Get test details
        GetTestDetailsResponseREST getTestDetailsResponseRESTObj = (GetTestDetailsResponseREST) doRequest("/v2/org/tests/{testId}", "GET", null);

        // Register for test
        RegisterForTestRequestREST requestREST = new RegisterForTestRequestREST();
        requestREST.emailId = "abcd@abc.com";
        requestREST.fullName = "abcd";
        RegisterForTestResponseREST registerForTestResponseRESTObj = (RegisterForTestResponseREST) doRequest("/v2/org/tests/{testId}/register", "POST", requestREST);

        // Get candidate test report
        GetCandidateTestReportResponseREST getCandidateTestReportResponseRESTObj = (GetCandidateTestReportResponseREST) doRequest("/v2/org/report/{testInvitationdId}", "GET", null);

        // Get section report
        GetSectionReportResponseREST getSectionReportResponseRESTObj = (GetSectionReportResponseREST) doRequest("/v2/org/report/{testInvitationdId}/sections", "GET", null);

        // Reattempt test
        Object reattemptObj = doRequest("/v2/org/testinvitation/{testInvitationdId}/reattempt", "GET", null);
        CommonResponseREST commonResponseRESTReattemptObj = (CommonResponseREST) reattemptObj;

        if(commonResponseRESTReattemptObj.statuscode.equals("200.1")){
            ReattemptTestResponseREST reattemptTestResponseRESTObj = (ReattemptTestResponseREST) reattemptObj;
        } else{
            ErrorResponseREST errorResponseREST = (ErrorResponseREST) reattemptObj;
        }

        // Cancel test
        Object cancelObj = doRequest("/v2/org/testinvitation/{testInvitationdId}/cancel", "GET", null);
        CommonResponseREST commonResponseRESTCancelObj = (CommonResponseREST) cancelObj;

        if(commonResponseRESTCancelObj.statuscode.equals("200.1")){
            CancelTestInvitationResponseREST cancelTestInvitationResponseRESTObj = (CancelTestInvitationResponseREST) cancelObj;
        } else{
            ErrorResponseREST errorResponseREST = (ErrorResponseREST) cancelObj;
        }

        // Get skill report
        GetSkillReportResponseREST getSkillReportResponseRESTObj = (GetSkillReportResponseREST) doRequest("/v2/org/report/{testInvitationdId}/skills", "GET", null);
    }

    private static Object doRequest(String url, String method, Object data) {
        System.out.print("\n\n\n====================================\n");
        System.out.println("Requesting : " + url);
        MochaClient mochaClient = new MochaClient(
                "https://api.interviewmocha.com",
                url,
                method,
                "Your API Key here",
                data
        );
        Object result = mochaClient.getResponse();
        System.out.println(result.toString());
        System.out.print("====================================\n\n\n");
        return result;
    }

    public static void main(String[] args) {
        testDummy();
    }
}
