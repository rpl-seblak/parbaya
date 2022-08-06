package com.alimuntung.parbaya.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.alimuntung.parbaya.R;
import com.alimuntung.parbaya.model.Pariwisata;

import java.io.Serializable;

public class PariwisataView extends AppCompatActivity implements Serializable {
    private Pariwisata wisata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pariwisata_view);
        getSupportActionBar().hide();
        wisata = (Pariwisata) getIntent().getSerializableExtra("wisata");
        Log.i("testsukses",wisata.getJudul().toString());
    }
}