package com.example.ajinkyaproject;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button select=findViewById(R.id.b1);
        select.setOnClickListener(view -> {
            Intent intent=new Intent(Intent.ACTION_PICK);
            intent.setType("video/*");
            startActivityForResult(intent,1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && data!= null){
            Uri selected_video=data.getData();
            MediaController mc= new MediaController(MainActivity.this);
            VideoView vv1=findViewById(R.id.vv1);
            vv1.setMediaController(mc);
            vv1.setVideoURI(selected_video);
            vv1.start();
        }
    }
}