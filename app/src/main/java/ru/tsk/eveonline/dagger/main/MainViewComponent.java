package ru.tsk.eveonline.dagger.main;

import dagger.Component;
import ru.tsk.eveonline.dagger.AppComponent;
import ru.tsk.eveonline.dagger.scope.ActivityScope;
import ru.tsk.eveonline.modules.main.MainActivity;

@ActivityScope
@Component(modules = MainViewModule.class, dependencies = AppComponent.class)
public interface MainViewComponent {
    void inject(MainActivity relaxFragment);
}
