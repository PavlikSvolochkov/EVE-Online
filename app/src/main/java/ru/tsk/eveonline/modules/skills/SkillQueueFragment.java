package ru.tsk.eveonline.modules.skills;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import butterknife.ButterKnife;
import ru.tsk.eveonline.R;
import ru.tsk.eveonline.app.EveApplication;
import ru.tsk.eveonline.dagger.skills.DaggerSkillQueueComponent;
import ru.tsk.eveonline.dagger.skills.SkillQueueComponent;
import ru.tsk.eveonline.dagger.skills.SkillQueueModule;


public class SkillQueueFragment extends ListFragment implements SkillQueueContract.View {

    private SkillQueueComponent component;

    private SkillQueueAdapter queueAdapter;

    @Inject
    protected SkillQueueContract.Presenter presenter;


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(getActivity());

        component = DaggerSkillQueueComponent.builder()
                .appComponent(EveApplication.getAppComponent())
                .skillQueueModule(new SkillQueueModule())
                .build();

        presenter.init(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.skill_queue_fragment, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            setSkillQueueListAdapter();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setSkillQueueListAdapter() throws ExecutionException, InterruptedException {
        queueAdapter = new SkillQueueAdapter(getContext(), presenter.getSkillQueue());
        setListAdapter(queueAdapter);
    }

    @Override
    public void showError(String errorText) {

    }
}
