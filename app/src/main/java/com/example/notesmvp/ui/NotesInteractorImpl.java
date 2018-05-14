package com.example.notesmvp.ui;

import com.example.notesmvp.data.db.model.Note;
import com.example.notesmvp.data.db.repository.NoteRepository;

import java.util.ArrayList;

class NotesInteractorImpl implements NotesInteractor {
    private NotesInteractor.onLoadListener listener;
    public NotesInteractorImpl(NotesInteractor.onLoadListener listener) {
        this.listener = listener;
    }

    @Override
    public void getNotes() {
        ArrayList<Note> notes = NoteRepository.getInstance().getNotes();
        listener.onSucces(notes);
    }
}
