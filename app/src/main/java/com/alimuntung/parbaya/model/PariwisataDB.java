package com.alimuntung.parbaya.model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alimuntung.parbaya.contractor.WisataContract;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.function.Function;

public class PariwisataDB {
    private DatabaseReference databaseReference;
    private WisataContract.onOperationListener listener;
    private ArrayList<Pariwisata> listPariwisata;
    public PariwisataDB(WisataContract.onOperationListener listener){
      FirebaseDatabase db = FirebaseDatabase.getInstance();
      databaseReference = db.getReference(Pariwisata.class.getSimpleName());
      this.listener = listener;
    }
    public Task<Void> add(Pariwisata pariwisata)
    {
      databaseReference.push().setValue(pariwisata);
      return null;
    }

    public void storePariwisata(Pariwisata pws){
        databaseReference.push().setValue(pws).addOnCompleteListener(new OnCompleteListener<Void>(){
           @Override
           public void onComplete(@NonNull Task<Void> task) {
               if(task.isSuccessful())
               {
                   Log.i("SUCESS","Sucess insert");
               }
               else
               {
                    Log.i("FAILED",task.getException().getMessage());
               }
           }
        });
    }

    public void readPariwisata(){
        listener.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Pariwisata pws = snapshot.getValue(Pariwisata.class);
                listPariwisata.add(pws);
                listener.onRead(listPariwisata);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                listener.onFailure();
            }
        });
        listener.onSuccess();
        listener.onEnd();
//        databaseReference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                Pariwisata pws = snapshot.getValue(Pariwisata.class);
//                listPariwisata.add(pws);
//                listener.onRead(listPariwisata);
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }
}
