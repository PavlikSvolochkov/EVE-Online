package ru.tsk.eveonline.dagger.main;

import dagger.Module;
import dagger.Provides;
import ru.tsk.eveonline.modules.main.MainViewContract;
import ru.tsk.eveonline.modules.main.MainViewPresenter;

@Module
public class MainViewModule {
    @Provides
    public MainViewContract.Presenter provideMainViewPresenter() {
        return new MainViewPresenter();
    }
}
