package com.alimuntung.parbaya.presenter;

import com.alimuntung.parbaya.contractor.WisataContract;
import com.alimuntung.parbaya.interactor.WisataInteractorImpl;
import com.alimuntung.parbaya.model.Pariwisata;
import com.alimuntung.parbaya.model.PariwisataDB;

import java.util.ArrayList;

public class PariwisataPresenter implements WisataContract.Presenter, WisataContract.onOperationListener{
    private WisataContract.WisataView view;
    private PariwisataDB pwd = new PariwisataDB(this);
    private WisataInteractorImpl interactor;

    public PariwisataPresenter(WisataContract.WisataView view){
        this.view = view;
        interactor = new WisataInteractorImpl(this);
    }
    // Lingga Juliansyah
// IF-7
// 10119294
    @Override
    public void onLoadWisata() {
        interactor.showWisata(pwd);
    }

    @Override
    public void onSubmit(Pariwisata pws) {
        interactor.storeWisata(pws,pwd);
    }

    @Override
    public void onSuccess() {
        view.showMessage();
    }

    @Override
    public void onFailure() {
        view.showMessage();
    }

    @Override
    public void onStart() {
        view.showProgress();
    }

    @Override
    public void onEnd() {
        view.hideProgress();
    }

    @Override
    public void onRead(ArrayList<Pariwisata> pariwisatas) {
        view.showListWisata(pariwisatas);
    }
}
