package sdk.mocha.response;

import java.io.Serializable;

public class CommonResponseREST implements Serializable{
    public String statuscode;
    public String description;

    @Override
    public String toString() {
        return "CommonResponseREST{" +
                "statuscode='" + statuscode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
