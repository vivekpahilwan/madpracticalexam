package com.example.practicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
String data="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(Button b){
        String msg=b.getText().toString();
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
        data+=msg;
    }

    public void onSubmitClick(Button b){
        TextView tv1=findViewById(R.id.tv1);
        tv1.setText(data);
    }

    public void onClearClick(Button b){
        TextView tv1=findViewById(R.id.tv1);
        tv1.setText("");
    }
}