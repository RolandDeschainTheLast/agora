package com.example.rina.agora_app.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rina.agora_app.R;

public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        Bundle arguments = getIntent().getExtras();
        String name1 = arguments.get("hello1").toString();

    }
}
