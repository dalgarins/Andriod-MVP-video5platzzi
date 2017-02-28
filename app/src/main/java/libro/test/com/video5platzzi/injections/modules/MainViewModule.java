package libro.test.com.video5platzzi.injections.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import libro.test.com.video5platzzi.ActivityScope;
import libro.test.com.video5platzzi.interfaces.MainInteractor;
import libro.test.com.video5platzzi.interfaces.MainPresenter;
import libro.test.com.video5platzzi.interfaces.MainView;
import libro.test.com.video5platzzi.presenters.MainPresenterImpl;

/**
 * Created by NoaD on 28/02/2017.
 */
@Module
public class MainViewModule {

    private MainView mainView;

    public MainViewModule(MainView mainView){
        this.mainView = mainView;
    }

    @Provides
    public MainView provideMainView(){
        return mainView;
    }

    @Provides
    public MainPresenter provideMainPresenter(MainView view, MainInteractor interactor){
        return new MainPresenterImpl(view, interactor);
    }

}
