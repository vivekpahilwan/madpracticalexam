package com.example.listvieweg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Step 1
    // Make a String array with item names
    String allitems[] = {"Keyur","Krish","Prajwal","Vivek","Krish","Prajwal","Vivek","Krish","Prajwal","Vivek","Krish","Prajwal","Vivek","Prajwal","Vivek","Prajwal","Vivek","Prajwal","Vivek","Prajwal","Vivek","Prajwal","Vivek","Prajwal","Vivek","Prajwal","Vivek","Prajwal","Vivek","Prajwal","Vivek","Prajwal","Vivek","Prajwal","Vivek","Prajwal","Vivek","Prajwal","Vivek"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 2
        //Take the view reference from xml file
        ListView listView1 = findViewById(R.id.listview1);

        //Step 3
        //Create array adapter of string
        ArrayAdapter <String> arr = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,allitems);
        listView1.setAdapter(arr);

    }
}