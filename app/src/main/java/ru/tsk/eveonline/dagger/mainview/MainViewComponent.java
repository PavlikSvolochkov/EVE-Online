package ru.tsk.eveonline.dagger.mainview;

import dagger.Component;
import ru.tsk.eveonline.dagger.AppComponent;
import ru.tsk.eveonline.modules.mainview.MainActivity;

@Component(modules = MainViewModule.class, dependencies = AppComponent.class)
public interface MainViewComponent {
    void inject(MainActivity relaxFragment);
}
