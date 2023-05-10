package com.example.imageviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView iv1;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1=(ImageView) findViewById(R.id.iv1);
        b1=(Button) findViewById(R.id.b1);
        b1.setOnClickListener(view ->{
            iv1.setImageResource(R.drawable.img);
        });
    }
}