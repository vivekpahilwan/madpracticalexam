package com.example.musicplayer;

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
    MediaPlayer mediaPlayer;
    SeekBar seekBar;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize views
        seekBar = findViewById(R.id.seek_bar);

        // create media player and set data source
        MediaPlayer mediaPlayer = new MediaPlayer();
        Button select=findViewById(R.id.select);
        select.setOnClickListener(view -> {
            Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("audio/*");
            startActivityForResult(Intent.createChooser(intent, "Select Audio File"),1);

        });

        // set up listener for playback state changes
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                // start playback
                mediaPlayer.start();
            }
        });

        // set up handler to update seek bar progress
        handler = new Handler();
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    int progress = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress(progress);
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Get the selected data
            Uri selectedData = data.getData();

            try {
                // Set the data source for the MediaPlayer object
                mediaPlayer.setDataSource(getApplicationContext(), selectedData);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void play(View view) {
        mediaPlayer.start();
    }

    public void pause(View view) {
        mediaPlayer.pause();
    }

    public void next(View view) {
        // load next song and start playback
    }

    public void previous(View view) {
        // load previous song and start playback
    }
}
