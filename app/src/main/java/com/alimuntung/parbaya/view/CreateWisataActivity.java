package com.alimuntung.parbaya.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alimuntung.parbaya.R;
import com.alimuntung.parbaya.contractor.WisataContract;
import com.alimuntung.parbaya.model.Pariwisata;
import com.alimuntung.parbaya.presenter.PariwisataPresenter;

import java.util.ArrayList;

public class CreateWisataActivity extends AppCompatActivity implements WisataContract.WisataView {
    private PariwisataPresenter pwp;
    private Button btnsimpan;
    private EditText judul,desc,lat,lng;
    private LinearLayout cform;
    private ProgressBar progressBar;
//    private EditText desc;
//    private EditText lat;
//    private EditText lng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_wisata);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        cform = findViewById(R.id.formCreate);
        pwp = new PariwisataPresenter( this);
        btnsimpan = findViewById(R.id.btnSimpan);
        judul = findViewById(R.id.txtJudul);
        desc = findViewById(R.id.txtDesc);
        lat = findViewById(R.id.lat);
        lng = findViewById(R.id.lng);
        btnsimpan.setOnClickListener(view -> {
            pwp.onSubmit(new Pariwisata(
                    Double.parseDouble(lat.getText().toString()),
                    Double.parseDouble(lng.getText().toString()),
                    judul.getText().toString(),
                    desc.getText().toString()));
        });

    }

    @Override
    public void showProgress() {
        Log.i("progress","tampill...");
        progressBar.setVisibility(View.VISIBLE);
        cform.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        Log.i("progress","hilang...");
        progressBar.setVisibility(View.GONE);
        cform.setVisibility(View.VISIBLE);
    }

    @Override
    public void showListWisata(ArrayList<Pariwisata> pwss) {

    }

    @Override
    public void showMessage() {
        Log.i("SUCCESS","berhasil...");
        Toast.makeText(this,"Berhasil Created",Toast.LENGTH_SHORT).show();
                lat.getText().clear();
                lng.getText().clear();
                judul.getText().clear();
                desc.getText().clear();
    }
}