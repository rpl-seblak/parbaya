package com.alimuntung.parbaya.contractor;

import com.alimuntung.parbaya.model.Pariwisata;
import com.alimuntung.parbaya.model.PariwisataDB;

import java.util.ArrayList;

public class WisataContract {
    /* MVP createdby
     * NIM : 10119294
     * NAMA : Lingga Juliansyah
     * Kelas : IF-7
     * // 06-08-2022
     * */
    public interface WisataView {
        void showProgress();
        void hideProgress();
        void showListWisata(ArrayList<Pariwisata> pariwisatas);
        void showMessage();
    }

    public interface WisataListener {
        void onItemClicked(Pariwisata pariwisata);
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
