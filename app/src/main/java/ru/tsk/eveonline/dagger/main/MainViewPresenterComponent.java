package ru.tsk.eveonline.dagger.main;

import dagger.Component;
import ru.tsk.eveonline.dagger.AppComponent;
import ru.tsk.eveonline.modules.skills.SkillQueueFragment;

@Component(modules = MainViewModule.class, dependencies = AppComponent.class)
public interface MainViewPresenterComponent {
    void inject(SkillQueueFragment skillQueueFragment);
}
