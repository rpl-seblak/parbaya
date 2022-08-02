package com.alimuntung.parbaya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alimuntung.parbaya.model.Pariwisata;
import com.alimuntung.parbaya.model.PariwisataDB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PariwisataDB pwd = new PariwisataDB();
        Pariwisata pw = new Pariwisata(2.0, 2.0, "test");
        pwd.add(pw);
    }
}