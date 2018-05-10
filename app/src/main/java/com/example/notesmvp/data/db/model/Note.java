package com.example.notesmvp.data.db.model;

public class Note {
    private int id;
    private String title;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Note(int id, String title, String time) {
        this.id = id;
        this.title = title;
        this.time = time;
    }

    public Note(String title) {
        this.title = title;
    }
}
