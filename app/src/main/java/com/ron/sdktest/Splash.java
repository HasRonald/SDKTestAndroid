package com.ron.sdktest;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tune.Tune;
import com.tune.ma.model.TuneCallback;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Tune.getInstance().onFirstPlaylistDownloaded(new TuneCallback() {
            @Override
            public void execute() {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(Splash.this, MainActivity.class));
                    }
                });
            }
        }, 2000);
    }
}
