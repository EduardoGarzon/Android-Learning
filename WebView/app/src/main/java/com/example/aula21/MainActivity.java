package com.example.aula21;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView wv1;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url="file:///android_asset/pagina1.html";

        wv1=findViewById(R.id.wv);
        wv1.loadUrl(url);
        wv1.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                super.onPageStarted(view, url, favicon);
                // codigo a ser executado no inicio do carregamento da pagina

            }
            public void onPageFinished(WebView view, String url){
                super.onPageFinished(view, url);
                // codigo a ser executado no final do carregamento da pagina

            }

        });
    }
}