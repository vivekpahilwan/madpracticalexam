package com.example.sixthsemfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2,et_res;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         et1 = findViewById(R.id.et_1);
         et2 = findViewById(R.id.et_2);
         et_res = findViewById(R.id.et_res);


    }

    public void addition(View v){
        int num1 = Integer.parseInt(et1.getText().toString());
        int num2 = Integer.parseInt(et2.getText().toString());
        int res = num1 + num2 ;
        et_res.setText("Answer is : "+res);
    }

    public void substraction(View v){
        int num1 = Integer.parseInt(et1.getText().toString());
        int num2 = Integer.parseInt(et2.getText().toString());
        int res = num1 - num2 ;
        et_res.setText("Answer is : "+res);
    }

    public void multiplication(View v){
        int num1 = Integer.parseInt(et1.getText().toString());
        int num2 = Integer.parseInt(et2.getText().toString());
        int res = num1 * num2 ;
        et_res.setText("Answer is : "+res);
    }

    public void divsion(View v){
        int num2 = Integer.parseInt(et2.getText().toString());
        int num1 = Integer.parseInt(et1.getText().toString());
        int res = num1 / num2 ;
        et_res.setText("Answer is : "+res);
    }
}