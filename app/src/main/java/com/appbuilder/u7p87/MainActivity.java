package com.appbuilder.u7p87;

//Инструкция по иконке приложения: https://www.youtube.com/watch?v=96TAF20qPH0
//Экран загрузки приложения: 

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


    }
}