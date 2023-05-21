package com.example.bluetoothapp;

import androidx.appcompat.app.AppCompatActivity;

//This one package is must for implementing bluetooth programs in your android app
import android.bluetooth.BluetoothAdapter;
//Write only this in exam

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Take 2 button objs and a Bluetooth adapter class's obj
    Button btn1,btn2;
    BluetoothAdapter ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Take reference from xml
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        ba = BluetoothAdapter.getDefaultAdapter();
    }


    // Make 2 methods on onclick of 2 buttons

    //write code in try catch block and try to catch A SecurityException

    // enable() and disable() are 2 methods of BluetoothAdapter class which will enable and disable the bluetooth


    //This method turns on the bluetooth
    public void turnon (View v){
       try {
           ba.enable();
            Toast.makeText(this, "Bluetooth Enabled", Toast.LENGTH_SHORT).show();
        }
        catch (SecurityException e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }



    //this method turns off the bluetooth
    public void turnoff (View v){
        try {
            ba.disable();
            Toast.makeText(this,"Bluetooth Disabled",Toast.LENGTH_SHORT).show();
        }
        catch (SecurityException e){
            Toast.makeText(this,e.toString(), Toast.LENGTH_SHORT).show();
        }
    }


}
