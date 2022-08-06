package com.alimuntung.parbaya.view.ui.maps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alimuntung.parbaya.R;
import com.alimuntung.parbaya.contractor.WisataContract;
import com.alimuntung.parbaya.model.Pariwisata;
import com.alimuntung.parbaya.presenter.PariwisataPresenter;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class fragment_maps_pariwisata extends Fragment implements WisataContract.WisataView {
    private FusedLocationProviderClient mFusedclient;
    private SupportMapFragment mapFragment;
    private Location lokasi;
    private List<Pariwisata> pariwisataList;
    private PariwisataPresenter pwp;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng curcloc = new LatLng(lokasi.getLatitude(),lokasi.getLongitude());
            googleMap.addMarker(new MarkerOptions().position(curcloc).title("Lokasi Anda Sekarang"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(curcloc,15f));

            for (int i=0; i<pariwisataList.size();i++){
                googleMap.addMarker(new MarkerOptions().position(
                        new LatLng(
                                pariwisataList.get(i).getLat(),
                                pariwisataList.get(i).getLng()
                        )).title(pariwisataList.get(i).getJudul()));
            }
            Log.i("testsukses", String.valueOf(pariwisataList.size()));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_maps_pariwisata, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFusedclient = LocationServices.getFusedLocationProviderClient(getActivity());
        mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            getLocation();
        }
        pwp = new PariwisataPresenter(this);
        pwp.onLoadWisata();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showListWisata(ArrayList<Pariwisata> pariwisatas) {
    pariwisataList = pariwisatas;
    }

    @Override
    public void showMessage() {

    }
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
        Task<Location> task = mFusedclient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location locationnow) {
                if(locationnow != null){
                    lokasi = locationnow;
                    mapFragment.getMapAsync(callback);
                }
            }
        });

    }
}