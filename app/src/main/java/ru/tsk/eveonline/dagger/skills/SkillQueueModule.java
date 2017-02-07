package ru.tsk.eveonline.dagger.skills;

import dagger.Module;
import dagger.Provides;
import ru.tsk.eveonline.modules.skills.SkillQueueContract;
import ru.tsk.eveonline.modules.skills.SkillQueuePresenter;

@Module
public class SkillQueueModule {
    @Provides
    public SkillQueueContract.Presenter provideSkillQueuePresenter() {
        return new SkillQueuePresenter();
    }
}
