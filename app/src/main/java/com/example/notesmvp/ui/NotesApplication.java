package com.example.notesmvp.ui;

import android.app.Application;
import android.content.Context;

import com.example.notesmvp.data.db.NotesOpenHelper;

public class NotesApplication extends Application {
    private static NotesApplication notesApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        NotesOpenHelper.getInstance().openDatabase();
    }

    public NotesApplication(){
        notesApplication = this;
    }

    public static Context getContext(){
        return notesApplication;
    }
    //Añadir al manifest al crear la clase
}
