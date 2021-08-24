package com.example.presidentindonesia;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;


public class MyService extends Service {
    private MediaPlayer audio;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        audio = MediaPlayer.create(this, R.raw.tanahair);
        audio.setLooping(true);
        audio.start();
        return  START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        audio.stop();
    }
}

