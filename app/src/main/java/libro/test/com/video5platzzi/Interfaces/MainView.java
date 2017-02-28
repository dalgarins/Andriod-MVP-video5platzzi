package libro.test.com.video5platzzi.interfaces;

import android.view.View;

import java.util.ArrayList;

import libro.test.com.video5platzzi.model.Tweet;

/**
 * Created by NoaD on 14/11/2016.
 */

public interface MainView {

    void setAdapter(ArrayList<Tweet> tweets);
    void showProgressBar();
    void hideProgressBar();
    void loadTweets();
    void showSnackBar(View view);

}
