package libro.test.com.video5platzzi.Presenters;

import java.util.ArrayList;

import libro.test.com.video5platzzi.Interactors.MainInteractorImpl;
import libro.test.com.video5platzzi.Interfaces.MainInteractor;
import libro.test.com.video5platzzi.Interfaces.MainPresenter;
import libro.test.com.video5platzzi.Interfaces.MainView;
import libro.test.com.video5platzzi.Interfaces.OnLoadFinishListener;
import libro.test.com.video5platzzi.model.Tweet;

/**
 * Created by NoaD on 14/11/2016.
 */

public class MainPresenterImpl implements MainPresenter, OnLoadFinishListener {

    private MainView view;
    private MainInteractor interactor;

    public MainPresenterImpl(MainView view){
        this.view = view;
        this.interactor = new MainInteractorImpl();
    }

    @Override
    public void loadTweets() {
        if (view != null){
            view.showProgressBar();
        }
        interactor.loadTweets(this);
    }

    @Override
    public void onSuccess(ArrayList<Tweet> tweets) {
        if (view != null){
            view.hideProgressBar();
            view.setAdapter(tweets);
        }
    }

    @Override
    public void onError(String msg) {
        if (view != null){
            view.hideProgressBar();
        }
    }
}
