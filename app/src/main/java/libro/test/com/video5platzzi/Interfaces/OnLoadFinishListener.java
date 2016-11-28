package libro.test.com.video5platzzi.Interfaces;

import java.util.ArrayList;

import libro.test.com.video5platzzi.model.Tweet;

/**
 * Created by NoaD on 14/11/2016.
 */

public interface OnLoadFinishListener {

    void onSuccess(ArrayList<Tweet> tweets);
    void onError(String msg);

}
