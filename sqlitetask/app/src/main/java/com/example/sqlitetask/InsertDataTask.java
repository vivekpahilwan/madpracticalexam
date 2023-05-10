package com.example.sqlitetask;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.Toast;

public class InsertDataTask extends AsyncTask<String, Void, Boolean> {

    private Context context;
    private SQLiteDatabase database;
    private String name;
    private String email;

    public InsertDataTask(Context context) {
        this.context = context;
        database = new DatabaseHelper(context).getWritableDatabase();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        name = params[0];
        email = params[1];

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, name);
        values.put(DatabaseHelper.COLUMN_EMAIL, email);

        long result = database.insert(DatabaseHelper.TABLE_NAME, null, values);
        return result != -1;
    }

    @Override
    protected void onPostExecute(Boolean success) {
        super.onPostExecute(success);

        if (success) {
            Toast.makeText(context, "Data inserted successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Data insertion failed", Toast.LENGTH_SHORT).show();
        }
    }
}
