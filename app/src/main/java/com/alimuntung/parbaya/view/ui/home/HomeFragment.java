package com.alimuntung.parbaya.view.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.alimuntung.parbaya.R;
import com.alimuntung.parbaya.adapter.NearbyWisataAdapter;
import com.alimuntung.parbaya.contractor.WisataContract;
import com.alimuntung.parbaya.databinding.FragmentHomeBinding;
import com.alimuntung.parbaya.model.Pariwisata;
import com.alimuntung.parbaya.model.PariwisataDB;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private WisataContract wisataContract;
    private List<Pariwisata> nearbyPariwisataList;
    private PariwisataDB pariwisataDB;
    private NearbyWisataAdapter nearbyWisataAdapter;
    private RecyclerView rvPariwisata;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nearbyPariwisataList = new ArrayList<>();
        rvPariwisata = getView().findViewById(R.id.rvPariwisata);
        read();

        }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void read(){


    }
}