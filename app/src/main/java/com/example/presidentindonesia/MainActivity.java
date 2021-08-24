package com.example.presidentindonesia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    MediaPlayer audio;
    private Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.buttonStart);
        stop = (Button) findViewById(R.id.buttonStop);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
//        //Audio Player
//        audio = MediaPlayer.create(this, R.raw.tanahair);
//        audio.setLooping(true);
//        audio.setVolume(1, 1);
//        audio.start();


        getSupportActionBar().hide();

        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        return true;
                    case R.id.semuapresident:
                        startActivity(new Intent(getApplicationContext(),
                                President.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.quiz:
                        startActivity(new Intent(getApplicationContext(),
                                Quiz.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),
                                About.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == start) {
            startService(new Intent(this, MyService.class));
        } else if (v == stop) {
            stopService(new Intent(this, MyService.class));
//            audio.stop();
        }
//    }
//    public void onDestroy() {
//        super.onDestroy();
//
//        audio.stop();
//    }
//
//    public void onToggleClicked(View view) {
//        boolean on = ((ToggleButton) view).isChecked();
//
//        if (on){
//            audio.setVolume(0,0);
//        }
//        else {
//            audio.setVolume(1,1);
//        }
//    }
//
//    public void onBackPressed(){
//        audio.stop();
//        MainActivity.this.finish();
//    }
    }
}