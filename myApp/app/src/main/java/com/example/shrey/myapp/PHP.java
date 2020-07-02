package com.example.shrey.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PHP extends AppCompatActivity {

    private Button enroll;
    Intent i;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php);
        enroll = (Button)findViewById(R.id.button4);
        enroll.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(),Student_Form.class);
            }
        });
        back = (Button)findViewById(R.id.button5);
        back.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(),CourseList.class);
            }
        });
    }
}
