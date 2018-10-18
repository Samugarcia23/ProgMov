package com.example.sgarcia.ejemploproyecto2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button bkick, bsnare, bclap, bperc, bstop;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            play();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //stop();

    }

    public void stop(){
        if(player.isPlaying()){
            player.stop();
            player.release();
        }
}

    public void play() throws IOException {
        bkick=findViewById(R.id.bkick);
        bclap=findViewById(R.id.bclap);
        bsnare=findViewById(R.id.bsnare);
        bperc=findViewById(R.id.bperc);
        bstop=findViewById(R.id.bstop);

        bkick.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    bkick.setPressed(true);
                    player = new MediaPlayer();
                    AssetFileDescriptor descriptor = null;
                    try {
                        descriptor = getAssets().openFd("kick.wav");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        player.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        descriptor.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        player.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    player.setVolume(1f, 1f);
                    player.setLooping(true);
                    player.start();


                }
                return onTouchEvent(motionEvent);
            }
        });

        bsnare.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    bsnare.setPressed(true);
                    player = new MediaPlayer();
                    AssetFileDescriptor descriptor = null;
                    try {
                        descriptor = getAssets().openFd("snare.wav");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        player.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        descriptor.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        player.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    player.setVolume(1f, 1f);
                    player.setLooping(true);
                    player.start();


                }
                return onTouchEvent(motionEvent);
            }
        });

        bclap.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    bclap.setPressed(true);
                    player = new MediaPlayer();
                    AssetFileDescriptor descriptor = null;
                    try {
                        descriptor = getAssets().openFd("clap.wav");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        player.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        descriptor.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        player.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    player.setVolume(1f, 1f);
                    player.setLooping(true);
                    player.start();


                }
                return onTouchEvent(motionEvent);
            }
        });

        bperc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    bperc.setPressed(true);
                    player = new MediaPlayer();
                    AssetFileDescriptor descriptor = null;
                    try {
                        descriptor = getAssets().openFd("perc.wav");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        player.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        descriptor.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        player.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    player.setVolume(1f, 1f);
                    player.setLooping(true);
                    player.start();


                }
                return onTouchEvent(motionEvent);
            }
        });

        bstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop();
            }
        });
    }
}
