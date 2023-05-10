package com.example.keyurmp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    EditText et_name,et_roll;
    Spinner sp_department;
    Button savebtn;
    String departments[] = {"CM","CE","MK","ME","EC"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         et_name = findViewById(R.id.et_name);
         et_roll = findViewById(R.id.et_roll);
         savebtn = findViewById(R.id.savebtn);
        sp_department = findViewById(R.id.sp_department);

        ArrayAdapter <String> ad = new ArrayAdapter <String> (this, android.R.layout.simple_spinner_item, departments);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_department.setAdapter(ad);
    }

    public void oninfosave (View v){
        Toast.makeText(this, "Info Saved", Toast.LENGTH_SHORT).show();
    }
    
}