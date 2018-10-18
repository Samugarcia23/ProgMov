package com.example.sgarcia.ejemploproyecto;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button bkick, bsnare, bcymb, bclap, bperc;
    //MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* try {
            play();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    /*public void play() throws IOException {
        bkick=findViewById(R.id.bkick);
        bclap=findViewById(R.id.bclap);
        bsnare=findViewById(R.id.bsnare);
        bcymb=findViewById(R.id.bcymb);
        bperc=findViewById(R.id.bperc);

        bkick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (player.isPlaying()) {
                        player.stop();
                        player.release();
                        player = new MediaPlayer();
                    }
                    AssetFileDescriptor descriptor = getAssets().openFd("kick.wav");
                    player.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
                    descriptor.close();
                    player.prepare();
                    player.setVolume(1f, 1f);
                    player.setLooping(true);
                    player.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/
}
