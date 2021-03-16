package br.pucminas.telasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    WebView minhaWebView;
    TextView textoURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);


        Bundle bundle = getIntent().getExtras();
        textoURL = findViewById(R.id.textView2)      ;

        minhaWebView = findViewById(R.id.webView1) ;
        minhaWebView.setWebViewClient(new WebViewClient());
        minhaWebView.getSettings().setJavaScriptEnabled(true);



        String minhaURL =   bundle.getString("MinhaURL");
        textoURL.setText(minhaURL);
        if ( minhaURL != null) {

          minhaWebView.loadUrl(minhaURL);
        }
    }
}