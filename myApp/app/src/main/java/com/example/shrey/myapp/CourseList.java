package com.example.shrey.myapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CourseList extends AppCompatActivity {
    List<String> li;
    ListView list;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        DatabaseHelper h = new DatabaseHelper(this,"Student_db");
        Toast.makeText(getApplicationContext(),"database created",Toast.LENGTH_LONG).show();
        SQLiteDatabase db = h.getWritableDatabase();
        li = new ArrayList<>();
       // System.out.println("version " + db.getVersion());
        Cursor rs = db.rawQuery("SELECT Name FROM Courses", null);

        while (rs.moveToNext()) {
           // tv.append(rs.getString(0) + " " + rs.getString(1) + "\n");
            li.add(rs.getString(0));
        }
        list=(ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> adp=new ArrayAdapter<String>(getBaseContext(),R.layout.list,R.id.label,li);
        list.setAdapter(adp);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                //Toast.makeText(getBaseContext(),li.get(arg2),
                       // Toast.LENGTH_SHORT).show();
                switch(arg2)
                {
                    case 0:
                        i = new Intent(getApplicationContext(), PHP.class);
                        startActivity(i);
                        break;

                }

            }
        });

    }
}
