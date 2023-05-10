package com.example.prac8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView obj;
    String [] citynames = {"Yeola","Pune","Nashik","Mumbai","Yeola2","Nashik2","Mumbai2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        obj = findViewById(R.id.actv);
        ArrayAdapter  ad = new ArrayAdapter (this, android.R.layout.simple_dropdown_item_1line,citynames);
        obj.setThreshold(1);
        obj.setAdapter(ad);

    }
}