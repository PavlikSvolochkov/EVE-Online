package ru.tsk.eveonline.app;

public interface IBasePresenter<T> {

    void init(T view);

    void onViewCreate();

    void onViewStart();

    void onViewStop();
}
