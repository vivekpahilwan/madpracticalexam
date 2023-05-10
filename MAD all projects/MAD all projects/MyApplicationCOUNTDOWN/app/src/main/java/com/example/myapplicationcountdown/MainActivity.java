package com.example.myapplicationcountdown;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView countdownTimer;
    private Button startButton;
    EditText et1;
    private CountDownTimer timer;
    private final long startTime = 60 * 1000; // 1 minute in milliseconds
    private final long interval = 1000; // 1 second in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdownTimer = findViewById(R.id.countdownTimer);
        startButton = findViewById(R.id.startButton);
        et1=(EditText) findViewById(R.id.et1);
        int time=Integer.parseInt(et1.toString());
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer = new CountDownTimer(startTime, interval) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        long secondsLeft = time / 1000;
                        countdownTimer.setText(String.format("%02d:%02d", secondsLeft / 60, secondsLeft % 60));
                    }

                    @Override
                    public void onFinish() {
                        countdownTimer.setText("00:00");
                    }
                }.start();
            }
       });
    }
}