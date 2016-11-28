package libro.test.com.video5platzzi.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import libro.test.com.video5platzzi.R;
import libro.test.com.video5platzzi.databinding.ListItemTweetBinding;
import libro.test.com.video5platzzi.model.Tweet;

/**
 * Created by NoaD on 19/11/2016.
 */

public class TweetAdapter extends ArrayAdapter<Tweet> {

    private LayoutInflater inflater;
    private ArrayList<Tweet> tweets;


    public TweetAdapter(Context context, ArrayList<Tweet> tweets){
        super(context, 0, tweets);
        this.tweets = tweets;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        ListItemTweetBinding binding;
        if (convertView == null){
            binding = DataBindingUtil.inflate(inflater, R.layout.list_item_tweet, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }
        binding.setTweet(tweets.get(position));
        convertView = binding.getRoot();
        return convertView;
    }
}
