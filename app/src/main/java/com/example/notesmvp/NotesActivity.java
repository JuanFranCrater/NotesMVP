package com.example.notesmvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notesmvp.adapter.NotesAdapter;
import com.example.notesmvp.data.db.model.Note;
import com.example.notesmvp.ui.NotesPresenter;
import com.example.notesmvp.ui.add.NotesAddActivity;
import com.example.notesmvp.ui.base.BaseActivity;
import com.example.notesmvp.ui.base.NotesContract;

import java.util.ArrayList;

public class NotesActivity extends BaseActivity implements NotesAdapter.OnItemClickListener, NotesContract.View {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private NotesPresenter presenter;
    private TextView tvNotasVacio;
    private FloatingActionButton fabAddNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        tvNotasVacio = findViewById(R.id.tvNotasEmpty);
        recyclerView = findViewById(R.id.rvListNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotesAdapter(this);
        recyclerView.setAdapter(adapter);
        presenter = new NotesPresenter(this);
        presenter.loadNotes();

        fabAddNotes = findViewById(R.id.fabMainActivity);
        fabAddNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotesActivity.this, NotesAddActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemCLick(Note note) {
        Toast.makeText(this, "Nota pulsada: "+note.getTitle(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNotes(ArrayList<Note> notes) {
        adapter = new NotesAdapter(this, notes);
        recyclerView.setAdapter(adapter);
        toogleEmptyNotes();
    }

    private void toogleEmptyNotes() {
        if (adapter.getItemCount() > 0){
            tvNotasVacio.setVisibility(View.INVISIBLE);
        }else{
            tvNotasVacio.setVisibility(View.VISIBLE);
        }
    }
}
