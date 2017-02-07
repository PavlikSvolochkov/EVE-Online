package ru.tsk.eveonline.modules.skills;

import java.util.List;
import java.util.concurrent.ExecutionException;

import ru.tsk.eveonline.async.SkillQueueTask;
import ru.tsk.eveonline.logic.SkillQueueItem;

public class SkillQueuePresenter implements SkillQueueContract.Presenter {


    @Override
    public void init(SkillQueueContract.View view) {
    }

    @Override
    public List<SkillQueueItem> getSkillQueue() throws ExecutionException, InterruptedException {
        return new SkillQueueTask().execute().get();
    }

    @Override
    public void onViewCreate() {
    }

    @Override
    public void onViewStart() {
    }

    @Override
    public void onViewStop() {
    }
}
