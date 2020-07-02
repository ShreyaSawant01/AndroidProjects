package com.example.shrey.external_storage_example;

import android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    File myFile;
    private EditText editText;
    private int STORAGE_PERMISSION_CODE = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.info);

    }
    public void next(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
    public void savePublic(View view) {
        //Permission to access external storage
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        String info = editText.getText().toString();
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);// Folder Name
        Toast.makeText(getApplicationContext(),"Hello"+folder,Toast.LENGTH_LONG).show();

      if(folder.exists())
      {
          Toast.makeText(getApplicationContext(),"Hello 2",Toast.LENGTH_LONG).show();


          myFile = new File(folder, "myData1.txt");
          // Filename

          try {
              myFile.createNewFile();
          } catch (IOException e) {
              e.printStackTrace();
          }

          if(myFile.exists())
          {
              Toast.makeText(getApplicationContext(),"Hello 3",Toast.LENGTH_LONG).show();
          }

      }
        writeData(myFile, info);
        editText.setText("");
    }
    public void savePrivate(View view) {
        String info = editText.getText().toString();
        File folder = getExternalFilesDir("Shreya");// Folder Name
        File myFile = new File(folder, "myData2.txt");// Filename
        writeData(myFile, info);
        editText.setText("");
    }
    private void writeData(File myFile, String data) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(myFile);

            byte aa[]= data.getBytes();

            Toast.makeText(this, "Done" + aa.toString(), Toast.LENGTH_LONG).show();
            fileOutputStream.write(data.getBytes());

                Toast.makeText(this, "Done" + myFile.getAbsolutePath(), Toast.LENGTH_LONG).show();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
