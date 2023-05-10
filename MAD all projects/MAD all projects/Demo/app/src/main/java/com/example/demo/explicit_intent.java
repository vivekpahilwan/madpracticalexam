package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class explicit_intent extends AppCompatActivity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fact);
        MainActivity m=new MainActivity();

        Intent i=getIntent();
        int f=i.getIntExtra("number",0);
        tv1=findViewById(R.id.tv1);
        long fact=factorial(f);
        String fa=""+f;
        Toast.makeText(getApplicationContext(),fa,Toast.LENGTH_SHORT).show();
        tv1.setText("factorial: -"+fact);
    }
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
}
