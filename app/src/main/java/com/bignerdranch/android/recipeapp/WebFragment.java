package com.bignerdranch.android.recipeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class WebFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_web, container, false);
    }

    // обновление текстового поля
    public void setSelectedItem(String url) {
        WebView browser=getView().findViewById(R.id.webBrowser);
        browser.loadUrl(url);
    }
}