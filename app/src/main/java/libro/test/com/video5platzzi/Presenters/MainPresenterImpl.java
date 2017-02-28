package libro.test.com.video5platzzi.presenters;

import java.util.ArrayList;

import libro.test.com.video5platzzi.interactors.MainInteractorImpl;
import libro.test.com.video5platzzi.interfaces.MainInteractor;
import libro.test.com.video5platzzi.interfaces.MainPresenter;
import libro.test.com.video5platzzi.interfaces.MainView;
import libro.test.com.video5platzzi.interfaces.OnLoadFinishListener;
import libro.test.com.video5platzzi.model.Tweet;

/**
 * Presentador del main activity
 */

public class MainPresenterImpl implements MainPresenter, OnLoadFinishListener {

    private MainView view;
    private MainInteractor interactor;

    public MainPresenterImpl(MainView view, MainInteractor mainInteractor){
        this.view = view;
        this.interactor = mainInteractor;
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
