package com.example.shrey.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> li;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
        //final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
          //      ((int) ViewGroup.LayoutParams.WRAP_CONTENT, (int) ViewGroup.LayoutParams.WRAP_CONTENT);
        //params.leftMargin = 10;
        //params.topMargin = 150;

       final Button show = (Button) findViewById(R.id.button1);
        final ListView list=(ListView) findViewById(R.id.listView1);
       // final ListView list1 = new ListView(this);

        li = new ArrayList<String>();
        li.add("List 1");
        li.add("List 2");
        li.add("List 3");
        li.add("List 4");
        li.add("List 5");

        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                ArrayAdapter<String> adp=new ArrayAdapter<String>
                        (getBaseContext(),R.layout.list,li);
                list.setAdapter(adp);

            }
        });


    }
}
