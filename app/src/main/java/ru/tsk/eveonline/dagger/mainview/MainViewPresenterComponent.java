package ru.tsk.eveonline.dagger.mainview;

import dagger.Component;
import ru.tsk.eveonline.dagger.AppComponent;
import ru.tsk.eveonline.modules.skill_queue.SkillQueueFragment;

@Component(modules = MainViewModule.class, dependencies = AppComponent.class)
public interface MainViewPresenterComponent {
    void inject(SkillQueueFragment skillQueueFragment);
}
