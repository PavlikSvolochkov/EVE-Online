package ru.tsk.eveonline.modules.mainview;

import ru.tsk.eveonline.dagger.IBasePresenter;
import ru.tsk.eveonline.dagger.IBaseView;

public class MainViewContract {

    public interface Presenter extends IBasePresenter<MainViewContract.View> {
    }

    public interface View extends IBaseView<MainViewContract.Presenter> {
    }
}
