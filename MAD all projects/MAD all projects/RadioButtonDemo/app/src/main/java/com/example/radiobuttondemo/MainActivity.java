package com.example.radiobuttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RadioButton rb1,rb2;
RadioGroup rg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg1=(RadioGroup) findViewById(R.id.rg1);
        rb1=(RadioButton) findViewById(R.id.rb1);
        rb2=(RadioButton) findViewById(R.id.rb2);
        showStatus(rb1);
        showStatus(rb2);
        showState(rg1);
    }
    private void showStatus(RadioButton rb){
        rb.setOnCheckedChangeListener((compoundButton, b) -> {
            String msg=rb.getText().toString()+" Is Checked";
            if(b){
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
        });
    }
    private void showState(RadioGroup rg){
        rg.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton rb=findViewById(i);
            String msg=rb.getText().toString()+"Is Selected";
            Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
        });
    }
}