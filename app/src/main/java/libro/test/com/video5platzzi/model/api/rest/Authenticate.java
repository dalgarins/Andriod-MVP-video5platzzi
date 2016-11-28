package libro.test.com.video5platzzi.model.api.rest;

/**
 * Created by NoaD on 27/11/2016.
 */

public class Authenticate {

    String token_type;
    String access_token;

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
