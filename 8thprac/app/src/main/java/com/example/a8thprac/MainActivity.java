package com.example.a8thprac;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    String[] subnames={"MAD","PWP","EDE","MGT","ETI","NIS"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,subnames);
        AutoCompleteTextView textView=(AutoCompleteTextView)findViewById(R.id.actv);
        textView.setThreshold(1);
        textView.setAdapter(adapter);
    }
}