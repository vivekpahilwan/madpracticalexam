package com.example.personalinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {
    TextView t1,t3,t5,t7;
    EditText t2,t4,t6;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView) findViewById(R.id.t1);
        t3=(TextView) findViewById(R.id.t3);
        t5=(TextView) findViewById(R.id.t5);
        t7=(TextView) findViewById(R.id.t7);

        t2=(EditText) findViewById(R.id.t2);
        t4=(EditText) findViewById(R.id.t4);
        t6=(EditText) findViewById(R.id.t6);
        b1=(Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}