package com.example.searchengine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView t1;
    String[] Fruits={"Apple","Banna","Orange","Mango","Clipart"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,Fruits);
        t1=(AutoCompleteTextView) findViewById(R.id.t1);
        t1.setAdapter(ad);
    }
}