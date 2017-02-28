package libro.test.com.video5platzzi;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by NoaD on 28/02/2017.
 */
@Module
public class Video5PlatzziModule {

    private Video5PlatzziApp app;

    public Video5PlatzziModule(Video5PlatzziApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return app;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return app;
    }

}
