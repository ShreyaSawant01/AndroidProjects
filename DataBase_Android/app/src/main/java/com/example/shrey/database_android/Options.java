package com.example.shrey.database_android;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.N;

public class Options extends AppCompatActivity {

    private EditText t1;
    private EditText t2;
    Button b1;
    Intent i;
    private Button b2;
    private Button b3;
    private SQLiteDatabase db;
    private Button p;
    private Button n;
    private Cursor rs;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        t1 = (EditText)findViewById(R.id.editText2);
        t2 = (EditText)findViewById(R.id.editText3);
        DatabaseHelper h = new DatabaseHelper(this,"ShreyaDb");
        db = h.getWritableDatabase();
        rs = db.rawQuery("SELECT id,name FROM stud",null);

        p = (Button)findViewById(R.id.button3);
        n = (Button)findViewById(R.id.button4);

        p.setOnClickListener(new P());
        n.setOnClickListener(new N());

        b1 = (Button)findViewById(R.id.button2);
        b2 = (Button)findViewById(R.id.button5);
        b3 = (Button)findViewById(R.id.button6);

        b1.setOnClickListener(new I());//insert
        b3.setOnClickListener(new D());//delete
        b2.setOnClickListener(new U());//update



    }

    class D implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            rs = db.rawQuery("SELECT id,name FROM stud",null);
            String s1 = t1.getText().toString();
            db.delete("stud","id = "+s1,null);
            Toast.makeText(getApplicationContext(),"id :"+s1+" deleted",Toast.LENGTH_LONG).show();

        }
    }
    class I implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String s1 = t1.getText().toString();
            String s2 = t2.getText().toString();

            ContentValues cv = new ContentValues();
            cv.put("id",Integer.parseInt(s1));
            cv.put("name",s2);

            db.insert("stud",null,cv);
            rs = db.rawQuery("SELECT id,name FROM stud",null);
            System.out.println("version "+ db.getVersion());
            Toast.makeText(getApplicationContext(),"id :"+s1+" name :"+s2+" inserted",Toast.LENGTH_LONG).show();

        }
    }
    class P implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            rs = db.rawQuery("SELECT id,name FROM stud",null);
            if(rs.moveToPrevious())
            {
                t1.setText(rs.getString(0));
                t2.setText(rs.getString(1));

            }
        }
    }
    class N implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(rs.moveToNext())
            {
                t1.setText(rs.getString(0));
                t2.setText(rs.getString(1) );
            }

        }
    }

     class U implements View.OnClickListener {
         @Override
         public void onClick(View v) {
             String s1 = t1.getText().toString();
             String s2 = t2.getText().toString();

             ContentValues cv = new ContentValues();
             cv.put("id",Integer.parseInt(s1));
             cv.put("name",s2);
             db.update("stud",cv,"id="+s1,null);
             rs = db.rawQuery("SELECT id,name FROM stud",null);
             System.out.println("version "+ db.getVersion());
             Toast.makeText(getApplicationContext(),"name: "+s1+" and id: "+s2+" updated",Toast.LENGTH_LONG).show();


         }
     }
}
