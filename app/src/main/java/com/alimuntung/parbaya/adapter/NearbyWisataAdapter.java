package com.alimuntung.parbaya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.alimuntung.parbaya.R;
import com.alimuntung.parbaya.model.Pariwisata;

import java.util.List;

public class NearbyWisataAdapter extends RecyclerView.Adapter<NearbyWisataAdapter.NearbyWisataViewHolder> {

    private List<Pariwisata> nearbyPariwisataList;

    public NearbyWisataAdapter(List<Pariwisata> nearbyPariwisataList){
        this.nearbyPariwisataList= nearbyPariwisataList;
    }

    @NonNull
    @Override
    public NearbyWisataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_pariwisata_nearby,parent,false);
        return new NearbyWisataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NearbyWisataViewHolder holder, int position) {
        holder.setNearbyWisataData(nearbyPariwisataList.get(position));
    }

    @Override
    public int getItemCount(){
        return nearbyPariwisataList.size();
    }

    class NearbyWisataViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_judul;
        private CardView cv_wisata;
        public NearbyWisataViewHolder(@NonNull View itemView){
            super(itemView);
         tv_judul = itemView.findViewById(R.id.tvJudulwisata);
         cv_wisata = itemView.findViewById(R.id.cvWisata);
        }

        void setNearbyWisataData(Pariwisata pw){
            tv_judul.setText(pw.getJudul());

        }
    }

}
