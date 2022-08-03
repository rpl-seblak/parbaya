package com.alimuntung.parbaya.contractor;

import com.alimuntung.parbaya.model.Pariwisata;
import com.alimuntung.parbaya.model.PariwisataDB;

public class WisataContract {
    public interface WisataView {
        void showProgress();
        void hideProgress();
        void showListWisata();
        void showMessage();
    }

    public interface Interactor{
        void storeWisata(Pariwisata pws, PariwisataDB db);
        void showWisata();
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
    }
}
