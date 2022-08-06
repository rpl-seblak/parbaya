package com.alimuntung.parbaya.interactor;

import com.alimuntung.parbaya.contractor.WisataContract;
import com.alimuntung.parbaya.model.Pariwisata;
import com.alimuntung.parbaya.model.PariwisataDB;

public class WisataInteractorImpl implements WisataContract.Interactor {
    private WisataContract.onOperationListener listener;

    public WisataInteractorImpl(WisataContract.onOperationListener listener) {
        this.listener = listener;
    }

    @Override
    public void storeWisata(Pariwisata pws, PariwisataDB db) {
        listener.onStart();
        db.storePariwisata(pws);
        listener.onEnd();
        listener.onSuccess();
    }
    // Lingga Juliansyah
// IF-7
// 10119294
    // 06-08-2022
    @Override
    public void showWisata(PariwisataDB db) {
        db.readPariwisata();
    }
}
