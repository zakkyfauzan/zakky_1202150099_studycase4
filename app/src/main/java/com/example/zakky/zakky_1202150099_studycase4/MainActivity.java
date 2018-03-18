package com.example.zakky.zakky_1202150099_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pindah(View view) {
        //Mendapatkan id Button
        int id = view.getId();
        //Mengatur perpindahan activity sesuai button
        switch (id){
            case R.id.tombolgambar:
                startActivity(new Intent(this, PencariGambar.class));
                break;
            case R.id.tombolmahasiswa:
                startActivity(new Intent(this, ListMahasiswa.class));
                break;
        }
        //Membuat transisi antar method
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}