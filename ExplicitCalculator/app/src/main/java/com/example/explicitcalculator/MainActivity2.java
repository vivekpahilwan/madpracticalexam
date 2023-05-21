package com.example.explicitcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends MainActivity {

    TextView ans;
    int a = Integer.parseInt(one);
    int b = Integer.parseInt(two);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ans = findViewById(R.id.ans);
    }
    public void add(View v){
        ans.setText(a+b);
    }
    public void sub(View v){
        ans.setText(a-b);
    }
    public void mul(View v){
        ans.setText(a*b);
    }
    public void div(View v){
        ans.setText(a/b);
    }
}