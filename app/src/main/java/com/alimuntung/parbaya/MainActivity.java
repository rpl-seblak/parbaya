package com.alimuntung.parbaya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.alimuntung.parbaya.adapter.OnBoardingAdapter;
import com.alimuntung.parbaya.helper.OnBoardingItem;
import com.alimuntung.parbaya.model.Pariwisata;
import com.alimuntung.parbaya.model.PariwisataDB;
import com.alimuntung.parbaya.view.CreateWisataActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private OnBoardingAdapter onBoardingAdapter;
    private Button lets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lets = findViewById(R.id.getstart);
        setOnBoardingItems();

        ViewPager2 onBoardingViewPager = findViewById(R.id.onboarding);
        onBoardingViewPager.setAdapter(onBoardingAdapter);


//        PariwisataDB pwd = new PariwisataDB();
//        Pariwisata pw = new Pariwisata(2.0, 2.0, "test","coba");
//        pwd.add(pw);
        lets.setOnClickListener(
                view -> {
                    Intent intent = new Intent(this, CreateWisataActivity.class);
                    startActivity(intent);
                }
        );
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void setOnBoardingItems(){
        List<OnBoardingItem> onBoardingItems = new ArrayList<>();

        OnBoardingItem item1 = setOnBoardingItem("lorem1","lorem1",R.drawable.onboard1);
        OnBoardingItem item2 = setOnBoardingItem("lorem2","lorem2",R.drawable.onboard2);
        OnBoardingItem item3 = setOnBoardingItem("lorem3","lorem3",R.drawable.onboard3);
        onBoardingItems.add(item1);
        onBoardingItems.add(item2);
        onBoardingItems.add(item3);
        onBoardingAdapter = new OnBoardingAdapter(onBoardingItems);
    }

    private OnBoardingItem setOnBoardingItem(String title,String desc,int img){
        OnBoardingItem item = new OnBoardingItem();
        item.setTitle(title);
        item.setDesc(desc);
        item.setImg(img);
        return item;
    }
}