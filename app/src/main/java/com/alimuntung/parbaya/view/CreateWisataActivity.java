package com.alimuntung.parbaya.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.alimuntung.parbaya.R;
import com.alimuntung.parbaya.contractor.WisataContract;
import com.alimuntung.parbaya.model.Pariwisata;
import com.alimuntung.parbaya.presenter.PariwisataPresenter;

public class CreateWisataActivity extends AppCompatActivity implements WisataContract.WisataView {
    private PariwisataPresenter pwp;
    private Button btnsimpan;
    private EditText judul,desc,lat,lng;
//    private EditText desc;
//    private EditText lat;
//    private EditText lng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_wisata);
        pwp = new PariwisataPresenter( this);
        btnsimpan = findViewById(R.id.btnSimpan);
        judul = findViewById(R.id.txtJudul);
        desc = findViewById(R.id.txtDesc);
        lat = findViewById(R.id.lat);
        lng = findViewById(R.id.lng);
        btnsimpan.setOnClickListener(view -> {
            pwp.onSubmit(new Pariwisata(Double.parseDouble(
                    lat.getText().toString()),
                    Double.parseDouble(lng.getText().toString()),
                    judul.getText().toString(),
                    desc.getText().toString()));
        });

    }

    @Override
    public void showProgress() {
        Log.i("progress","tampill...");
    }

    @Override
    public void hideProgress() {
        Log.i("progress","hilang...");
    }

    @Override
    public void showListWisata() {

    }

    @Override
    public void showMessage() {
        Log.i("SUCCESS","berhasil...");
    }
}