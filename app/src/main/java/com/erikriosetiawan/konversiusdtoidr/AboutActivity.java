package com.erikriosetiawan.konversiusdtoidr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setTitle("About Me");

        textViewName = findViewById(R.id.text_view_name);

        receiveIntent();
    }

    private void receiveIntent() {
        Intent intentReceive = getIntent();
        String name = intentReceive.getStringExtra(MenuActivity.NAME_KEY);
        textViewName.setText(name);
    }
}
