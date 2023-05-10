package com.example.listviewdemo;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
ListView gd;
    String[] mobArr={"Windows","Android","IPhone","windowsMobile","BlackBerry"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter ad=new ArrayAdapter<String>(this,R.layout.activity_listview,mobArr);
        gd=findViewById(R.id.gv1);
        gd.setAdapter(ad);

    }

}
