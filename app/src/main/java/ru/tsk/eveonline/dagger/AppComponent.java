package ru.tsk.eveonline.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context context();

//    void injectsMainActivity(MainActivity mainActivity);

//    void injectsSkillQueueFragment(SkillQueueFragment fragment);
}
