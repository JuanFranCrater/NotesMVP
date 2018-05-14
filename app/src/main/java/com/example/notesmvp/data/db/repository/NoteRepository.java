package com.example.notesmvp.data.db.repository;

import com.example.notesmvp.data.db.dao.NoteDao;
import com.example.notesmvp.data.db.model.Note;

import java.util.ArrayList;

public class NoteRepository {
    private static NoteRepository noteRepository;
    private NoteDao noteDao;

    private NoteRepository() {
        this.noteDao = new NoteDao();
    }

    public static NoteRepository getInstance(){
        if (noteRepository == null){
            noteRepository = new NoteRepository();
        }
        return noteRepository;
    }

    public ArrayList<Note> getNotes() {
        return noteDao.loadAll();
    }
}
