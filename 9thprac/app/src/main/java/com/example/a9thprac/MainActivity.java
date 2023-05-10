package com.example.a9thprac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton togglebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //taking reference by findViewById
        togglebutton = (ToggleButton)findViewById(R.id.toggleButton);

    }

    //Below is the onClick method of toggle button
    public void blue(View view)
    {
        if (togglebutton.isChecked()) {
            Toast.makeText(this, "Bluetooth Turned on", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Bluetooth Turned off", Toast.LENGTH_SHORT).show();

        }
    }



}