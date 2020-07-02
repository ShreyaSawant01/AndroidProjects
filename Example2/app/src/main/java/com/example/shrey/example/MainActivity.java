package com.example.shrey.example;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b;
    Intent i;
    Button a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                 i = new Intent(getApplicationContext(),CourseList.class);
                 startActivity(i);
            }
        });
        a = (Button)findViewById(R.id.button7);
        a.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(),AndroidDatabaseManager.class);
                startActivity(i);
            }
        });
    }
}
