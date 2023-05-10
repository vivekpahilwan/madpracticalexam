package com.example.checkboxdemo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
CheckBox cb1,cb2,cb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb1=(CheckBox) findViewById(R.id.cb1);
        cb2=(CheckBox) findViewById(R.id.cb2);
        cb3=(CheckBox) findViewById(R.id.cb3);
        showStatus(cb1);
        showStatus(cb2);
        showStatus(cb3);
    }
    private void showStatus(CheckBox cb){
        String msg=cb.getText().toString();
        cb.setOnCheckedChangeListener((compoundButton, b) -> {
            if(b){
                String sb = msg + " Is Checked";
                Toast.makeText(getApplicationContext(), sb,Toast.LENGTH_LONG).show();
            }
        });
    }
}