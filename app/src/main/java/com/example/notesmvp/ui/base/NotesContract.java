package com.example.notesmvp.ui.base;

import com.example.notesmvp.data.db.model.Note;

import java.util.ArrayList;

public interface NotesContract {

    interface View{
        void showNotes(ArrayList<Note> notes);
    }

    interface Presenter{
        void loadNotes();
    }
}
