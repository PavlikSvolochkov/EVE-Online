package ru.tsk.eveonline.modules.main;

import ru.tsk.eveonline.app.IBasePresenter;
import ru.tsk.eveonline.app.IBaseView;

public class MainViewContract {

    public interface Presenter extends IBasePresenter<MainViewContract.View> {
    }

    public interface View extends IBaseView<MainViewContract.Presenter> {
    }
}
