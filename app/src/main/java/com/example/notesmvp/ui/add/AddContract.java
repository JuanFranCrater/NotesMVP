package com.example.notesmvp.ui.add;

import com.example.notesmvp.data.db.model.Note;

public interface AddContract {

    interface View{
        void showAddNote();
    }

    interface Presenter{
        void addNote(String titulo, String fecha);
    }
}
