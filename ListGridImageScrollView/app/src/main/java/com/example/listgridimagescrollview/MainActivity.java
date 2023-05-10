package com.example.listgridimagescrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String items [] = {"Vivek 1","Vivek 2","Vivek 3","Vivek 4","Vivek 5","Vivek 6","Vivek 7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        ArrayAdapter ad = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,items);
        lv.setAdapter(ad);


    }
}