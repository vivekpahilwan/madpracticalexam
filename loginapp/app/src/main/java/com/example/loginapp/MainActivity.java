package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    Button btn;
    TextView tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.username);
        et2 = findViewById(R.id.password);
        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv);
    }
    public void validate(View v){

        if (et1.getText().toString().equals("admin") && et2.getText().toString().equals("admin")){
            Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"fail",Toast.LENGTH_SHORT).show();
        }
    }
}