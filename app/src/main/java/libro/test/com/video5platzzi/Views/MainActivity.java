package libro.test.com.video5platzzi.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import javax.inject.Inject;

import libro.test.com.video5platzzi.Video5PlatzziComponent;
import libro.test.com.video5platzzi.base.ui.BaseActivity;
import libro.test.com.video5platzzi.injections.components.DaggerMainViewComponent;
import libro.test.com.video5platzzi.injections.modules.MainViewModule;
import libro.test.com.video5platzzi.interfaces.MainPresenter;
import libro.test.com.video5platzzi.interfaces.MainView;
import libro.test.com.video5platzzi.presenters.MainPresenterImpl;
import libro.test.com.video5platzzi.R;
import libro.test.com.video5platzzi.adapters.TweetAdapter;
import libro.test.com.video5platzzi.databinding.ActivityMainBinding;
import libro.test.com.video5platzzi.model.Tweet;

public class MainActivity extends BaseActivity implements MainView {

    private ActivityMainBinding binding;
    @Inject MainPresenter presenter;
    TweetAdapter tweetAdapter;

    @Override
    protected void onCreateDataBindingView(@Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);

        //presenter = new MainPresenterImpl(this);

        tweetAdapter = new TweetAdapter(this, new ArrayList<Tweet>());
        binding.contentMain.lvTweets.setAdapter(tweetAdapter);

        binding.setMainView(this);

        loadTweets();
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

    @Override
    public void setUpComponent(Video5PlatzziComponent appComponent) {
        DaggerMainViewComponent.builder().video5PlatzziComponent(appComponent)
                .mainViewModule(new MainViewModule(this))
                .build()
                .inject(this);
    }
}
