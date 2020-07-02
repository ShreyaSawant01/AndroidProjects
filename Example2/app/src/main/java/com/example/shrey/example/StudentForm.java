package com.example.shrey.example;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentForm extends AppCompatActivity {

    private EditText name;
    private EditText roll_number;
    private EditText address;
    private EditText contact;
    private EditText course;
    private EditText fees_paid;
    private Button admission;
    private Button main_menu;
    Intent i;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);

        DatabaseHelper h = new DatabaseHelper(this);

        roll_number = (EditText)findViewById(R.id.editText);
        name = (EditText)findViewById(R.id.editText2);
        address = (EditText)findViewById(R.id.editText3);
        contact = (EditText)findViewById(R.id.editText5);
        course = (EditText)findViewById(R.id.editText6);
        fees_paid = (EditText)findViewById(R.id.editText7);
        db = h.getWritableDatabase();





        admission = (Button)findViewById(R.id.button2);
        admission.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("ID",roll_number.getText().toString());
                cv.put("Name",name.getText().toString());
                cv.put("Address",address.getText().toString());
                cv.put("Contact",contact.getText().toString());
                cv.put("Fees",fees_paid.getText().toString());
                cv.put("Course",course.getText().toString());
                db.insert("Student",null,cv);

                Toast.makeText(getApplicationContext(),"Admission successful!",Toast.LENGTH_LONG).show();
            }
        });

        main_menu = (Button)findViewById(R.id.button3);
        main_menu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}
