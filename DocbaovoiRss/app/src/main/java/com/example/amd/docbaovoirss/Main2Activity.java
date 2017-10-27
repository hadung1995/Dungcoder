package com.example.amd.docbaovoirss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {
WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        wv=(WebView)findViewById(R.id.web);
        Intent intent = getIntent();
        String link=intent.getStringExtra("linktintuc");
        wv.loadUrl(link);
        wv.setWebViewClient(new WebViewClient());
    }
}
