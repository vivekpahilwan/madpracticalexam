package com.example.simpcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText et1,et2;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        b1=(Button) findViewById(R.id.b1);
        b1.setOnClickListener(view -> {
            int a=Integer.parseInt(et1.getText().toString());
            int b=Integer.parseInt(et2.getText().toString());
            int sum=a+b;
            String msg="Addition is : - "+sum;
            Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
        });
    }
    private void add1(int a,int b){
        int sum=a+b;
        String msg="Addition is : - "+sum;
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

}