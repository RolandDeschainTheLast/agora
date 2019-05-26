package com.example.rina.agora_app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;


import com.example.rina.agora_app.R;

public class Home_activity extends AppCompatActivity {
    private CardView Exit;
    private CardView Settings;
    private CardView  Support, Birga,Browse;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Exit = (CardView)findViewById(R.id.exit);
        Settings=(CardView)findViewById(R.id.settings);
        Browse=(CardView)findViewById(R.id.browse);
        Support =(CardView) findViewById(R.id.support);
        Birga =(CardView) findViewById(R.id.birga);
        Bundle arguments = getIntent().getExtras();
        String name1 = arguments.get("hello").toString();
        String name2 = arguments.get("bye").toString();


        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Home_activity.this, MainActivity.class));

            }
        });
Browse.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Home_activity.this, BrowseActivity.class);
        intent.putExtra("hello1", String.valueOf(name1));
        intent.putExtra("hello2", String.valueOf(name2));
        startActivity(intent);
    }
});
        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_activity.this, SettingsActivity.class));
            }
        });





        Support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_activity.this, SupportActivity.class));
            }
        });

        Birga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_activity.this, VoteActivity.class);
                intent.putExtra("hello1", String.valueOf(name1));
                intent.putExtra("hello2", String.valueOf(name2));
                startActivity(intent);
            }
        });
    }




    @Override
    public void onBackPressed() {

    }
}
