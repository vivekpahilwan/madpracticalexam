package com.example.semsub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
AutoCompleteTextView t2;
String[] subject={"PWP","MAD","NIS","MGT","ETI"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t2=(AutoCompleteTextView) findViewById(R.id.t2);
        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,subject);
        t2.setAdapter(ad);
    }
}