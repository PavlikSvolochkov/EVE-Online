package ru.tsk.eveonline.dagger.mainview;

import dagger.Module;
import dagger.Provides;
import ru.tsk.eveonline.modules.mainview.MainViewContract;
import ru.tsk.eveonline.modules.mainview.MainViewPresenter;

@Module
public class MainViewModule {
    @Provides
    public MainViewContract.Presenter provideMainViewPresenter() {
        return new MainViewPresenter();
    }
}
