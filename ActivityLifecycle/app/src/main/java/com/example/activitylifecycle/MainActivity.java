package com.example.activitylifecycle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public  void makethetoast(String str){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makethetoast("Oncreate");
    }

    protected void onStart(){
        super.onStart();
        makethetoast("OnStart");
    }

    protected void onResume(){
        super.onResume();
        makethetoast("OnResume");
    }

    protected void onRestart(){
        super.onRestart();
        makethetoast("onRestart");
    }

    protected void onPause(){
        super.onPause();
        makethetoast("OnPause");
    }

    protected void onDestroy(){
        super.onDestroy();
        makethetoast("OnDestroy");
    }

    protected void onStop(){
        super.onStop();
        makethetoast("OnStop");
    }

}
