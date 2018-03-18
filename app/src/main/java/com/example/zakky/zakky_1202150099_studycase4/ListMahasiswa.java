package com.example.zakky.zakky_1202150099_studycase4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListMahasiswa extends AppCompatActivity {

        ListView namamahasiswa;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_list_mahasiswa);
                //Mendefinisikan listview
                namamahasiswa = findViewById(R.id.namamahasiswa);
        }

        //Method ketika tombol ditekan
        public void loadmahasiswa(View view) {
                //Memulai AsyncTask
                new getData(namamahasiswa).execute();
        }

        //Sub-class Asynctask
        class getData extends AsyncTask<String, Integer, String>{
                ListView namamahasiswa;
                ArrayAdapter adapternya;
                ArrayList<String> listItems;
                ProgressDialog dlg;

                //Constructor ketika AsyncTask diinisialisasi
                public getData(ListView namamahasiswa) {
                        this.namamahasiswa = namamahasiswa;
                        dlg = new ProgressDialog(ListMahasiswa.this);
                        listItems = new ArrayList<>();
                }

                //Method sebelum AsyncTask dimulai
                @Override
                protected void onPreExecute() {
                        super.onPreExecute();
                        //Menampilkan ProgressDialog
                        dlg.setMessage("Loading Data");
                        dlg.setIndeterminate(false);
                        dlg.setMax(100);
                        dlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        dlg.setProgress(0);
                        dlg.show();
                }

                //Method ketika AsynTask dilakukan
                @Override
                protected String doInBackground(String... strings) {
                        //Membuat adapter
                        adapternya = new ArrayAdapter<>(ListMahasiswa.this, android.R.layout.simple_list_item_1, listItems);
                        //Menyimpan array pada variabel
                        String [] mahasiswa = getResources().getStringArray(R.array.nama_mahasiswa);
                        //Menyimpan array ke dalam
                        for(int i=0; i<mahasiswa.length;i++){
                                long percentage = 100L*i/mahasiswa.length;
                                try{
                                        dlg.setProgress((int)percentage);
                                        Thread.sleep(250);
                                        listItems.add(mahasiswa[i]);
                                } catch (InterruptedException e) {
                                        e.printStackTrace();
                                }
                        }
                        return null;
                }

                @Override
                protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        namamahasiswa.setAdapter(adapternya);
                        dlg.dismiss();
                }

        }
}