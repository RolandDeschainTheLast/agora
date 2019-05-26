package com.example.rina.agora_app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.rina.agora_app.R;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonUpdate;
    private TextView buttonReturn;
    private EditText editTextName, editTextEmail, editTextPassword;
    private RadioGroup radioGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonReturn =(TextView) findViewById(R.id.Return);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        radioGender = (RadioGroup) findViewById(R.id.radioGender);









        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this, Home_activity.class));
            }
        });

    }









    @Override
    public void onBackPressed() {

    }

    @Override
    public void onClick(View view) {

    }
}
