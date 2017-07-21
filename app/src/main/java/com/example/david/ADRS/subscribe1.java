package com.example.david.ADRS;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

//Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//set content view AFTER ABOVE sequence (to avoid crash)
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.usernameField);
        password = (EditText) findViewById(R.id.passwordField);
        Button loginButton = (Button) findViewById(R.id.button);
        Button subscribeButton = (Button) findViewById(R.id.subscribe);
        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    log_in();
                }
                return false;
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                log_in();

            }
        });
        subscribeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent toSubscribe= new Intent(LoginActivity.this,subscribe.class);
                toSubscribe.putExtra("username",username.getText().toString());
                toSubscribe.putExtra("password",password.getText().toString());
                startActivity(toSubscribe);
            }
        });
    }

    protected void log_in()
    {
        Intent toSearch= new Intent(LoginActivity.this,searchActivity.class);
        toSearch.putExtra("username",username.getText().toString());
        toSearch.putExtra("password",password.getText().toString());

        startActivity(toSearch);


    }
}
