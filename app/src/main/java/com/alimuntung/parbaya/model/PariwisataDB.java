package com.alimuntung.parbaya.model;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
}
