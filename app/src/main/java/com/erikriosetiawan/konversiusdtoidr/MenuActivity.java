package com.erikriosetiawan.konversiusdtoidr;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button buttonConvert, buttonAbout, buttonLogOut;
    protected static final String NAME_KEY = "name";
    private int requestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().setTitle("Menu");

        buttonConvert = findViewById(R.id.button_convert);
        buttonAbout = findViewById(R.id.button_about);
        buttonLogOut = findViewById(R.id.button_logout);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentConvert = new Intent(getApplicationContext(), ConvertActivity.class);
                startActivity(intentConvert);
            }
        });

        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbout = new Intent(getApplicationContext(), AboutActivity.class);
                intentAbout.putExtra(NAME_KEY, getString(R.string.my_name));
                startActivityForResult(intentAbout, requestCode);
            }
        });

        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogOut = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentLogOut);
                finish();
            }
        });
    }
}
