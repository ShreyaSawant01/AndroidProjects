package com.example.shrey.androidservices;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MyService extends Service {
    MediaPlayer myPlayer;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();

        myPlayer = MediaPlayer.create(this, R.raw.radha);
        myPlayer.setLooping(false); // Set looping
    }
    @Override
    public int onStartCommand(Intent intent, int flags,int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
       // myPlayer.start();
        try
        {
            int result = DownloadFile(new URL("http://www.google.com"));
            Toast.makeText(getBaseContext(),"Downloaded"+result+"bytes",Toast.LENGTH_LONG).show();
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        return START_STICKY;
    }

    private int DownloadFile(URL url) {
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        return 100;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
        myPlayer.stop();
    }

}
