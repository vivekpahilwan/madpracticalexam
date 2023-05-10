package com.example.a11thprac;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.CheckBox;
//import android.widget.Toast;
import  android.widget.*;
public class MainActivity extends AppCompatActivity {

    CheckBox cb1,cb2,cb3,cb4,cb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1=findViewById(R.id.cb1);
        cb2=findViewById(R.id.cb2);
        cb3=findViewById(R.id.cb3);
        cb4=findViewById(R.id.cb4);
        cb5=findViewById(R.id.cb5);
    }

    public void pleasecheck(View v){
        String msg="";

        if(cb1.isChecked())
            msg = msg + " Painting ";
        if(cb2.isChecked())
            msg = msg + " Reading ";
        if(cb3.isChecked())
            msg = msg + " Singing ";
        if(cb4.isChecked())
            msg = msg + " Cooking ";
        if(cb5.isChecked())
            msg = msg + " Cooking ";

        Toast.makeText(this, msg + "are selected", Toast.LENGTH_SHORT).show();
    }
}