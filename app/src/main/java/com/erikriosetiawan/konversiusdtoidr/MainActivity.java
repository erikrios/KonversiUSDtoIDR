package com.erikriosetiawan.konversiusdtoidr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.edit_text_username);
        editTextPassword = findViewById(R.id.edit_text_password);

        buttonLogin = findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isEmptyFields = false;
                if (TextUtils.isEmpty(editTextUsername.getText().toString().trim())) {
                    editTextUsername.setError("Username tidak boleh kosong");
                    isEmptyFields = true;
                }

                if (TextUtils.isEmpty(editTextPassword.getText().toString().trim())) {
                    editTextPassword.setError("Password tidak boleh kosong");
                    isEmptyFields = true;
                }


                if (!isEmptyFields) {
                    String username, password;
                    username = editTextUsername.getText().toString();
                    password = editTextPassword.getText().toString();

                    if (username.equals("admin") && (password.equals("admin"))) {
                        Intent intentMenu = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(intentMenu);
                        Toast.makeText(getApplicationContext(), "Login sukses", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Username atau password salah, coba kembali!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
