package com.example.broadcast_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView=findViewById(R.id.imageView);
        Intent intent=getIntent();
        String action=intent.getAction();
        String type=intent.getType();
        if(Intent.ACTION_SEND.equals(action) && type!=null)
        {
            imageView.setImageURI(intent.getParcelableExtra(Intent.EXTRA_STREAM));
        }
    }
}