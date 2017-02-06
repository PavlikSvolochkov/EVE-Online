package ru.tsk.eveonline.dagger;

public interface IBasePresenter<T> {

    void init(T view);

    void onViewCreate();

    void onViewStart();

    void onViewStop();
}
