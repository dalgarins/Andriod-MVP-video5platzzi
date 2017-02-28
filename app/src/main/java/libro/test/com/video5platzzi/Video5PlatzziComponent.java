package libro.test.com.video5platzzi;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import libro.test.com.video5platzzi.api.rest.TwitterRestApi;
import libro.test.com.video5platzzi.injections.modules.EntityModule;
import libro.test.com.video5platzzi.injections.modules.MainInteractorModule;
import libro.test.com.video5platzzi.injections.modules.RestClientModule;
import libro.test.com.video5platzzi.injections.modules.TwitterClientModule;
import libro.test.com.video5platzzi.interfaces.MainInteractor;
import libro.test.com.video5platzzi.model.Tweet;
import retrofit2.Retrofit;

/**
 * Created by NoaD on 28/02/2017.
 */
@Singleton
@Component(modules = {Video5PlatzziModule.class,
        RestClientModule.class,
        TwitterClientModule.class,
        MainInteractorModule.class,
        EntityModule.class
})
public interface Video5PlatzziComponent {

    void inject(Video5PlatzziApp app);

    Context getContext();
    Application getProvidedApplication();
    Retrofit getRetrofit();
    TwitterRestApi getTwitterClient();
    MainInteractor getMainInteractor();
    Tweet getTweet();
}
