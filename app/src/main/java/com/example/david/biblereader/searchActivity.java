package com.example.david.biblereader;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by david on 15/07/17.
 */

public class searchActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ListView listView=(ListView) findViewById(R.id.listview);
    }
}
