package com.example.shrey.database_android;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText tv = (EditText) findViewById(R.id.editText);
        DatabaseHelper h = new DatabaseHelper(this, "ShreyaDb");
        SQLiteDatabase db = h.getWritableDatabase();
        System.out.println("version " + db.getVersion());
        Cursor rs = db.rawQuery("SELECT id,name FROM stud", null);
        //Cursor rs = db.rawQuery("SELECT sid,name FROM myTable",new String[] {"David","2});
        while (rs.moveToNext()) {
            tv.append(rs.getString(0) + " " + rs.getString(1) + "\n");
        }
        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new A());
        i = new Intent(this, Options.class);


    }

    class A implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            startActivity(i);
        }
    }
}



