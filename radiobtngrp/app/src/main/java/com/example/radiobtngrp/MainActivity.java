package com.example.radiobtngrp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.rg);
        btn = findViewById(R.id.btn);
    }

    public void validate (View view){
        int selectedid = rg.getCheckedRadioButtonId();
        rb = findViewById(selectedid);
        Toast.makeText(this,rb.getText().toString(),Toast.LENGTH_SHORT).show();
    }

}