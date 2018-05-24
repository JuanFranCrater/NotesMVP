package com.example.notesmvp.ui.add;

import com.example.notesmvp.data.db.model.Note;
import com.example.notesmvp.data.db.repository.NoteRepository;

class AddInteractorImpl implements AddInteractor {

    private AddInteractor.onAddListener listener;

    public AddInteractorImpl(AddInteractor.onAddListener listener){
        this.listener = listener;
    }

    @Override
    public void addNote(String titulo, String fecha) {
        long id = NoteRepository.getInstance().addNote(titulo, fecha);
        listener.onSuccess(id);
    }
}
