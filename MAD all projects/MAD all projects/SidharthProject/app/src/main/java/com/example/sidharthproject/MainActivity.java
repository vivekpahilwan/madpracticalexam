package com.example.sidharthproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int randomNumber;

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Generate a random number between 1 and 100
        randomNumber = (int) (Math.random() * 100) + 1;

        // Initialize the UI elements
        EditText etGuess = findViewById(R.id.et_guess);
        tvResult = findViewById(R.id.tv_result);
        Button btnSubmit = findViewById(R.id.btn_submit);

        // Add a click listener to the submit button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the user's guess from the EditText
                String guessString = etGuess.getText().toString().trim();

                // Check if the user's guess is empty
                if (guessString.isEmpty()) {
                    tvResult.setText("Please enter a number");
                } else {
                    // Convert the user's guess to an integer
                    int guess = Integer.parseInt(guessString);

                    // Compare the user's guess to the random number
                    if (guess < randomNumber) {
                        tvResult.setText("Too low, try again");
                    } else if (guess > randomNumber) {
                        tvResult.setText("Too high, try again");
                    } else {
                        tvResult.setText("Congratulations! You guessed the number");
                    }
                }
            }
        });
    }
}