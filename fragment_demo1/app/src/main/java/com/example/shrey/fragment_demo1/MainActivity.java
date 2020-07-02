package com.example.shrey.fragment_demo1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void FragmentOneClick(View v)
    {
        Fragment frag1;
        frag1 = new FragmentOne();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment1,frag1);
        ft.show(frag1);
        ft.commit();

    }
    public void FragmentTwoClick(View v)
    {
        Fragment frag2;
        frag2 = new FragmentTwo();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment1,frag2);
        ft.show(frag2);
        ft.commit();

    }
}
