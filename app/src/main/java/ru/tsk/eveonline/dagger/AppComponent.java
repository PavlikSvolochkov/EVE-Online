package ru.tsk.eveonline.dagger;

import dagger.Component;
import ru.tsk.eveonline.dagger.database.StorageModule;
import ru.tsk.eveonline.modules.main.MainActivity;

@Component(modules = {StorageModule.class})
public interface AppComponent {

    void injectsMainActivity(MainActivity mainActivity);

}
