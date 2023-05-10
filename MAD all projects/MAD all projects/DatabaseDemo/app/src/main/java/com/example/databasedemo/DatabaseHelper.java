package com.example.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String db_n="dbDemo.db";
    private static final int db_v=1;
    public DatabaseHelper(Context context){
        super(context,db_n,null,db_v);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String cqt="CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, class TEXT, email TEXT, mob_no TEXT)";
        db.execSQL(cqt);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String dtq="DROP TABLE IF EXISTS users";
        db.execSQL(dtq);
        onCreate(db);
    }



}
