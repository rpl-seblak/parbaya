package com.alimuntung.parbaya.model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.function.Function;

public class PariwisataDB {
    private DatabaseReference databaseReference;
    public PariwisataDB(){
      FirebaseDatabase db = FirebaseDatabase.getInstance();
      databaseReference = db.getReference(Pariwisata.class.getSimpleName());
    }
    public Task<Void> add(Pariwisata pariwisata)
    {
      databaseReference.push().setValue(pariwisata);
      return null;
    }

    public void storePariwisata(Pariwisata pws){
        databaseReference.child("pariwisata").setValue(pws).addOnCompleteListener(new OnCompleteListener<Void>(){
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
}
