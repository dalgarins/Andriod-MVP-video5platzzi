package libro.test.com.video5platzzi.injections.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import libro.test.com.video5platzzi.api.rest.TwitterRestApi;
import retrofit2.Retrofit;

/**
 * Created by NoaD on 28/02/2017.
 */
@Module
public class TwitterClientModule {

    @Provides
    @Singleton
    TwitterRestApi provideTwitterClient(Retrofit retrofit){
        return retrofit.create(TwitterRestApi.class);
    }
}
