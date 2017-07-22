package com.example.david.ADRS;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by david on 15/07/17.
 */

public class searchActivity extends Activity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        setContentView(R.layout.activity_search);
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");
        String profilePictureURL = getIntent().getStringExtra("photo_path");
        TextView usrname = (TextView) findViewById(R.id.username);
        TextView pasword = (TextView) findViewById(R.id.password);
        usrname.setText(username);
        pasword.setText(password);
        ImageView profilePicture = (ImageView) findViewById(R.id.profilePicture);
        pictureManagement.updatePicture(profilePicture,profilePictureURL);
        TextView paragraphe = (TextView) findViewById(R.id.testText);


        Button action1 = (Button) findViewById(R.id.buttonAction1);
        /*
        action1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent toWebWiew= new Intent(searchActivity.this,webViewExampleActivity.class);
                startActivity(toWebWiew);
            }
        });
        */

    }



}

