package com.example.buttondemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText et1,et2;
Button b1;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    public void addListenerOnButton()
    {
        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        b1=(Button) findViewById(R.id.b1);
        tv=(TextView) findViewById(R.id.tv);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String v1=et1.getText().toString();
                String v2=et2.getText().toString();
                int a=Integer.parseInt(v1);
                int b=Integer.parseInt(v2);
                int sum=a+b;
                tv.setText("Result : "+sum);
            }
        });
    }
}