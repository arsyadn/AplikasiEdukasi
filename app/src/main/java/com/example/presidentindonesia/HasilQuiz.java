package com.example.presidentindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HasilQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_quiz);
        getSupportActionBar().hide();

        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView hasil2 = (TextView)findViewById(R.id.hasil2);
        TextView nilai = (TextView)findViewById(R.id.nilai);

        hasil.setText("Jawaban Benar : "+IsiQuiz.benar);
        hasil2.setText("Jawaban Salah : "+IsiQuiz.salah);
        nilai.setText(""+IsiQuiz.hasil);
    }

    public void ulangi(View view){
        finish();
        Intent a = new Intent(getApplicationContext(), Quiz.class);
        startActivity(a);
    }

    public void kuncijawaban(View view){
        finish();
        Intent kj = new Intent(getApplicationContext(), KunciJawaban.class);
        startActivity(kj);
    }
}