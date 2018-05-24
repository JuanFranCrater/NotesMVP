package com.example.notesmvp.ui;

import com.example.notesmvp.data.db.model.Note;

import java.util.ArrayList;

public interface NotesInteractor {
    void getNotes();

    interface onLoadListener{
        void onDatabaseError();
        void onSucces(ArrayList<Note> notes);
    }
}
