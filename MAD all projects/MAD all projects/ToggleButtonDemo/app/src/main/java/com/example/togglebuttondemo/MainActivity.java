package com.example.togglebuttondemo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b1;
    ToggleButton tb1;
    TextView tv2;
String result1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            buttonClick();
    }
    private void buttonClick(){
        b1=(Button) findViewById(R.id.b1);
        tb1=(ToggleButton) findViewById(R.id.tb1);
        tv2=(TextView) findViewById(R.id.tv2);
        b1.setOnClickListener(view -> {
            result1="Bluetooth is: - "+tb1.getText().toString();
            StringBuilder result=new StringBuilder();
            result.append("Bluetooth is : ").append(tb1.getText());
            Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_LONG).show();
            tv2.setText(result1);
        });
    }
}