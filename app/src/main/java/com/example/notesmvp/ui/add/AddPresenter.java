package com.example.notesmvp.ui.add;

import com.example.notesmvp.data.db.model.Note;

public class AddPresenter implements AddContract.Presenter, AddInteractor.onAddListener {
    private AddContract.View view;
    private AddInteractor interactor;

    public AddPresenter(AddContract.View view) {
        this.view = view;
        this.interactor = new AddInteractorImpl(this);
    }

    @Override
    public void addNote(String titulo, String fecha) {
        interactor.addNote(titulo, fecha);
    }

    @Override
    public void onSuccess(long id) {
        view.showAddNote();
    }

    @Override
    public void onError() {

    }
}
