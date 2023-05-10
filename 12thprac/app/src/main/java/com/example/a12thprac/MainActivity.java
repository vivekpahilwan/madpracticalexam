package com.example.a12thprac;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton genderradiobutton;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
    }

    public void pleasecheck(View v){
        int selectedid = radioGroup.getCheckedRadioButtonId();
        genderradiobutton = findViewById(selectedid);

        if (selectedid == -1 ) {
            Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, genderradiobutton.getText(), Toast.LENGTH_SHORT).show();
        }

    }

}