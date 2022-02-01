package com.appbuilder.u7p87;

//Инструкция по иконке приложения: https://www.youtube.com/watch?v=96TAF20qPH0
//Экран загрузки приложения: 1) https://www.youtube.com/watch?v=Zlo3qpkZ1aI&t=257s 2) Или Урок 5 - geekbrains. Android 1. 1ч 29 мин 13 с


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