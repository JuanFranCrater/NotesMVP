package com.example.notesmvp.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.notesmvp.data.db.NoteContract;
import com.example.notesmvp.data.db.NotesOpenHelper;
import com.example.notesmvp.data.db.model.Note;


import java.util.ArrayList;

public class NoteDao {

    public ArrayList<Note> loadAll(){
        SQLiteDatabase sqLiteDatabase = NotesOpenHelper.getInstance().openDatabase();
        ArrayList<Note> aux = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(NoteContract.NoteEntry.TABLE_NAME, NoteContract.NoteEntry.ALL_COLUMN,
                null, null,null, null, null);
        if (cursor.moveToFirst()){
            do {
                aux.add(new Note(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            }while (cursor.moveToNext());
        }

        NotesOpenHelper.getInstance().closeDatabase();

        return aux;
    }

    //Metodo que añade una nota a la base de datos.
    public long addNote(String titulo, String fecha){
        SQLiteDatabase sqLiteDatabase = NotesOpenHelper.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        long id;

        values.put(NoteContract.NoteEntry.COLUMN_TITLE, titulo);
        values.put(NoteContract.NoteEntry.COLUMN_TIMESTAMP, fecha);

        id = sqLiteDatabase.insert(NoteContract.NoteEntry.TABLE_NAME, null, values);
        NotesOpenHelper.getInstance().closeDatabase();

        return id;
    }
}
