package ru.tsk.eveonline.app;

import android.app.Application;

import ru.tsk.eveonline.dagger.AppComponent;
import ru.tsk.eveonline.dagger.AppModule;
import ru.tsk.eveonline.dagger.DaggerAppComponent;

public class EveApplication extends Application {

    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }
}