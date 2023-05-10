package com.example.studentregistrationform;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText  et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        b1=(Button) findViewById(R.id.b1);
        b1.setOnClickListener(view -> {
            String user=et1.getText().toString();
            String pass=et2.getText().toString();
            if(user.equals("User1")&&pass.equals("1234")){
                Toast.makeText(getApplicationContext(),"Log In Successfully",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getApplicationContext(),"Please Enter Valid Detail",Toast.LENGTH_LONG).show();
            }
        });
    }
}