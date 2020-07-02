package com.example.shrey.example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context,"Student_db.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sq1 = "CREATE TABLE Student (Name TEXT,ID TEXT,Address TEXT,Contact TEXT,Fees TEXT,Course TEXT)";
        db.execSQL(sq1);
        String sq2 = "CREATE TABLE Courses (Name TEXT,ID INTEGER,Duration TEXT,Fees TEXT)";
        db.execSQL(sq2);
        ContentValues cv1 = new ContentValues();
        cv1.put("Name","PHP");
        cv1.put("ID",100);
        cv1.put("Duration","2 months");
        cv1.put("Fees","20000");
        ContentValues cv2 = new ContentValues();
        cv2.put("Name",".NET");
        cv2.put("ID",101);
        cv2.put("Duration","1.5 months");
        cv2.put("Fees","17500");
        ContentValues cv3 = new ContentValues();
        cv3.put("Name","Java");
        cv3.put("ID",102);
        cv3.put("Duration","1 month");
        cv3.put("Fees","18000");
        db.insert("Courses",null,cv1);
        db.insert("Courses",null,cv2);
        db.insert("Courses",null,cv3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "message" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(SQLException sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        } catch(Exception ex){
            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }
    }
}

