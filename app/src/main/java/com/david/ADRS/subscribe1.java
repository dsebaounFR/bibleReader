package com.example.david.ADRS;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class subscribe1 extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.subscribe1);
        username = (EditText) findViewById(R.id.usernameFieldRegistration);
        password = (EditText) findViewById(R.id.passwordFieldRegistration);
        Button next = (Button) findViewById(R.id.next);
        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    toSubscribe2();
                }
                return false;
            }
        });
        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                toSubscribe2();

            }
        });

    }

    protected void toSubscribe2()
    {
        Intent intent= new Intent(subscribe1.this,subscribe2.class);
        intent.putExtra("username",username.getText().toString());
        intent.putExtra("password",password.getText().toString());

        startActivity(intent);


    }
}
