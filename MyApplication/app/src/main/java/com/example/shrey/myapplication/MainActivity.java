package com.example.shrey.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button)findViewById(R.id.button);
        b.setOnCreateContextMenuListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        CreateMenu(menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return MenuChoice(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuinfo)
    {
       super.onCreateContextMenu(menu,view,menuinfo);
       CreateMenu(menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        return MenuChoice(item);
    }
    private void CreateMenu(Menu menu) {
        menu.setQwertyMode(true);
        MenuItem mnu1 = menu.add(0,0,0,"Addition");
        {
            mnu1.setAlphabeticShortcut('a');
            mnu1.setIcon(R.drawable.pic1);
        }
        MenuItem mnu2 = menu.add(0,1,1,"Login");
        {
            mnu2.setAlphabeticShortcut('b');
            mnu2.setIcon(R.drawable.pic1);
        }

    }

    private boolean MenuChoice(MenuItem item) {
        switch(item.getItemId())
        {
            case 0:
                Toast.makeText(this,"You clicked on Addition",Toast.LENGTH_LONG).show();

                return true;
            case 1:
                Toast.makeText(this,"You clicked on Login",Toast.LENGTH_LONG).show();;

                return true;
        }
        return false;
    }

}
