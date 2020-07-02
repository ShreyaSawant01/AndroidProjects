package com.example.shrey.external_storage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFileName;
    private EditText editTextData;
    private Button saveButton;
    private Button readButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFileName = (EditText)findViewById(R.id.editText3);
        editTextData = (EditText)findViewById(R.id.editText2);
        saveButton = (Button)findViewById(R.id.button);
        readButton = (Button)findViewById(R.id.button2);

        //Performing action on save button
        saveButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0)
            {
                Toast.makeText(getApplicationContext(),"Hello1",Toast.LENGTH_LONG).show();

                String fileName = editTextFileName.getText().toString();
              String data = editTextData.getText().toString();

              FileOutputStream fos;

              try{
                  File sdCard = Environment.getExternalStorageDirectory();
                  File directory = new File(sdCard.getAbsolutePath()+"/MyFiles");
                  directory.mkdirs();

                  File myFile = new File(directory,fileName);
                  myFile.createNewFile();


                  Toast.makeText(getApplicationContext(),"Hello2",Toast.LENGTH_LONG).show();
                  FileOutputStream fout = new FileOutputStream(myFile);
                  OutputStreamWriter myOutWriter = new OutputStreamWriter(fout);
                  myOutWriter.write(data);
                  myOutWriter.flush();
                  myOutWriter.close();
                  fout.close();
                  Toast.makeText(getApplicationContext(),fileName+" saved ",Toast.LENGTH_LONG).show();

              } catch (FileNotFoundException e) {
                  e.printStackTrace();
              } catch (Exception e) {
                  e.printStackTrace();
              }

            }
       });

        //Performing action on read button
        readButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String fileName = editTextFileName.getText().toString();
                StringBuffer stringBuffer = new StringBuffer();
                String aDataRow = "";
                String aBuffer = "";
               // try {
                   /* File sdCard = Environment.getExternalStorageDirectory();
                    File directory = new File(sdCard.getAbsolutePath()+"/MyFiles");
                    directory.mkdirs();

                    File myFile = new File(directory,fileName);
                    FileInputStream fIn = new FileInputStream(myFile);
                    BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));
                    while ((aDataRow = myReader.readLine()) != null) {
                        aBuffer += aDataRow + "\n";

                    }
                    myReader.close();*/
                //}  catch (IOException e) {
                 //   e.printStackTrace();
                //}
                Toast.makeText(getApplicationContext(), aBuffer, Toast.LENGTH_LONG).show();

            }


        });

    }

}

