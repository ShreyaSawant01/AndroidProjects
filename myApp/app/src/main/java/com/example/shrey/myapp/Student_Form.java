package com.example.shrey.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Student_Form extends AppCompatActivity {


    private EditText name;
    private EditText roll_number;
    private EditText address;
    private EditText contact;
    private EditText course;
    private EditText fees_paid;
    private Button admission;
    private Button main_menu;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__form);
        roll_number = (EditText)findViewById(R.id.editText);
        name = (EditText)findViewById(R.id.editText2);
        address = (EditText)findViewById(R.id.editText3);
        contact = (EditText)findViewById(R.id.editText5);
        course = (EditText)findViewById(R.id.editText6);
        fees_paid = (EditText)findViewById(R.id.editText7);



        admission = (Button)findViewById(R.id.button2);
        admission.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Admission successful!",Toast.LENGTH_LONG).show();
            }
        });

        main_menu = (Button)findViewById(R.id.button3);
        main_menu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
             i = new Intent(getApplicationContext(),MainActivity.class);
            }
        });

    }
}
