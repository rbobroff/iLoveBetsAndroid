package com.appbuilder.u7p87;

//1. Инструкция по иконке приложения: https://www.youtube.com/watch?v=96TAF20qPH0
//2. Экран загрузки приложения: 1) https://www.youtube.com/watch?v=Zlo3qpkZ1aI&t=257s 2) Или Урок 5 - geekbrains. Android 1. 1ч 29 мин 13 с
//3. Кнопка назад и переход на новый активити: https://www.youtube.com/watch?v=bli1mLIjhHw
//4. Фон для ActionBar: http://android-er.blogspot.com/2015/04/set-icon-and-background-of-actionbar.html

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.Locale;



public class MainActivity extends AppCompatActivity {


    ImageButton imageStatisticsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        hideActionBar();
        languageSettings();
        densityName();
        densityScreenParameters();
        transitionActivity2();


    } //конец метода onCreate


    //Вывести имена плотности экранов в консоль
    public void densityName() {
        float density = getResources().getDisplayMetrics().density;
        if (density >= 4.0) {
            Log.d("Имя плотности экрана:", "xxxhdpi");
        }
        if (density >=  3.0 && density < 4.0) {
            Log.d("Имя плотности экрана:", "xxhdpi");
        }
        if (density >=  2.0 && density < 3.0) {
            Log.d("Имя плотности экрана:", "xhdpi");
        }
        if (density >=  1.5 && density < 2.0) {
            Log.d("Имя плотности экрана:", "hdpi");
        }
        if (density >=  1.0 && density < 1.5) {

            Log.d("Имя плотности экрана:", "mdpi");
        }
        if (density <  1.0) {
            Log.d("Имя плотности экрана:", "ldpi - 0.75");
        }
    } //конец метода densityNameMethod


    //Вывод характеристики экрана в консоль
    public void densityScreenParameters() {
        Log.d("Экран", String.valueOf(getResources().getDisplayMetrics().density));
        //Вывод DPI в консоль
        Log.d("Экран DPI", String.valueOf(getResources().getDisplayMetrics().densityDpi));
        Log.d("Ширина px", String.valueOf(getResources().getDisplayMetrics().widthPixels));
        Log.d("Высота px", String.valueOf(getResources().getDisplayMetrics().heightPixels));
        Log.d("Все параметры экрана", String.valueOf(getResources().getDisplayMetrics()));
    }

    //Вывод языка телефона
    public void languageSettings() {
        Log.d("Язык", Locale.getDefault().getLanguage());
    }


    //Скрыть ActionBar
    public void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }


    //Переход на новую Activity для тестирования кнопки назад
    public void transitionActivity2() {
        imageStatisticsButton = findViewById(R.id.imageStatisticsButton);
        imageStatisticsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StatisticsActivity.class));
            }
        });
    }








} //конец класса