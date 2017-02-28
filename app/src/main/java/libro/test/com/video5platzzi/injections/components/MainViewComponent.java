package libro.test.com.video5platzzi.injections.components;

import dagger.Component;
import libro.test.com.video5platzzi.ActivityScope;
import libro.test.com.video5platzzi.Video5PlatzziComponent;
import libro.test.com.video5platzzi.injections.modules.MainViewModule;
import libro.test.com.video5platzzi.interfaces.MainPresenter;
import libro.test.com.video5platzzi.views.MainActivity;

/**
 * Created by NoaD on 28/02/2017.
 */
@ActivityScope
@Component(dependencies = Video5PlatzziComponent.class, modules = MainViewModule.class)
public interface MainViewComponent {

    void inject(MainActivity mainActivity);
    MainPresenter getMainPresenter();
}
