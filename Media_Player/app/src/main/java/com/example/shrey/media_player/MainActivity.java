package com.example.shrey.media_player;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private Button pause;
    private Button stop;
    private VideoView videoView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button)findViewById(R.id.button);
        pause = (Button)findViewById(R.id.button2);
        stop = (Button)findViewById(R.id.button3);

        videoView1 = (VideoView)findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        videoView1.setMediaController(mediaController);
        videoView1.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video));


        //mediaController.setAnchorView(videoView1);

        final MediaPlayer mp = new MediaPlayer();
        try
        {
            mp.setDataSource(Environment.getExternalStorageDirectory().getPath()+"/Music/radha.mp3");
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               // mp.start();
                videoView1.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //mp.pause();
                videoView1.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //mp.stop();
                videoView1.stopPlayback();
            }
        });


        
    }


}
