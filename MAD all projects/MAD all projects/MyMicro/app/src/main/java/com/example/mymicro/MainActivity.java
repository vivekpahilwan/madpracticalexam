package com.example.mymicro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Dice dice;
    private TextView resultTextView;
    private ImageView diceImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice = new Dice(6);
        resultTextView = findViewById(R.id.result_text_view);
        diceImageView = findViewById(R.id.dice_image_view);

        diceImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = dice.roll();
                resultTextView.setText("Result: " + result);
                int drawableId = getResources().getIdentifier("dice_" + result, "drawable", getPackageName());
                diceImageView.setImageResource(drawableId);
            }
        });
    }
}
