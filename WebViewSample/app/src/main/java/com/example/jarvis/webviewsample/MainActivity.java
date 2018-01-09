package com.example.jarvis.webviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = (WebView) findViewById(R.id.webview);
        TextView textView = (TextView) findViewById(R.id.textView);
        webView.getSettings().setSaveFormData(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("file:///android_asset/test.html");
        InputStream is = null;
        try {
            is = getAssets().open("test.html");
            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String str = new String(buffer);
//            str = str.replace("old string", "new string");
            textView.setText(Html.fromHtml(str));
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
