package libro.test.com.video5platzzi.interactors;

import android.util.Base64;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Provider;

import libro.test.com.video5platzzi.interfaces.MainInteractor;
import libro.test.com.video5platzzi.interfaces.OnLoadFinishListener;
import libro.test.com.video5platzzi.api.rest.TwitterRestApi;
import libro.test.com.video5platzzi.model.Tweet;
import libro.test.com.video5platzzi.model.api.rest.Authenticate;
import libro.test.com.video5platzzi.utils.Utils;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by NoaD on 14/11/2016.
 */

public class MainInteractorImpl implements MainInteractor {

    private TwitterRestApi service;

    @Inject public MainInteractorImpl(TwitterRestApi service){
        this.service = service;
    }

    /**
     * Carga los tweets y decide que hacer segun el listener
     * @param finishListener OnLoadFinishListener
     */
    @Override
    public void loadTweets(final OnLoadFinishListener finishListener) {

        String combined = Utils.API_KEY + ":" + Utils.API_SECRET;

        service.getAuthorizationToken("Basic " + Base64.encodeToString(combined.getBytes(), Base64.NO_WRAP), "client_credentials").enqueue(new Callback<Authenticate>() {
            @Override
            public void onResponse(Call<Authenticate> call, Response<Authenticate> response) {

                if (response.body() != null){

                    service.getTweetsByQuery("Bearer " + response.body().getAccess_token(), "mejorandola").enqueue(new Callback<ResponseBody>() {


                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                            ArrayList<Tweet> tweets = new ArrayList<Tweet>();

                            try {
                                String timeline = response.body().string();
                                JSONObject jsonResponse = new JSONObject(timeline);
                                JSONArray jsonArray = jsonResponse.getJSONArray("statuses");
                                JSONObject jsonObject;
                                for (int i = 0; i < jsonArray.length(); i++){

                                    jsonObject = (JSONObject)jsonArray.get(i);

                                    Tweet tweet = new Tweet();

                                    tweet.setName(jsonObject.getJSONObject("user").getString("name"));
                                    tweet.setScreenName(jsonObject.getJSONObject("user").getString("screen_name"));
                                    tweet.setProfileImageUrl(jsonObject.getJSONObject("user").getString("profile_image_url"));
                                    tweet.setText(jsonObject.getString("text"));
                                    tweet.setCreatedAt(jsonObject.getString("created_at"));

                                    tweets.add(i, tweet);
                                }
                                Log.d("Tweets", response.body().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            finishListener.onSuccess(tweets);
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<Authenticate> call, Throwable t) {

            }

        });
    }
}
