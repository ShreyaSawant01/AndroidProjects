package com.example.shrey.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class DatabaseHelper extends SQLiteOpenHelper{

    public DatabaseHelper(Context context,String name) {
        super(context,name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sq1 = "CREATE TABLE Student (Name TEXT,ID INTEGER,Address TEXT,Contact NUMERICAL,Fees NUMERICAL)";
        db.execSQL(sq1);
        String sq2 = "CREATE TABLE Courses (Name TEXT,ID INTEGER,Duration TEXT,Fees NUMERICAL)";
        db.execSQL(sq2);
        ContentValues cv1 = new ContentValues();
        cv1.put("Name","PHP");
        cv1.put("ID",100);
        cv1.put("Duration","2 months");
        cv1.put("Fees",20000);
        ContentValues cv2 = new ContentValues();
        cv2.put("Name",".NET");
        cv2.put("ID",101);
        cv2.put("Duration","1.5 months");
        cv2.put("Fees",17500);
        ContentValues cv3 = new ContentValues();
        cv3.put("Name","Java");
        cv3.put("ID",102);
        cv3.put("Duration","1 month");
        cv3.put("Fees",18000);
        db.insert("Courses",null,cv1);
        db.insert("Courses",null,cv2);
        db.insert("Courses",null,cv3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
