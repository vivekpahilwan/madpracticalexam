package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1 , cb2, cb3,cb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
    }

    public void validate(View v){
        String msg ="";
        if(cb1.isChecked()){
            msg = msg + "apple";
        }
        if(cb2.isChecked()){
            msg = msg + "Samsung";
        }
        if(cb3.isChecked()){
            msg = msg + "dell";
        }
        if(cb4.isChecked()){
            msg = msg + "lenovo";
        }
        Toast.makeText(this, msg + "are selected", Toast.LENGTH_LONG).show();
    }
}