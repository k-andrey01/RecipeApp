package com.bignerdranch.android.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    String selectedItem = "https://vk.com/dany1612";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.activity_web);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            selectedItem = extras.getString("url");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        WebFragment fragment = (WebFragment) getSupportFragmentManager()
                .findFragmentById(R.id.webFragment);
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        if (fragment != null){
            WebView browser = findViewById(R.id.webBrowser);
            System.out.println(selectedItem);
            browser.loadUrl(selectedItem);
        }
    }
}