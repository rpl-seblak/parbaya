package com.alimuntung.parbaya.contractor;

import com.alimuntung.parbaya.model.Pariwisata;
import com.alimuntung.parbaya.model.PariwisataDB;

import java.util.ArrayList;

public class WisataContract {
    public interface WisataView {
        void showProgress();
        void hideProgress();
        void showListWisata(ArrayList<Pariwisata> pariwisatas);
        void showMessage();
    }

    public interface Interactor{
        void storeWisata(Pariwisata pws, PariwisataDB db);
        void showWisata(PariwisataDB db);
    }

    public interface Presenter{
        void onLoadWisata();
        void onSubmit(Pariwisata pws);
    }

    public interface onOperationListener{
        void onSuccess();
        void onFailure();
        void onStart();
        void onEnd();
        void onRead(ArrayList<Pariwisata> pariwisatas);
    }
}
