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
import com.alimuntung.parbaya.helper.ProfileItem;

import java.util.List;

public class ProfilesAdapter extends RecyclerView.Adapter<ProfilesAdapter.ProfilesViewHolder>{
    private List<ProfileItem> profileItems;

    public ProfilesAdapter(List<ProfileItem> profileItems) {
        this.profileItems = profileItems;
    }

    @Override
    public ProfilesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProfilesViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.profile_container,parent,false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ProfilesViewHolder holder, int position) {
        holder.setProfileData(profileItems.get(position));
    }

    @Override
    public int getItemCount() {
        return profileItems.size();
    }

    class ProfilesViewHolder extends RecyclerView.ViewHolder{
        private TextView nama;
        private TextView nim;
        private ImageView pp;
        public ProfilesViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama1);
            nim = itemView.findViewById(R.id.nim1);
            pp = itemView.findViewById(R.id.pp);
        }

        public void setProfileData(ProfileItem profile){
            nama.setText(profile.getNama());
            nim.setText(profile.getNim());
            pp.setImageResource(profile.getPp());
        }

    }
}
