package com.example.notesmvp.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.notesmvp.R;

public class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.tbNotesActivity);
        setSupportActionBar(toolbar);
    }
}
