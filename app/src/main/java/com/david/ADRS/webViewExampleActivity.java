package com.example.david.ADRS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by david on 15/07/17.
 */

public class webViewExampleActivity extends Activity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        setContentView(R.layout.webviewexample);
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");
        String profilePictureURL = getIntent().getStringExtra("photo_path");
        TextView usrname = (TextView) findViewById(R.id.username);
        TextView pasword = (TextView) findViewById(R.id.password);
        usrname.setText(username);
        pasword.setText(password);
        ImageView profilePicture = (ImageView) findViewById(R.id.profilePicture);
        pictureManagement.updatePicture(profilePicture,profilePictureURL);
        WebView myWebView = (WebView) findViewById(R.id.webViewExample);
        myWebView.loadUrl("https://www.google.fr/");


    }



}

