package com.example.demologinformforasocialmediasite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
TextView tv3;
Button b1;
EditText  et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDetail();
    }
    private void showDetail(){
        tv3=(TextView) findViewById(R.id.tv3);
        b1=(Button) findViewById(R.id.b1);
        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user1=et1.getText().toString();
                String Pass1=et2.getText().toString();
                String user="User1";
                String Pass="1234";
                if(user1.equals(user)&&Pass1.equals(Pass)){
                    tv3.setText("Log In Successfully");
                }else {
                    tv3.setText("Please Enter Valid Detail!!");
                }
            }
        });
    }

}