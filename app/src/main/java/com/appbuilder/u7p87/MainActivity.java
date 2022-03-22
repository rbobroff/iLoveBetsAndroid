package com.appbuilder.u7p87;

//1. Инструкция по иконке приложения: https://www.youtube.com/watch?v=96TAF20qPH0
//2. Экран загрузки приложения: 1) https://www.youtube.com/watch?v=Zlo3qpkZ1aI&t=257s 2) Или Урок 5 - geekbrains. Android 1. 1ч 29 мин 13 с
//3. Кнопка назад и переход на новый активити: https://www.youtube.com/watch?v=bli1mLIjhHw
//4. Фон для ActionBar: http://android-er.blogspot.com/2015/04/set-icon-and-background-of-actionbar.html
//5. //Cosntraints: 1) https://www.youtube.com/watch?v=jz5YPZr0A6E&list=PLH3y3SWteZd2RlWYNjzix14WFkTMvVW0A&index=18
     //             2) http://developer.alexanderklimov.ru/android/layout/relativelayout.php
//6. Размеры экранов (small, normal, large, xlarge)
// Small - 2.7 QVGA (320 x 427 dp, ldpi)
// Normal - Pixel (411 x 731 dp, 420 dpi)
// Large - 7 inch, Nexus 7 (600 x 960 dp, xhdp)
//40 sp - в 2 раза больше
// xLarge - 9, 10 inch, Nexus 10 (1280 x 800 dp, xhdp) или Pixel C (1280 x 900 dp, xhdp)



import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Locale;



public class MainActivity extends AppCompatActivity {


    ImageButton imageStatisticsButton;
    ImageButton imageBettingTipsButton;
    ImageButton imageHelpButton;
    ImageButton imageEmailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hideActionBar();
        languageSettings();
        densityName();
        densityScreenParameters();
        bettingTipsTransitionActivity();
        statisticsTransitionActivity();
        helpTransitionActivity();
        emailTransitionActivity();
        hideSportsBettingTipsLabel();


    } //конец метода onCreate


    //Вывести имена плотности экранов в консоль
    public void densityName() {
        float density = getResources().getDisplayMetrics().density;
        if (density >= 4.0) {
            Log.d("Имя плотности экрана:", "xxxhdpi");
        }
        if (density >= 3.0 && density < 4.0) {
            Log.d("Имя плотности экрана:", "xxhdpi");
        }
        if (density >= 2.0 && density < 3.0) {
            Log.d("Имя плотности экрана:", "xhdpi");
        }
        if (density >= 1.5 && density < 2.0) {
            Log.d("Имя плотности экрана:", "hdpi");
        }
        if (density >= 1.0 && density < 1.5) {

            Log.d("Имя плотности экрана:", "mdpi");
        }
        if (density < 1.0) {
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


    //Скрыть нижнюю надпись для небольших телефонов
    public void hideSportsBettingTipsLabel() {
        TextView sportsBettingTipsLabel = findViewById(R.id.sports_betting_tips_label_textView4);
        Float phoneHeightPX;
        Float phoneHeightDP;
        Float PxToDp;
        phoneHeightPX = Float.valueOf(getResources().getDisplayMetrics().heightPixels);
        phoneHeightDP = Float.valueOf(getResources().getDisplayMetrics().density);
        System.out.println("Проверка высоты PX для метода = " + phoneHeightPX);
        System.out.println("Проверка dp для метода = " + phoneHeightDP);
        PxToDp = phoneHeightPX / phoneHeightDP;
        System.out.println("Деление PxToDp = " + PxToDp);
        if (PxToDp < 710)
        {
            //sportsBettingTipsLabel.setText("Lf");
           sportsBettingTipsLabel.setVisibility(View.INVISIBLE);
        } //конец условия

    } //конец метода скрыть нижний label



    //Вывод языка телефона
    public void languageSettings() {
        Log.d("Язык", Locale.getDefault().getLanguage());
    }


    //Скрыть ActionBar
    public void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }


    //Переход на экран BettingTips
    public void bettingTipsTransitionActivity() {
        imageBettingTipsButton = findViewById(R.id.bettingTipsImageButton1);
        imageBettingTipsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BettingTipsActivity.class));
            }
        });
    }


    //Переход на экран StatisticsActivity
    public void statisticsTransitionActivity(){
        imageStatisticsButton = findViewById(R.id.statisticsImageButton2);
        imageStatisticsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StatisticsActivity.class));
            }
        });
    }

    //Переход на экран HelpActivity
    public void helpTransitionActivity(){
        imageHelpButton = findViewById(R.id.helpImageButton3);
        imageHelpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HelpActivity.class));
            }
        });
    }

    //Переход на экран EmailActivity
    public void emailTransitionActivity(){
        imageEmailButton = findViewById(R.id.emailImageButton4);
        imageEmailButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EmailActivity.class));
            }
        });
    }






} //конец класса