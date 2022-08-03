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
        db.storePariwisata(pws);
        listener.onStart();
        listener.onSuccess();
    }

    @Override
    public void showWisata() {

    }
}
