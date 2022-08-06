package com.alimuntung.parbaya.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alimuntung.parbaya.R;
import com.alimuntung.parbaya.model.Pariwisata;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.io.Serializable;

public class PariwisataView extends AppCompatActivity implements Serializable {
    private Pariwisata wisata;
    private ImageView thumbnail;
    private TextView alamat,deskripsi;
    private FloatingActionButton backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pariwisata_view);
        getSupportActionBar().hide();
        wisata = (Pariwisata) getIntent().getSerializableExtra("wisata");
      //  Log.i("testsukses",wisata.getJudul().toString());
        backBtn= findViewById(R.id.backviewButton);
        alamat = findViewById(R.id.LokasiDetail);
        deskripsi = findViewById(R.id.deskripsiwisata);

        alamat.setText(wisata.getAlamat());
        deskripsi.setText(wisata.getDeskripsi());

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
// Ikbar Laudza Alviansyah
// IF-7
// 10119260

    }
}