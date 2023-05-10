package com.example.a7thprac;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ApplicationExitInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

   public EditText name;
    public  EditText age;
    public EditText phn ;
    public Button btn ;
    public TextView info_name;
    public TextView info_age;
    public TextView info_phn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.name);
        EditText age = findViewById(R.id.age);
        EditText phn = findViewById(R.id.phn);
        Button btn = findViewById(R.id.btn);
        TextView info_name = findViewById(R.id.info_name);
        TextView info_age = findViewById(R.id.info_age);
        TextView info_phn = findViewById(R.id.info_phn);

    }

    public void seedetails (View view){
        info_name.setText(name.getText());
        info_age.setText(age.getText());
        info_phn.setText(phn.getText());
    }




}