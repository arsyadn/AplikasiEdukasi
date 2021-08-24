package com.example.presidentindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PenjelasanPresident extends AppCompatActivity {

    ImageView  mainImageView;
    TextView title, description;

    String data1;
    String data2;
    String data3;
    String data4;
    int myImage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjelasan_president);

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        getData();
        setData();

    }

    private  void getData(){
        if (getIntent().hasExtra("myImage2") && getIntent().hasExtra("data3")
        && getIntent().hasExtra("data4")){
            data3 = getIntent().getStringExtra("data3");
            data4 = getIntent().getStringExtra("data4");
            myImage2 = getIntent().getIntExtra("myImage2", 1);

        }else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }

    }

    private  void setData(){
        title.setText(data3);
        description.setText(data4);
        mainImageView.setImageResource(myImage2);
    }

}