package com.example.progressbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    Button btnshow,btnhide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = findViewById(R.id.pb);
        btnshow = findViewById(R.id.btnshow);
        btnhide = findViewById(R.id.btnhide);
    }

    public void show(View v){
        pb.setVisibility(View.VISIBLE);
    }
    public void hide(View v){
        pb.setVisibility(View.GONE);
    }
}