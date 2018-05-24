package com.example.notesmvp.ui.add;

import com.example.notesmvp.data.db.model.Note;

public interface AddInteractor {
    void addNote(String titulo, String fecha);

    interface onAddListener {
        void onSuccess(long id);
        void onError();
    }

}
