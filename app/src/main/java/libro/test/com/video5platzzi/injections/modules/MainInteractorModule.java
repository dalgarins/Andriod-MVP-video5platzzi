package libro.test.com.video5platzzi.injections.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import libro.test.com.video5platzzi.ActivityScope;
import libro.test.com.video5platzzi.api.rest.TwitterRestApi;
import libro.test.com.video5platzzi.interactors.MainInteractorImpl;
import libro.test.com.video5platzzi.interfaces.MainInteractor;

/**
 * Created by NoaD on 28/02/2017.
 */
@Module
public class MainInteractorModule {

    @Provides
    public MainInteractor provideMainInteractor(TwitterRestApi service){
        return new MainInteractorImpl(service);
    }

}
