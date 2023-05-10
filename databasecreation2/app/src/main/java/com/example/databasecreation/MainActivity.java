package com.example.databasecreation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName, editTextAge;
    private Button buttonAdd;
    private ListView listViewUsers;

    private SQLiteOpenHelper dbHelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        buttonAdd = findViewById(R.id.buttonAdd);
        listViewUsers = findViewById(R.id.listViewUsers);

        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getWritableDatabase();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String ageString = editTextAge.getText().toString().trim();

                if (name.isEmpty() || ageString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter name and age", Toast.LENGTH_SHORT).show();
                } else {
                    int age = Integer.parseInt(ageString);

                    ContentValues values = new ContentValues();
                    values.put("name", name);
                    values.put("age", age);

                    long newRowId = database.insert("users", null, values);

                    if (newRowId != -1) {
                        Toast.makeText(MainActivity.this, "User added to database", Toast.LENGTH_SHORT).show();
                        loadUserList();
                        editTextName.setText("");
                        editTextAge.setText("");
                    } else {
                        Toast.makeText(MainActivity.this, "Error adding user to database", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        listViewUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) listViewUsers.getItemAtPosition(position);
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                int age = cursor.getInt(cursor.getColumnIndexOrThrow("age"));

                Toast.makeText(MainActivity.this, "Name: " + name + ", Age: " + age, Toast.LENGTH_SHORT).show();
            }
        });

        loadUserList();
    }

    private void loadUserList() {
        Cursor cursor = database.rawQuery("SELECT * FROM users", null);

        String[] fromColumns = {"name", "age"};
        int[] toViews = {android.R.id.text1, android.R.id.text2};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,
                cursor,
                fromColumns,
                toViews,
                0);

        listViewUsers.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }
}

class DatabaseHelper extends SQLiteOpenHelper {

}

