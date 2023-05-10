package com.example.prac28;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout usernameLayout,passwordLayout;
    private TextInputEditText usernameEditText,passwordEditText;
    private Button loginButton;

    private int attemptCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameLayout = findViewById(R.id.username_layout);
        passwordLayout = findViewById(R.id.password_layout);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                return;
            }

            if (username.length() < 6 || password.length() < 6) {
                Toast.makeText(MainActivity.this, "Username and password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!username.equals("admin") || !password.equals("password123")) {
                attemptCount++;

                if (attemptCount >= 3) {
                    loginButton.setEnabled(false);
                    Toast.makeText(MainActivity.this, "Too many unsuccessful login attempts. Please try again later.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid username or password. Please try again.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                attemptCount = 0;
            }
        });
    }
}
