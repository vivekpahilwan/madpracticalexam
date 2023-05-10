package com.example.openwebsiteimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText search_bar;
    Button btn;
    Intent obj = new Intent(Intent.ACTION_VIEW);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_bar = findViewById(R.id.search_bar);
        btn = findViewById(R.id.btn);


        obj.setData(Uri.parse("www.google.com"));
    }

    public void openweb(View v){
        startActivity(obj);
    }
}