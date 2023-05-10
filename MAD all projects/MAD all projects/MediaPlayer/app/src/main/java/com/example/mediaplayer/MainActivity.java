package com.example.mediaplayer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    SeekBar sb1;
    MediaPlayer mediaPlayer= new MediaPlayer();
    Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
    Handler h1=new Handler();
    Uri selectedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        sb1=findViewById(R.id.sb1);
        b1.setOnClickListener(view -> {
            intent.setType("audio/*");
            startActivityForResult(Intent.createChooser(intent,"Select Music File"),1);
            b1.setVisibility(View.INVISIBLE);
        });
        b2.setOnClickListener(view -> {
            mediaPlayer.start();
            sb1.setMax(mediaPlayer.getDuration());
        });
        b3.setOnClickListener(view -> {
            mediaPlayer.reset();
            try {
                mediaPlayer.setDataSource(getApplicationContext(),selectedData);
                mediaPlayer.prepare();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        b4.setOnClickListener(view -> mediaPlayer.pause());

        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer != null){
                    int progress=mediaPlayer.getCurrentPosition();
                    sb1.setProgress(progress);
                }
                h1.postDelayed(this,1000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1 && resultCode == RESULT_OK){
            selectedData=data.getData();
            try{
                mediaPlayer.setDataSource(getApplicationContext(),selectedData);
                mediaPlayer.prepare();
            }catch (IOException e){
                    e.printStackTrace();
            }
        }
    }
}