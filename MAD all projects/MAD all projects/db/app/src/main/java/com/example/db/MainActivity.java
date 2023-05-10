package com.example.db;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText et1,et2,et3;

    public MainActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context=getApplicationContext();
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);

        b1.setOnClickListener(view -> {
            String name=et1.getText().toString();
            String email=et2.getText().toString();
            int id=Integer.parseInt(et3.getText().toString());
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("_id",id);
            values.put("email", email);

            db.insert("users", null, values);
        });

        b2.setOnClickListener(view -> {
            Cursor cursor = db.query("users", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                long id = cursor.getLong(cursor.getColumnIndex("_id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String email = cursor.getString(cursor.getColumnIndex("email"));
                Log.d(TAG, "id: " + id + ", name: " + name + ", email: " + email);
                String msg="id: " + id + ", name: " + name + ", email: " + email;
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
            cursor.close();
        });


    }
}