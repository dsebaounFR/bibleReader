package com.example.david.biblereader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.usernameField);
        password = (EditText) findViewById(R.id.passwordField);
        Button loginButton = (Button) findViewById(R.id.button);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent toSearch= new Intent(LoginActivity.this,searchActivity.class);
                toSearch.putExtra("username",username.getText().toString());
                toSearch.putExtra("password",password.getText().toString());
                startActivity(toSearch);
            }
        });

    }
}
