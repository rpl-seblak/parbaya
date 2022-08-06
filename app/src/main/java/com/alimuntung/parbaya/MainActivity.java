package com.alimuntung.parbaya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alimuntung.parbaya.adapter.OnBoardingAdapter;
import com.alimuntung.parbaya.helper.OnBoardingItem;
import com.alimuntung.parbaya.model.Pariwisata;
import com.alimuntung.parbaya.model.PariwisataDB;
import com.alimuntung.parbaya.view.CreateWisataActivity;
import com.alimuntung.parbaya.view.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /* createdby
     * NIM : 10119294
     * NAMA : Lingga Juliansyah
     * Kelas : IF-7
     * */
    private OnBoardingAdapter onBoardingAdapter;
    private Button lets;
    private LinearLayout onBoardingIndicatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lets = findViewById(R.id.getstart);
        onBoardingIndicatorLayout = findViewById(R.id.onboardingIndicator);
        setOnBoardingItems();
        setupOnBoardingIndicator();
        setupOnBoardingActive(0);



        ViewPager2 onBoardingViewPager = findViewById(R.id.onboarding);
        onBoardingViewPager.setAdapter(onBoardingAdapter);

        onBoardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setupOnBoardingActive(position);
            }
        });
        lets.setOnClickListener(
                view -> {
                    Intent intent = new Intent(this, HomeActivity.class);
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

        OnBoardingItem item1 = setOnBoardingItem("WISATA","Temukan Tempat Wisata Terbaik",R.drawable.onboard1);
        OnBoardingItem item2 = setOnBoardingItem("KAB.BANDUNG","Merekomendasikan Tempat wisata di daerah Bandung",R.drawable.onboard2);
        OnBoardingItem item3 = setOnBoardingItem("EXPLORE","Ekplorasi tempat wisata Terfavorit dan Instagramable",R.drawable.onboard3);
        onBoardingItems.add(item1);
        onBoardingItems.add(item2);
        onBoardingItems.add(item3);
        onBoardingAdapter = new OnBoardingAdapter(onBoardingItems);
    }

    private void setupOnBoardingIndicator(){
        ImageView[] indicators = new ImageView[onBoardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);
        for (int i = 0; i < indicators.length; i++){
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_active
            ));
            indicators[i].setLayoutParams(layoutParams);
            onBoardingIndicatorLayout.addView(indicators[i]);
        }
    }

    private void setupOnBoardingActive(int index){
        int childcount = onBoardingIndicatorLayout.getChildCount();
        for(int i = 0; i < childcount; i++){
            ImageView imageView = (ImageView) onBoardingIndicatorLayout.getChildAt(i);
            if(i==index){
                imageView.setColorFilter(Color.parseColor("#37355B"));
            }else{
                imageView.setColorFilter(Color.parseColor("#FFFFFF"));
            }
        }
    }

    private OnBoardingItem setOnBoardingItem(String title,String desc,int img){
        OnBoardingItem item = new OnBoardingItem();
        item.setTitle(title);
        item.setDesc(desc);
        item.setImg(img);
        return item;
    }
}