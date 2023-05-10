package com.example.imagetogglebtn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton tb;
    Button btn;
    ImageButton ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb = findViewById(R.id.togglebtn);
        btn = findViewById(R.id.btn);
        ib = findViewById(R.id.imgbtn);
    }
    public void btnmethod(View v){
        Toast.makeText(this,"Btn method called",Toast.LENGTH_SHORT).show();
    }
    public void imgbtnmethod(View v){
        Toast.makeText(this,"Image btn method Called",Toast.LENGTH_SHORT).show();
    }
    public void togglemethod(View v){
        String txt = tb.getText().toString();
        Toast.makeText(this,txt,Toast.LENGTH_SHORT).show();
    }
}