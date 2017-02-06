package ru.tsk.eveonline.modules.skill_queue;

import ru.tsk.eveonline.dagger.IBasePresenter;
import ru.tsk.eveonline.dagger.IBaseView;

public class SkillQueueContract {

    public interface Presenter extends IBasePresenter<View> {
    }

    public interface View extends IBaseView<Presenter> {
    }
}
