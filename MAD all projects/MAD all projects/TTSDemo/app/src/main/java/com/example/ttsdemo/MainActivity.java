package com.example.ttsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
private TextToSpeech tts;
EditText et;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        et=findViewById(R.id.et);
        tts= new TextToSpeech(this,this);

        Locale locale=new Locale("en","us");
        tts.setLanguage(locale);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg=et.getText().toString();
                tts.speak(msg,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

    }

    @Override
    public void onInit(int i) {
        if(i==TextToSpeech.SUCCESS){
            Toast.makeText(getApplicationContext(),"Text to speech is Started",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"Text to speech failed",Toast.LENGTH_SHORT).show();
        }
    }
}