package com.erikriosetiawan.konversiusdtoidr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConvertActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextInputUsd;
    TextView textViewResultIdr;
    Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        getSupportActionBar().setTitle("Convert USD to IDR");

        editTextInputUsd = findViewById(R.id.edit_text_input_usd);
        textViewResultIdr = findViewById(R.id.text_view_result_idr);
        buttonCalculate = findViewById(R.id.button_calculate);

        buttonCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonCalculate) {
            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(editTextInputUsd.getText().toString().trim())) {
                editTextInputUsd.setError("Field ini tidak boleh kosong");
                isEmptyFields = true;
            }

            if (!isEmptyFields) {
                Double usd = toDouble(editTextInputUsd.getText().toString().trim());
                ConvertUsdToIdr convertUsdToIdr = new ConvertUsdToIdr();
                convertUsdToIdr.setUsd(usd);
                textViewResultIdr.setText(Double.toString(convertUsdToIdr.result()));
            }

        }
    }

    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
