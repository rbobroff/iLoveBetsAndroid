package com.appbuilder.u7p87;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class EmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);


        emailActionBar();

    } //конец метода onCreate



    //Показать ActionBar и кнопку назад
    public void emailActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.show();
        actionBar.setTitle(R.string.email_action_bar);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //фон для ActionBar
        Drawable drawable;
        Resources resources = getResources();
        drawable = resources.getDrawable(R.drawable.background);
        actionBar.setBackgroundDrawable(drawable);
    }

} //конец класса