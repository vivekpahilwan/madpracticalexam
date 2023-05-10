package com.example.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dp = findViewById(R.id.dp);
        tp = findViewById(R.id.tp);
        btn = findViewById(R.id.btn);

    }
    public void showdatetime(View v){
        int dd = dp.getDayOfMonth();
        int mm = dp.getMonth()+1;
        int yyyy = dp.getYear();

        int hr = tp.getHour();
        int min = tp.getMinute();

        Toast.makeText(this,"Date:"+dd+"/"+mm+"/"+yyyy+"Time:"+hr+"hrs"+min+"mins",Toast.LENGTH_SHORT).show();


    }
}