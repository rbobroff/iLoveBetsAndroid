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
//7. Основной webView: https://www.youtube.com/watch?app=desktop&v=g4-ZqnxGFgw&list=PL0lO_mIqDDFW13-lP3IgK9lZoM1M-oPl4&index=17&huid=SqmOks30oom8ReVkyp690A
//8. Проверка, что webView загрузился на 100%: https://www.youtube.com/watch?v=ETHj0ZzdRh8
//9. Pull to refresh webView: https://www.youtube.com/watch?v=qfDiDmM1014
//9.1 Pull to refresh webView. Как правильно выстроить constraints, чтобы при прокрутке вверх содержимого окна не происходил refresh
//https://www.youtube.com/watch?v=kuzXdK3AKTs
//10 E-Mail:https://www.youtube.com/watch?v=GOqv3jnw_Go
/*starting with API level 30
        <!--это необходимо, чтобы правильно срабатывало условие для выбора приложения при нажатии Email-->
        <queries>
        <intent>
        <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.BROWSABLE" />
        <data android:scheme="mailto" />
        </intent>
        </queries>
*/
// 12. Push notification для API 26 (Android 8)
    //https://www.youtube.com/watch?v=m8vUFO5mFIM
    //Doesn't show #signing report in gradle bar for google firebase:
    //https://www.youtube.com/watch?v=Ah1wX26lmxY

//13. json
//https://www.youtube.com/watch?v=yU1zHRXBGSE

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;



public class MainActivity extends AppCompatActivity {


    ImageButton imageStatisticsButton;
    ImageButton imageBettingTipsButton;
    ImageButton imageHelpButton;
    ImageButton imageEmailButton;
    ImageButton imageAboutUsButton;
    ImageButton imageChatButton;

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
        //emailTransitionActivity();
        aboutUsTransitionActivity();
        chatTransitionActivity();
        hideSportsBettingTipsLabel();



        //Запус email клиента приложения для написания письма и проверка, что установлено приложение
        imageEmailButton = findViewById(R.id.emailImageButton4);
        imageEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO,
                        Uri.fromParts("mailto", "ilovebets@ya.ru", null));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(intent, "Email - iLoveBets.App"));
                } else {
                    Toast.makeText(MainActivity.this, "There is no application that support this action", Toast.LENGTH_SHORT).show();
                }
            }
        });



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
    /*public void emailTransitionActivity(){
        imageEmailButton = findViewById(R.id.emailImageButton4);
        imageEmailButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EmailActivity.class));
            }
        });
    }*/



    //Переход на экран AboutUsActivity
    public void aboutUsTransitionActivity(){
        imageAboutUsButton = findViewById(R.id.aboutUsImageButton6);
        imageAboutUsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
            }
        });
    }


    //Переход на экран ChatActivity
    public void chatTransitionActivity(){
        imageChatButton = findViewById(R.id.chatImageButton5);
        imageChatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ChatActivity.class));
            }
        });
    }






} //конец класса