package ru.tsk.eveonline.modules.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ru.tsk.eveonline.R;

public class MainActivity extends AppCompatActivity implements MainViewContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showError(String errorText) {

    }
}
