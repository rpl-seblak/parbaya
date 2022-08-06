package com.alimuntung.parbaya.view.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alimuntung.parbaya.R;
import com.alimuntung.parbaya.adapter.NearbyWisataAdapter;
import com.alimuntung.parbaya.contractor.WisataContract;
import com.alimuntung.parbaya.databinding.FragmentHomeBinding;
import com.alimuntung.parbaya.model.Pariwisata;
import com.alimuntung.parbaya.presenter.PariwisataPresenter;
import com.alimuntung.parbaya.view.ui.PariwisataView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements WisataContract.WisataView, WisataContract.WisataListener {
    private PariwisataPresenter pwp;
    private FragmentHomeBinding binding;
    private List<Pariwisata> nearbyPariwisataList;
    private NearbyWisataAdapter nearbyWisataAdapter;
    private RecyclerView rvPariwisata;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPariwisata = getView().findViewById(R.id.rvPariwisata);
        pwp = new PariwisataPresenter(this);
        pwp.onLoadWisata();
        }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showListWisata(ArrayList<Pariwisata> pariwisatas) {
        nearbyPariwisataList = pariwisatas;
        nearbyWisataAdapter = new NearbyWisataAdapter(nearbyPariwisataList, this);
        rvPariwisata.setLayoutManager(new LinearLayoutManager(getContext()));
        rvPariwisata.setAdapter(nearbyWisataAdapter);
    }

    @Override
    public void showMessage() {

    }

    // Ikbar Laudza Alviansyah
// IF-7
// 10119260
    // 06-08-2022
    @Override
    public void onItemClicked(Pariwisata pariwisata) {
        Intent intent = new Intent(getActivity(), PariwisataView.class);
        intent.putExtra("wisata", pariwisata);
        startActivity(intent);
    }
}