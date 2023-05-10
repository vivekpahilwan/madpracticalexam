package com.example.imagebuttoncal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText et1,et2;
TextView tv1;
ImageButton ib1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        ib1=findViewById(R.id.ib1);
        tv1=findViewById(R.id.tv1);

        ib1.setOnClickListener(view -> {
            int a=Integer.parseInt(et1.getText().toString());
            int b=Integer.parseInt(et2.getText().toString());
            int c=a+b;
            tv1.setText("Addition Is: -"+ c);
        });
    }
}