package sdk.mocha.services;

import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.client.RestTemplate;
import sdk.mocha.exception.JsonMappingException;
import sdk.mocha.request.GenericRequest;
import sdk.mocha.response.CommonResponseREST;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class MochaRESTProvider {
    private static final Logger log = LoggerFactory.getLogger(MochaRESTProvider.class);


    public URI getFullURI(String url) {
        try {
            URIBuilder builder = new URIBuilder(url);
            return builder.build().toURL().toURI();
        } catch (URISyntaxException e) {
            log.error("URISyntaxException", e);
        } catch (MalformedURLException e) {
            log.error("MalformedURLException", e);
        }
        return null;
    }

    public CommonResponseREST doRest(HttpMethod httpMethod, URI url, String apiKey, Class responseType, GenericRequest request) {
        log.info("Requested for rest request");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        httpHeaders.add("x-api-key", apiKey);
        httpHeaders.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        return doRest(httpMethod, url, responseType, httpHeaders, request);
    }

    public CommonResponseREST doRest(HttpMethod httpMethod, URI url, Class responseType, HttpHeaders headers, GenericRequest request) {
        try {
            log.info("Remote " + httpMethod.name() + " : " + url);
            if(request != null){
                log.info("Request: {}", request);
            }
            HttpEntity requestHttpEntity = new HttpEntity(request, headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<? extends CommonResponseREST> responseREST = restTemplate.exchange(url, httpMethod, requestHttpEntity, responseType);
            log.info("Got {}", responseREST.getStatusCode());
            return responseREST.getBody();
        } catch (Exception ex) {
            if(ex instanceof HttpMessageNotReadableException){
                log.error("Message could not be parsed");
                throw new JsonMappingException();
            }
            log.error("Error: {}", ex);
        }
        return null;
    }
}