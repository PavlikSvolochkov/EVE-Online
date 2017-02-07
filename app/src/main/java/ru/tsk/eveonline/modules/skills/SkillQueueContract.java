package ru.tsk.eveonline.modules.skills;

import java.util.List;
import java.util.concurrent.ExecutionException;

import ru.tsk.eveonline.app.IBasePresenter;
import ru.tsk.eveonline.app.IBaseView;
import ru.tsk.eveonline.logic.SkillQueueItem;

public class SkillQueueContract {

    public interface View extends IBaseView<Presenter> {
        void setSkillQueueListAdapter() throws ExecutionException, InterruptedException;
    }

    public interface Presenter extends IBasePresenter<View> {
        List<SkillQueueItem> getSkillQueue() throws ExecutionException, InterruptedException;
    }
}
