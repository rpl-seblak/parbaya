package com.alimuntung.parbaya.adapter;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.alimuntung.parbaya.R;
import com.alimuntung.parbaya.contractor.WisataContract;
import com.alimuntung.parbaya.model.Pariwisata;
import com.bumptech.glide.Glide;


import org.w3c.dom.Text;

import java.util.List;

public class NearbyWisataAdapter extends RecyclerView.Adapter<NearbyWisataAdapter.NearbyWisataViewHolder> {

    private List<Pariwisata> nearbyPariwisataList;
    private WisataContract.WisataListener listener;

    public NearbyWisataAdapter(List<Pariwisata> nearbyPariwisataList, WisataContract.WisataListener listener){
        this.nearbyPariwisataList= nearbyPariwisataList;
        this.listener=listener;
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
        holder.setNearbyWisataData(nearbyPariwisataList.get(position),holder);
        Glide.with(holder.itemView.getContext()).load(nearbyPariwisataList.get(position).getUrl()).into(holder.iv_thumbnail);
    }

    @Override
    public int getItemCount(){
        return nearbyPariwisataList.size();
    }

    class NearbyWisataViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_judul;
        private CardView cv_wisata;
        private TextView tv_lokasi;
        private ImageView iv_thumbnail;
        public NearbyWisataViewHolder(@NonNull View itemView){
            super(itemView);
         tv_judul = itemView.findViewById(R.id.tvJudulwisata);
         cv_wisata = itemView.findViewById(R.id.cvWisata);
         tv_lokasi = itemView.findViewById(R.id.tvLokasiWisata);
         iv_thumbnail = itemView.findViewById(R.id.ivThumbnail);

        }
        // Ikbar Laudza Alviansyah
// IF-7
// 10119260
        void setNearbyWisataData(Pariwisata pw, NearbyWisataViewHolder view){
            tv_judul.setText(pw.getJudul());
            tv_lokasi.setText(pw.getAlamat());
            cv_wisata.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                listener.onItemClicked(pw);
                }
            });

            Log.i("test",pw.getUrl().toString());
        }
    }

}
