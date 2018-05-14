package com.example.notesmvp.ui;

import com.example.notesmvp.data.db.model.Note;
import com.example.notesmvp.ui.base.NotesContract;

import java.util.ArrayList;

public class NotesPresenter implements NotesContract.Presenter, NotesInteractor.onLoadListener {
    private NotesContract.View view;
    private NotesInteractor interactor;

    public NotesPresenter(NotesContract.View view) {
        this.view = view;
        this.interactor = new NotesInteractorImpl(this);
    }

    public void loadNotes(){
        interactor.getNotes();
    }

    @Override
    public void onDatabaseError() {

    }

    @Override
    public void onSucces(ArrayList<Note> notes) {
        view.showNotes(notes);
    }
}
