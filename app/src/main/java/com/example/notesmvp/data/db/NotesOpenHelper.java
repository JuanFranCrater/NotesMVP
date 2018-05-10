package com.example.notesmvp.data.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.notesmvp.ui.NotesApplication;

public class NotesOpenHelper extends SQLiteOpenHelper {
    private SQLiteDatabase sqLiteDatabase;
    private static NotesOpenHelper singleton;

    private NotesOpenHelper() {
        super(NotesApplication.getContext(), NoteContract.DATABASE_NAME, null, NoteContract.DATABASE_VERSION);
    }

    public static NotesOpenHelper getInstance(){
        if (singleton == null){
            singleton = new NotesOpenHelper();
        }
        return singleton;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.beginTransaction();
            db.execSQL(NoteContract.NoteEntry.SQL_CREATE_ENTRIES);
            db.execSQL(NoteContract.NoteEntry.SQL_INSERT_ENTRIES);
            db.setTransactionSuccessful();
        }catch (SQLiteException e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(NoteContract.NoteEntry.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public SQLiteDatabase openDatabase(){
        sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase;
    }

    public void closeDatabase(){
        sqLiteDatabase.close();
    }
}
