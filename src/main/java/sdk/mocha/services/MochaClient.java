package sdk.mocha.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.util.UriComponentsBuilder;
import sdk.mocha.exception.BadRequestException;
import sdk.mocha.exception.InternalIOException;
import sdk.mocha.exception.MochaException;
import sdk.mocha.request.GetAllTestRequestREST;
import sdk.mocha.request.RegisterForTestRequestREST;
import sdk.mocha.response.*;

import java.net.URI;
import java.util.regex.Pattern;

@EnableAsync
public class MochaClient {
    private static final Logger log = LoggerFactory.getLogger(MochaClient.class);
    private static final String METHOD_NAME_GET = "GET";
    private static final String METHOD_NAME_POST = "POST";

    private static final String GET_ALL_TEST_URL_REGEX = "/v2/org/tests";
    private static final String GET_TEST_DETAILS_URL_REGEX = "/v2/org/tests/.*";
    private static final String REGISTER_FOR_TEST_REGEX = "/v2/org/tests/.*./register";
    private static final String GET_CANDIDATE_TEST_SECTION_REPORT = "/v2/org/report/.*./sections";
    private static final String GET_CANDIDATE_TEST_REPORT_REGEX = "/v2/org/report/.*";
    private static final String REATTEMPT_TEST_URL_REGEX = "/v2/org/testinvitation/.*./reattempt";
    private static final String CANCEL_TEST_INVITATION_URL_REGEX = "/v2/org/testinvitation/.*./cancel";
    private static final String GET_SKILL_REPORT_URL_REGEX = "/v2/org/report/.*./skills";

    private String baseURL;
    private String URL;
    private String method;
    private String apiKey;
    private Object data;
    private MochaRESTProvider mochaRESTProvider;

    public MochaClient(String baseURL, String URL, String method, String apiKey) {
        this.baseURL = baseURL;
        this.URL = URL;
        this.method = method;
        this.apiKey = apiKey;
        this.mochaRESTProvider = new MochaRESTProvider();
    }

    public MochaClient(String baseURL, String URL, String method, String apiKey, Object data) {
        this(baseURL, URL, method, apiKey);
        this.data = data;
    }

    public Object getResponse() {
        try {
            log.info("Requested: {} {}", baseURL, URL);
            if (Pattern.matches(GET_ALL_TEST_URL_REGEX, URL)) {
                log.info("GET ALL");
                return processGetAllTestRequest();
            }
            if (Pattern.matches(REGISTER_FOR_TEST_REGEX, URL)) {
                log.info("REGISTER");
                return registerForTest();
            }
            if (Pattern.matches(GET_TEST_DETAILS_URL_REGEX, URL)) {
                log.info("GET DETAILS");
                return processGetTestDetailsRequest();
            }
            if (Pattern.matches(GET_CANDIDATE_TEST_SECTION_REPORT, URL)) {
                log.info("SECTION REPORT");
                return processGetCandidateTestSectionReport();
            }
            if (Pattern.matches(GET_SKILL_REPORT_URL_REGEX, URL)) {
                log.info("GET SKILL REPORT");
                return processGetSkillReportRequest();
            }
            if (Pattern.matches(GET_CANDIDATE_TEST_REPORT_REGEX, URL)) {
                log.info("GET REPORT");
                return processGetCandidateTestReportRequest();
            }
            if (Pattern.matches(REATTEMPT_TEST_URL_REGEX, URL)) {
                log.info("REATTEMPT TEST");
                return processReattemptTestRequest();
            }
            if (Pattern.matches(CANCEL_TEST_INVITATION_URL_REGEX, URL)) {
                log.info("CANCEL INVITATION");
                return processCancelTestInvitationRequest();
            }
            log.info("No match!");
            return null;
        } catch (MochaException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalIOException();
        }
    }

    @Async
    public Object getResponseAsync() {
        try {
            log.info("Requested: {} {}", baseURL, URL);
            if (Pattern.matches(GET_ALL_TEST_URL_REGEX, URL)) {
                log.info("GET ALL");
                return processGetAllTestRequest();
            }
            if (Pattern.matches(REGISTER_FOR_TEST_REGEX, URL)) {
                log.info("REGISTER");
                return registerForTest();
            }
            if (Pattern.matches(GET_TEST_DETAILS_URL_REGEX, URL)) {
                log.info("GET DETAILS");
                return processGetTestDetailsRequest();
            }
            if (Pattern.matches(GET_CANDIDATE_TEST_SECTION_REPORT, URL)) {
                log.info("SECTION REPORT");
                return processGetCandidateTestSectionReport();
            }
            if (Pattern.matches(GET_SKILL_REPORT_URL_REGEX, URL)) {
                log.info("GET SKILL REPORT");
                return processGetSkillReportRequest();
            }
            if (Pattern.matches(GET_CANDIDATE_TEST_REPORT_REGEX, URL)) {
                log.info("GET REPORT");
                return processGetCandidateTestReportRequest();
            }
            if (Pattern.matches(REATTEMPT_TEST_URL_REGEX, URL)) {
                log.info("REATTEMPT TEST");
                return processReattemptTestRequest();
            }
            if (Pattern.matches(CANCEL_TEST_INVITATION_URL_REGEX, URL)) {
                log.info("CANCEL INVITATION");
                return processCancelTestInvitationRequest();
            }
            log.info("No match!");
            return null;
        } catch (MochaException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalIOException();
        }
    }

    private GetAllTestResponseREST processGetAllTestRequest() {
        log.info("Processing GET ALL TEST request");
        GetAllTestRequestREST requestREST = (GetAllTestRequestREST) data;
        if (requestREST == null) {
            requestREST = new GetAllTestRequestREST();
        }
        if (requestREST.page_no == null) {
            requestREST.page_no = 1;
        }
        if (requestREST.page_size == null) {
            requestREST.page_size = 20;
        }
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseURL + URL)
                .queryParam("page_no", requestREST.page_no)
                .queryParam("page_size", requestREST.page_size);
        GetAllTestResponseREST responseREST = (GetAllTestResponseREST) mochaRESTProvider.doRest(
                getHttpMethod(method),
                builder.build().toUri(),
                apiKey,
                GetAllTestResponseREST.class,
                null
        );
        log.info("Response: {}", responseREST);
        return responseREST;
    }

    private Object processGetTestDetailsRequest() {
        log.info("Processing GET TEST DETAILS request");
        URI url = mochaRESTProvider.getFullURI(baseURL + URL);
        GetTestDetailsResponseREST responseREST = (GetTestDetailsResponseREST) mochaRESTProvider.doRest(
                getHttpMethod(method),
                url,
                apiKey,
                GetTestDetailsResponseREST.class,
                null
        );
        log.info("Response: {}", responseREST);
        return responseREST;
    }

    private Object registerForTest() {
        log.info("Processing REGISTER USER FOR TEST request");
        if (data == null) {
            log.error("data can not be null");
            throw new BadRequestException("data can not be null");
        }
        URI url = mochaRESTProvider.getFullURI(baseURL + URL);
        RegisterForTestRequestREST requestREST = (RegisterForTestRequestREST) data;
        RegisterForTestResponseREST responseREST = (RegisterForTestResponseREST) mochaRESTProvider.doRest(
                getHttpMethod(method),
                url,
                apiKey,
                RegisterForTestResponseREST.class,
                requestREST
        );
        log.info("Response: {}", responseREST);
        return responseREST;
    }

    private Object processGetCandidateTestReportRequest() {
        log.info("Processing GET CANDIDATE TEST REPORT request rest");
        URI url = mochaRESTProvider.getFullURI(baseURL + URL);
        GetCandidateTestReportResponseREST responseREST = (GetCandidateTestReportResponseREST)
                mochaRESTProvider.doRest(
                        getHttpMethod(method),
                        url,
                        apiKey,
                        GetCandidateTestReportResponseREST.class,
                        null
                );
        log.info("Response: {}", responseREST);
        return responseREST;
    }

    private Object processGetCandidateTestSectionReport() {
        log.info("Processing GET CANDIDATE TEST SECTION REPORT request");
        URI url = mochaRESTProvider.getFullURI(baseURL + URL);
        GetSectionReportResponseREST responseREST = (GetSectionReportResponseREST)
                mochaRESTProvider.doRest(
                        getHttpMethod(method),
                        url,
                        apiKey,
                        GetSectionReportResponseREST.class,
                        null
                );
        log.info("Response: {}", responseREST);
        return responseREST;
    }

    private Object processReattemptTestRequest() {
        log.info("Processing GET REATTEMPT TEST request");
        URI url = mochaRESTProvider.getFullURI(baseURL + URL);
        try {
            log.info("TTTTT sdfsd");
            ReattemptTestResponseREST responseREST = (ReattemptTestResponseREST)
                    mochaRESTProvider.doRest(
                            getHttpMethod(method),
                            url,
                            apiKey,
                            ReattemptTestResponseREST.class,
                            null
                    );
            log.info("Response: {}", responseREST);
            return responseREST;
        } catch (Exception ex) {
            log.info("Hello there");
            ErrorResponseREST responseREST = (ErrorResponseREST)
                    mochaRESTProvider.doRest(
                            getHttpMethod(method),
                            url,
                            apiKey,
                            ErrorResponseREST.class,
                            null
                    );
            log.info("Error response: {}", responseREST);
            return responseREST;
        }
    }

    private Object processCancelTestInvitationRequest() {
        log.info("Processing CANCEL TEST INVITATION request");
        URI url = mochaRESTProvider.getFullURI(baseURL + URL);
        try {
            CancelTestInvitationResponseREST responseREST = (CancelTestInvitationResponseREST)
                    mochaRESTProvider.doRest(
                            getHttpMethod(method),
                            url,
                            apiKey,
                            CancelTestInvitationResponseREST.class,
                            null
                    );
            log.info("Response: {}", responseREST);
            return responseREST;
        } catch (Exception ex) {
            ErrorResponseREST responseREST = (ErrorResponseREST)
                    mochaRESTProvider.doRest(
                            getHttpMethod(method),
                            url,
                            apiKey,
                            ErrorResponseREST.class,
                            null
                    );
            log.info("Error response: {}", responseREST);
            return responseREST;
        }
    }

    private Object processGetSkillReportRequest() {
        log.info("Processing GET SKILL REPORT request");
        URI url = mochaRESTProvider.getFullURI(baseURL + URL);
        GetSkillReportResponseREST responseREST = (GetSkillReportResponseREST)
                mochaRESTProvider.doRest(
                        getHttpMethod(method),
                        url,
                        apiKey,
                        GetSkillReportResponseREST.class,
                        null
                );
        log.info("Response: {}", responseREST);
        return responseREST;
    }

    private HttpMethod getHttpMethod(String method) {
        if (method.equals(METHOD_NAME_GET)) {
            return HttpMethod.GET;
        }
        if (method.equals(METHOD_NAME_POST)) {
            return HttpMethod.POST;
        }
        return HttpMethod.OPTIONS;
    }
}
