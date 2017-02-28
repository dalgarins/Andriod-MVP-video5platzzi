package libro.test.com.video5platzzi.base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import libro.test.com.video5platzzi.Video5PlatzziApp;
import libro.test.com.video5platzzi.interfaces.injections.Injectable;

/**
 * Created by NoaD on 28/02/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements Injectable {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        onCreateDataBindingView(savedInstanceState);
    }

    protected abstract void onCreateDataBindingView(@Nullable Bundle savedInstanceState);

    /**
     * Setup the object graph and inject the dependencies needed on this activity.
     */
    private void injectDependencies() {
        setUpComponent(Video5PlatzziApp.getApp(this).getComponent());
    }
}
