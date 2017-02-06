package ru.tsk.eveonline.dagger.skills;

import dagger.Module;
import dagger.Provides;
import ru.tsk.eveonline.modules.skill_queue.SkillQueueContract;
import ru.tsk.eveonline.modules.skill_queue.SkillQueuePresenter;

@Module
public class SkillQueueModule {
    @Provides
    public SkillQueueContract.Presenter provideSkillQueuePresenter() {
        return new SkillQueuePresenter();
    }
}
