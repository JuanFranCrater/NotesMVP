package com.example.notesmvp.data.db;


import android.provider.BaseColumns;

/**
 * Clase con constantes para la creacion de la db
 */
public final class NoteContract {
    private NoteContract(){
    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "notes.db";

    //Clase que implementa la interfaz basecolumns por cada tabla

    public static class NoteEntry implements BaseColumns{
        public static final String TABLE_NAME = "notes";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String[] ALL_COLUMN = {BaseColumns._ID, COLUMN_TITLE, COLUMN_TIMESTAMP};

        //Constantes de sentencias de la tabla
        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT)",TABLE_NAME, BaseColumns._ID, COLUMN_TITLE, COLUMN_TIMESTAMP);

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s VALUES(1, 'Aprobar algo', '07/06/2018 - 12:00'),(2, 'Hacer el proyecto', '07/06/2018 - 12:00')", TABLE_NAME);

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);



        //Hacer con fecha como date
        //public static final String CREATE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s DATE DEFAULT(datetime)");
    }
}
