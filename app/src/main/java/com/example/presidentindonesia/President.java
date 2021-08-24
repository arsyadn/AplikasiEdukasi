package com.example.presidentindonesia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class President extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[], s3[], s4[];
    int images[] = {R.drawable.soekarno,R.drawable.soeharto,R.drawable.bjhabibie,
            R.drawable.gusdur,R.drawable.megawati,R.drawable.sby,R.drawable.jokowi};

    int images2[] = {R.drawable.psoekarno,R.drawable.psoeharto,R.drawable.pbjhabibie,
            R.drawable.pgusdur,R.drawable.pmegawati,R.drawable.psby,R.drawable.pjokowi};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.allpresident);
        s2 = getResources().getStringArray(R.array.urutanpresiden);
        s3 = getResources().getStringArray(R.array.judulpresiden);
        s4 = getResources().getStringArray(R.array.penjelasan);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, s3, s4, images, images2);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Bottom Navigation
        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.semuapresident);
        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),
                                MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.semuapresident:
                        return true;
                    case R.id.quiz:
                        startActivity(new Intent(getApplicationContext(),
                                Quiz.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),
                                About.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}