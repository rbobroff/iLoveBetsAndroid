package com.appbuilder.u7p87;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Locale;

public class StatisticsActivity extends AppCompatActivity {


    private WebView web;
    private String localization;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        //узнаем язык телефона

        localization = Locale.getDefault().getLanguage();
        System.out.println("Язык статистики: " + localization);

        //инициализируем переменную
        web = (WebView)findViewById(R.id.webViewStat);
        //создаем переменную с настройками
        WebSettings ws = web.getSettings();
        ws.setJavaScriptEnabled(true);
        //чтобы ссылки открывались внутри приложения
        web.setWebViewClient(new WebViewClient());
        //выравнивание по ширине экрана мобильного устройства
        ws.setUseWideViewPort(true);
        ws.setLoadWithOverviewMode(true);
        if (localization == "ru")
        {
            web.loadUrl("https://ilovebets.ru/mobileapp/ios/statisticsrus/");
        } else {
            web.loadUrl("https://ilovebets.ru/mobileapp/ios/statisticseng/");
        }

        statisticsActionBar();


    } //конец метода onCreate


    //чтобы была возможность переходить назад при нажатии кнопки назад в браузере
    @Override
    public void onBackPressed() {
        if (web.canGoBack())
            web.goBack();
        else
            super.onBackPressed();
    }

    //Показать ActionBar и кнопку назад
    public void statisticsActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.show();
        actionBar.setTitle(R.string.statistics_action_bar);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //фон для ActionBar
        Drawable drawable;
        Resources resources = getResources();
        drawable = resources.getDrawable(R.drawable.background);
        actionBar.setBackgroundDrawable(drawable);
    }


} //конец класса