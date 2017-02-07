package ru.tsk.eveonline.modules.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import ru.tsk.eveonline.R;
import ru.tsk.eveonline.app.EveApplication;
import ru.tsk.eveonline.dagger.main.DaggerMainViewComponent;
import ru.tsk.eveonline.dagger.main.MainViewComponent;
import ru.tsk.eveonline.dagger.main.MainViewModule;

public class MainActivity extends AppCompatActivity implements MainViewContract.View {

    private MainViewComponent component;

    @Inject
    protected MainViewContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        component = DaggerMainViewComponent.builder()
                .appComponent(EveApplication.getAppComponent())
                .mainViewModule(new MainViewModule())
                .build();

//        presenter.init(this);
    }

    @Override
    public void showError(String errorText) {

    }
}
