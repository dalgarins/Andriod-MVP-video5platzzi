package libro.test.com.video5platzzi.injections.modules;

import dagger.Module;
import dagger.Provides;
import libro.test.com.video5platzzi.model.Tweet;

/**
 * Created by NoaD on 28/02/2017.
 */
@Module
public class EntityModule {

    @Provides
    Tweet provideTweet(){
        return new Tweet();
    }
}
