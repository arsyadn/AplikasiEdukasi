package com.example.presidentindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class IsiQuiz extends AppCompatActivity {

    TextView kuis;
    RadioGroup rg;
    ImageView fotopres;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    int nogambar =  3;
    public static int hasil, benar, salah;

    //Questions
    String[] pertanyaan_kuis = new String[]{
            "1. Siapakah nama tokoh diatas?",
            "2. Siapakah presiden keenam Indonesia?",
            "3. Siapakah nama tokoh diatas?",
            "4. Tahun berapakah Soekarno lahir?",
            "5. Siapakah presiden yang menjabat pada tahun 1999-2001?",
            "6. Siapakah presiden yang mendapat julukan sebagai Pahlawan Proklamasi?",
            "7. Siapakah nama tokoh diatas?",
            "8. Tahun berapakah masa bakti Abdurrahman Wahid?",
            "9. Siapakah nama tokoh diatas?",
            "10. Siapakah anak dari presiden RI pertama yang kemudian terpilih menjadi presiden?",
            //10
            "11. Siapakah presiden yang memegang kekuasaan terlama sepanjang sejarah Indonesia?",
            "12. Siapakah presiden ketiga Indonesia?",
            "13. Siapakah nama tokoh diatas?",
            "14. Tahun berapakah masa bakti Joko Widodo?",
            "15. Siapakah nama tokoh diatas?",
            //15
            "16. Tahun berapakah masa bakti Soeharto?",
            "17. Tahun berapakah Susilo Bambang Yudhoyono lahir?",
            "18. Tahun berapakah Abdurrahman Wahid lahir?",
            "19. Joko Widodo lahir dimana?",
            "20. Siapakah presiden pertama Indonesia?",
            //20
            "21. B. J. Habibie lahir dimana?",
            "22. Siapakah nama tokoh diatas?",
            "23. Pasangan dari presiden keempat Indonesia?",
            "24. Pasangan dari presiden ketiga Indonesia?",
            "25. Siapakah presiden yang memiliki masa bakti 2014-Sekarang?"



    };

    //Pilihan Jawaban A,B,C,D
    String[] pilihan_jawaban = new String[]{
            "Soeharto", "Joko Widodo", "Susilo Bambang Yudhoyono", "Soekarno",
            "Susilo Bambang Yudhoyono", "B. J. Habibie", "Megawati Soekarnoputri", "Joko Widodo",
            "Soekarno", "B. J. Habibie", "Soeharto", "Abdurrahman Wahid",
            "1921", "1901", "1936", "1937",
            "B. J. Habibie", "Megawati Soekarnoputri", "Abdurrahman Wahid", "Susilo Bambang Yudhoyono",
                //5
            "Soeharto", "Soekarno", "Megawati Soekarnoputri", "B. J. Habibie",
            "Joko Widodo", "Abdurrahman Wahid", "Soeharto", "Susilo Bambang Yudhoyono",
            "1998-1999", "1999-2001", "2001-2004", "2004-2014",
            "Soeharto", "Susilo Bambang Yudhoyono", "Abdurrahman Wahid", "Joko Widodo",
            "Susilo Bambang Yudhoyono", "Abdurrahman Wahid", "B. J. Habibie", "Megawati Soekarnoputri",
                //10
            "Soekarno", "Soeharto", "B. J. Habibie", "Susilo Bambang Yudhoyono",
            "Abdurrahman Wahid", "Megawati Soekarnoputri", "B. J. Habibie", "Susilo Bambang Yudhoyono",
            "Abdurrahman Wahid", "Megawati Soekarnoputri", "B. J. Habibie", "Susilo Bambang Yudhoyono",
            "1999-2001", "2001-2004", "2004-2014", "2014-Sekarang",
            "Joko Widodo", "Susilo Bambang Yudhoyono", "Megawati Soekarnoputri", "Soekarno",
            //15
            "1945-1966", "1966-1998", "1998-1999", "1999-2001",
            "1947", "1949", "1961", "1940",
            "1947", "1949", "1961", "1940",
            "Pare-Pare, Sulawesi Selatan", "Yogyakarta", "Surakarta", "Pacitan, Jawa Timur",
            "Soeharto", "Abdurrahman Wahid", "Soekarno", "B. J. Habibie",
            //20
            "Pare-Pare, Sulawesi Selatan", "Yogyakarta", "Surakarta", "Pacitan, Jawa Timur",
            "Susilo Bambang Yudhoyono", "Soeharto", "Joko Widodo", "Abdurrahman Wahid",
            "Sinta Nuriah", "Hasri Ainun Besari", "Fatmawati", "Hartini",
            "Sinta Nuriah", "Hasri Ainun Besari", "Fatmawati", "Hartini",
            "Susilo Bambang Yudhoyono", "Soeharto", "Joko Widodo", "Abdurrahman Wahid"

    };

    //Jawaban Benar
    String[] jawaban_benar = new String[]{
            "Soekarno",
            "Susilo Bambang Yudhoyono",
            "B. J. Habibie",
            "1901",
            "Abdurrahman Wahid",
                //5
            "Soekarno",
            "Joko Widodo",
            "1999-2001",
            "Susilo Bambang Yudhoyono",
            "Megawati Soekarnoputri",
                //10
            "Soeharto",
            "B. J. Habibie",
            "Abdurrahman Wahid",
            "2014-Sekarang",
            "Megawati Soekarnoputri",
                //15
            "1966-1998",
            "1949",
            "1940",
            "Surakarta",
            "Soekarno",
                //20
            "Pare-Pare, Sulawesi Selatan",
            "Soeharto",
            "Sinta Nuriah",
            "Hasri Ainun Besari",
            "Joko Widodo"



    };

//    Presiden
    int[] presidensoal = new int[]{
            R.drawable.ssoekarno,
            R.drawable.qkotaktipis,
            R.drawable.sbjhabibie,
            R.drawable.qkotaktipis,
            R.drawable.qkotaktipis,
        //5
            R.drawable.qkotaktipis,
            R.drawable.sjokowi,
            R.drawable.qkotaktipis,
            R.drawable.ssby,
            R.drawable.qkotaktipis,
        //10
            R.drawable.qkotaktipis,
            R.drawable.qkotaktipis,
            R.drawable.sgusdur,
            R.drawable.qkotaktipis,
            R.drawable.smegawati,
        //15
            R.drawable.qkotaktipis,
            R.drawable.qkotaktipis,
            R.drawable.qkotaktipis,
            R.drawable.qkotaktipis,
            R.drawable.qkotaktipis,
        //20
            R.drawable.qkotaktipis,
            R.drawable.ssoeharto,
            R.drawable.qkotaktipis,
            R.drawable.qkotaktipis,
            R.drawable.qkotaktipis

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_quiz);
        getSupportActionBar().hide();

        //Sinkronisasi dengan isiQuiz.xml
        kuis = (TextView) findViewById(R.id.kuis);
        rg = (RadioGroup) findViewById(R.id.pilihan);
        fotopres = (ImageView) findViewById(R.id.fotosoalpresdient);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        fotopres.setImageResource(presidensoal[nomor]);
        kuis.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view){
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()){

            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);

            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor]))
                benar++;
            else salah++;
            nomor++;
//            Toast.makeText(this, jawaban_benar[nomor], Toast.LENGTH_LONG).show();

            if (nomor < pertanyaan_kuis.length) {
                fotopres.setImageResource(presidensoal[nomor]);
                kuis.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);


            }
            else {
                hasil = benar * 4;
                Intent selesai = new Intent(getApplicationContext(), HasilQuiz.class);
                startActivity(selesai);
            }


        }
        else {
            Toast.makeText(this, "Kamu Harus Menjawab Terlebih Dahulu",Toast.LENGTH_LONG).show();
        }
    }
}