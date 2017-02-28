package libro.test.com.video5platzzi;

import android.app.Application;
import android.content.Context;

import libro.test.com.video5platzzi.injections.modules.RestClientModule;

/**
 * Created by NoaD on 28/02/2017.
 */

public class Video5PlatzziApp extends Application {

    private static final String API_TWITTER = "https://api.twitter.com/";

    private Video5PlatzziComponent platzziComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        platzziComponent = DaggerVideo5PlatzziComponent.builder()
                .video5PlatzziModule(new Video5PlatzziModule(this))
                .restClientModule(new RestClientModule(API_TWITTER))
                .build();

        platzziComponent.inject(this);
    }

    public Video5PlatzziComponent getComponent() {
        return platzziComponent;
    }

    public static Video5PlatzziApp getApp(Context context) {
        return (Video5PlatzziApp) context.getApplicationContext();
    }
}
