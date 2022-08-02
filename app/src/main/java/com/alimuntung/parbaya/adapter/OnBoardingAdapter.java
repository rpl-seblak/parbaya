package com.alimuntung.parbaya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alimuntung.parbaya.R;
import com.alimuntung.parbaya.helper.OnBoardingItem;

import java.util.List;

public class OnBoardingAdapter extends RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>{

    private List<OnBoardingItem> onBoardingItemList;

    public OnBoardingAdapter(List<OnBoardingItem> onBoardingItemList) {
        this.onBoardingItemList = onBoardingItemList;
    }

    @NonNull
    @Override
    public OnBoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnBoardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.onboarding_container,parent,false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardingViewHolder holder, int position) {
        holder.setOnBoardingData(onBoardingItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return onBoardingItemList.size();
    }

    class OnBoardingViewHolder extends RecyclerView.ViewHolder{
        private TextView textTitle;
        private TextView textDesc;
        private ImageView imgOnbrd;
        public OnBoardingViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDesc = itemView.findViewById(R.id.textDescription);
            imgOnbrd = itemView.findViewById(R.id.imgOnboarding);
        }

        void setOnBoardingData(OnBoardingItem onBoardingItem){
            textTitle.setText(onBoardingItem.getTitle());
            textDesc.setText(onBoardingItem.getDesc());
            imgOnbrd.setImageResource(onBoardingItem.getImg());
        }
    }
}
