package com.alimuntung.parbaya.view.ui.detailtim;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.alimuntung.parbaya.R;
import com.alimuntung.parbaya.adapter.ProfilesAdapter;
import com.alimuntung.parbaya.databinding.FragmentDetailTimBinding;
import com.alimuntung.parbaya.helper.OnBoardingItem;
import com.alimuntung.parbaya.helper.ProfileItem;

import java.util.ArrayList;
import java.util.List;

public class DetailTimFragment extends Fragment {
    /* Createdby
     * NIM : 10119294
     * NAMA : Lingga Juliansyah
     * Kelas : IF-7
     * */
    private FragmentDetailTimBinding binding;
    private ProfilesAdapter profilesAdapter;
    private LinearLayout profileIndicatorLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDetailTimBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setProfilesItem();
        ViewPager2 profileViewPager = binding.pagerProfile;
        profileIndicatorLayout = binding.profilesIndicator;
        profileViewPager.setAdapter(profilesAdapter);

        setupProfileIndicator();
        setupProfileActive(0);

        profileViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setupProfileActive(position);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void setProfilesItem() {
        List<ProfileItem> profileItemList = new ArrayList<>();
        ProfileItem item1 = setProfileItem("Ikbar Laudza Alviansyah", "10119260",R.drawable.pp_ikbar);
        ProfileItem item2 = setProfileItem("Aldi Rezeki Ramdani", "10119273",R.drawable.pp_aldi);
        ProfileItem item3 = setProfileItem("Ikra Esa A'raaf Mahardika", "10119271",R.drawable.pp_ikra);
        ProfileItem item4 = setProfileItem("Albanna Rahmadani Sulityo ", "10119270",R.drawable.pp_alba);
        ProfileItem item5 = setProfileItem("Lingga Juliansyah", "10119294",R.drawable.pp_lingga);
        profileItemList.add(item1);
        profileItemList.add(item2);
        profileItemList.add(item3);
        profileItemList.add(item4);
        profileItemList.add(item5);
        profilesAdapter = new ProfilesAdapter(profileItemList);
    }

    private ProfileItem setProfileItem(String nama, String nim, int img){
        ProfileItem item = new ProfileItem(nim,nama,img);
        return item;
    }

    private void setupProfileIndicator(){
        ImageView[] indicators = new ImageView[profilesAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);
        for (int i = 0; i < indicators.length; i++){
            indicators[i] = new ImageView(getContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getContext(),
                    R.drawable.onboarding_indicator_active
            ));
            indicators[i].setLayoutParams(layoutParams);
            profileIndicatorLayout.addView(indicators[i]);
        }
    }

    private void setupProfileActive(int index){
        int childcount = profileIndicatorLayout.getChildCount();
        for(int i = 0; i < childcount; i++){
            ImageView imageView = (ImageView) profileIndicatorLayout.getChildAt(i);
            if(i==index){
                imageView.setColorFilter(Color.parseColor("#37355B"));
            }else{
                imageView.setColorFilter(Color.parseColor("#018786"));
            }
        }
    }
}