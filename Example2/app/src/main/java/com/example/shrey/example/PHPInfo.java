package com.example.shrey.example;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PHPInfo extends AppCompatActivity {

    private Button enroll;
    Intent i;

    TextView t1;
    TextView t2;
    TextView t3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phpinfo);



        DatabaseHelper h = new DatabaseHelper(this);
        SQLiteDatabase db = h.getWritableDatabase();
       // System.out.println("version " + db.getVersion());
        Cursor rs = db.rawQuery("SELECT ID,Duration,Fees FROM Courses", null);
        //Cursor rs = db.rawQuery("SELECT sid,name FROM myTable",new String[] {"David","2});
        if(rs!=null) {

            rs.moveToFirst();

            while (rs.moveToNext()) {
                if(rs.getString(0).equals("PHP")) {
                    t1.append(rs.getString(1));
                    t2.append(rs.getString(2));
                    t3.append(rs.getString(3));
                    break;
                }
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Cursor is null",Toast.LENGTH_LONG).show();
        }

        enroll = (Button) findViewById(R.id.button4);
        enroll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(), StudentForm.class);
                startActivity(i);
            }
        });

    }
}
