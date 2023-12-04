package com.ension.if9.view.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

import com.ension.if9.R;
import com.ension.if9.view.login.LoginActivity;

public class Splash extends AppCompatActivity {

    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        videoView = (VideoView) findViewById(R.id.viewVideo);
        String videoPath = new StringBuilder("android.resource://")
                .append(getPackageName())
                .append("/raw/splash")
                .toString();
        videoView.setVideoPath(videoPath);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run(){

                        startActivity(new Intent(Splash.this, LoginActivity.class));
                        finish();
                    }
                }, 300);
            }
        });

        videoView.start();
    }
}