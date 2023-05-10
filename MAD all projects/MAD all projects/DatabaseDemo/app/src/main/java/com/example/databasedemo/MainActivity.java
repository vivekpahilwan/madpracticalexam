package com.example.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db_helper;
    Context context;
    EditText et1, et2, et3, et4;
    Button b1, b2, b3;
    ListView lv1;
    int lastId;
    StringBuilder sb;
    String[] list_data = {};
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        context = getApplicationContext();
        db_helper = new DatabaseHelper(context);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        lv1 = findViewById(R.id.lv1);
        db = db_helper.getWritableDatabase();

        lv1.setClickable(false);
        b1.setOnClickListener(view -> {
            if(et1.getText().toString().isEmpty() | et2.getText().toString().isEmpty() |et3.getText().toString().isEmpty() | et4.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Please Filled All Detail",Toast.LENGTH_SHORT).show();
            }else {
                ContentValues cv = new ContentValues();
                String name = et1.getText().toString();
                String class_ = et2.getText().toString();
                String email = et3.getText().toString();
                String mob_no = et4.getText().toString();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                cv.put("name", name);
                cv.put("class", class_);
                cv.put("email", email);
                cv.put("mob_no", mob_no);
                db.insert("users", null, cv);
                Toast.makeText(getApplicationContext(),"Detail Saved",Toast.LENGTH_SHORT).show();
            }

        });

        b2.setOnClickListener(view -> {
            String[] col = {"id", "name", "class", "email", "mob_no"};
            String table_name = "users";

            Cursor c = db.query(table_name, col, null, null, null, null, null);
            c.move(1);
            String query = "SELECT MAX(id) FROM users";
            Cursor cursor = db.rawQuery(query, null);
            if (cursor != null && cursor.moveToFirst()) {
                lastId = cursor.getInt(0);
                cursor.close();
            }

            sb = new StringBuilder();
            int end = lastId;
            for (int i = 0; i < end; i++) {
                c.moveToPosition(i);
                int id = c.getInt(c.getColumnIndex("id"));
                String name = c.getString(c.getColumnIndex("name"));
                String class_ = c.getString(c.getColumnIndex("class"));
                String email = c.getString(c.getColumnIndex("email"));
                String mob_no = c.getString(c.getColumnIndex("mob_no"));

                String msg = "Detail No.: - " + id + "\n" + "Name: - " + name + "\n" + "Class: - " + class_ + "\n" + "Email: - " + email + "\n" + "Mobile Number: - " + mob_no;
                sb.append(msg).append("`");

            }
            list_data = sb.toString().split("`");
            ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list_data);
            lv1.setAdapter(ad);
            c.close();
            Toast.makeText(getApplicationContext(),"Detail Updated",Toast.LENGTH_SHORT).show();
        });

        b3.setOnClickListener(view -> {
            db_helper.onUpgrade(db,1,1);
            Toast.makeText(getApplicationContext(),"Detail Deleted",Toast.LENGTH_SHORT).show();
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}