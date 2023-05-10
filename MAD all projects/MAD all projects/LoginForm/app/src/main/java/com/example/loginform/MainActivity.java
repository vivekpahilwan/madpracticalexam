package com.example.loginform;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tv3;
    Button b1,b2;
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

        b1.setOnClickListener(view ->{
            String user1=et1.getText().toString();
            String Pass1=et2.getText().toString();
            String user="User1";
            String Pass="1234";
            if(user1.equals(user)&&Pass1.equals(Pass)){
                String msg1="Log In Successfully";
                tv3.setText(msg1);
                setContentView(R.layout.activity_main1);
                goBack();
            }else {
                String msg2="Please Enter Valid Detail!!";
                tv3.setText(msg2);
            }
        });
    }
    private void goBack(){
        b2=(Button) findViewById(R.id.b2);
        b2.setOnClickListener(view -> {
            setContentView(R.layout.activity_main);
            showDetail();
        });
    }

}