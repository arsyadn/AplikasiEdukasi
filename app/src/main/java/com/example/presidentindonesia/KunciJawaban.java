package com.example.presidentindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class KunciJawaban extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kunci_jawaban);
        getSupportActionBar().hide();


    }
    public void kembali(View view){
        finish();
        Intent b = new Intent(getApplicationContext(), HasilQuiz.class);
        startActivity(b);

    }
}