package com.appbuilder.u7p87;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


import java.util.Locale;

public class StatisticsActivity extends AppCompatActivity {


    private WebView web;
    private String localization;

    //для получения статуса загрузки webView (100%?)
    boolean redirect = false;
    boolean completely_loaded = true;

    //для swipe Refresh webVIew
    SwipeRefreshLayout swipeRefreshLayout;


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

        //для swipe Refresh layout
        swipeRefreshLayout = findViewById(R.id.reload);
        // возможно надо в другом месте писать код
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                web.reload();
            }
        });


        WebSettings ws = web.getSettings();
        ws.setJavaScriptEnabled(true);
        //чтобы ссылки открывались внутри приложения
       // web.setWebViewClient(new WebViewClient());

        web.setWebViewClient(new WebViewClient(){

            //для получения статуса загрузки webView (100%?)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(!completely_loaded) {
                    redirect = true;
                }
                completely_loaded = false;
                web.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                completely_loaded = false;
                Log.d("completely_loaded", completely_loaded+"");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                //после того, как страница обновилась, убрать spinner от swipe to refresh
                swipeRefreshLayout.setRefreshing(false);

                if(!redirect){
                    completely_loaded = true;
                }
                if(completely_loaded && !redirect) {
                    // ==============page is completely Loaded ======== - можно добавить ProgressBar - точнее скрыть здесь

                    //Toast toast = Toast.makeText(StatisticsActivity.this, "Веб страница загружена", Toast.LENGTH_LONG);
                    //toast.show();

                    Log.d("completely_loaded", completely_loaded+"");
                    Log.d("completely_loaded", "Page is Completely Loaded");

                }
                else {
                    redirect = false;
                }
            }

            //если страница не загрузилась, показать это. Надо показать какое-то сообщение или заменить на статичный webView "index.html"
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                                         //logic
                Toast toast = Toast.makeText(StatisticsActivity.this, "Веб страница НЕ загружена", Toast.LENGTH_LONG);
                toast.show();

                web.loadUrl("file:///android_asset/index.html");
            }



            //КОНЕЦ КОДА для получения статуса загрузки webView (100%?) и загрузки страницы по умолчанию, если нет интернета
        }); //конец web.setWebViewClient(new WebViewClient()



        //выравнивание по ширине экрана мобильного устройства - =======!!!!!!!Возможно это надо перед строкой - web.setWebViewClient(new WebViewClient());
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