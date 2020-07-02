package com.example.shrey.database_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper  extends SQLiteOpenHelper {
    public DatabaseHelper(Context context, String name) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sq1 = "CREATE TABLE stud (id INTEGER, name TEXT);";
        db.execSQL(sq1);
        ContentValues cv = new ContentValues();
        cv.put("id",10);
        cv.put("name","raju");
        ContentValues cv1 = new ContentValues();
        cv1.put("id",11);
        cv1.put("name","aptech");
        db.insert("stud",null,cv);
        db.insert("stud",null,cv1);



    }
    @Override
    public void onDowngrade(SQLiteDatabase db,int oldVer,int newVer)
    {

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

