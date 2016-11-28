package libro.test.com.video5platzzi.Views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import libro.test.com.video5platzzi.Interfaces.MainPresenter;
import libro.test.com.video5platzzi.Interfaces.MainView;
import libro.test.com.video5platzzi.Presenters.MainPresenterImpl;
import libro.test.com.video5platzzi.R;
import libro.test.com.video5platzzi.adapters.TweetAdapter;
import libro.test.com.video5platzzi.databinding.ActivityMainBinding;
import libro.test.com.video5platzzi.model.Tweet;

public class MainActivity extends AppCompatActivity implements MainView{

    private ActivityMainBinding binding;
    private MainPresenter presenter;
    private TweetAdapter tweetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);
        presenter = new MainPresenterImpl(this);

        tweetAdapter = new TweetAdapter(this, new ArrayList<Tweet>());
        binding.contentMain.lvTweets.setAdapter(tweetAdapter);

        binding.setMainView(this);

        presenter.loadTweets();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setAdapter(ArrayList<Tweet> tweets) {
        tweetAdapter.clear();
        tweetAdapter.addAll(tweets);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void loadTweets() {
        presenter.loadTweets();
    }

    @Override
    public void showSnackBar(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
