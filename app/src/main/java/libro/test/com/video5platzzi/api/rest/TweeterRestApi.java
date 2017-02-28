package libro.test.com.video5platzzi.api.rest;

import libro.test.com.video5platzzi.model.api.rest.Authenticate;
import okhttp3.ResponseBody;
import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by NoaD on 14/11/2016.
 */

public interface TweeterRestApi {

    @POST("oauth2/token")
    @FormUrlEncoded
    Call<Authenticate> getAuthorizationToken(@Header("Authorization") String auth, @Field("grant_type") String client_credentials);

    @GET("1.1/search/tweets.json")
    Call<ResponseBody> getTweetsByQuery(@Header("Authorization") String bearer, @Query("q") String query);

}
