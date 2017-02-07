package ru.tsk.eveonline.dagger.skills;

import dagger.Component;
import ru.tsk.eveonline.dagger.AppComponent;
import ru.tsk.eveonline.dagger.scope.SkillQueue;
import ru.tsk.eveonline.modules.skills.SkillQueueFragment;

@SkillQueue
@Component(modules = SkillQueueModule.class, dependencies = AppComponent.class)
public interface SkillQueueComponent {

    void inject(SkillQueueFragment saveFragment);

}
