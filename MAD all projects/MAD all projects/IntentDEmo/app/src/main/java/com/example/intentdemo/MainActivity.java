package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText et1;
Button b1;
Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        b1=findViewById(R.id.b1);

        b1.setOnClickListener(view -> {
            String url="http://"+et1.getText().toString();
            i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
        });
    }
}