package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button b1;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        b1 = findViewById(R.id.b1);

        b1.setOnClickListener(view -> {
            int fact = Integer.parseInt(et1.getText().toString());
            a=fact;
            Intent i=new Intent(MainActivity.this,explicit_intent.class);
            i.putExtra("number",fact);
            startActivity(i);
        });
    }
}