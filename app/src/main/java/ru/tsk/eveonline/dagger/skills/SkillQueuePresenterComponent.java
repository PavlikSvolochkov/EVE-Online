package ru.tsk.eveonline.dagger.skills;

import dagger.Component;
import ru.tsk.eveonline.dagger.AppComponent;
import ru.tsk.eveonline.modules.skills.SkillQueueFragment;

@Component(modules = SkillQueueModule.class, dependencies = AppComponent.class)
public interface SkillQueuePresenterComponent {
    void inject(SkillQueueFragment skillQueueFragment);
}

