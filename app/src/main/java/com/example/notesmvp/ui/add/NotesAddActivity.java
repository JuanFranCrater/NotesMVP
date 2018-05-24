package com.example.notesmvp.ui.add;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notesmvp.R;
import com.example.notesmvp.data.db.model.Note;

public class NotesAddActivity extends AppCompatActivity implements AddContract.View {
    private AddPresenter presenter;


    private Toolbar toolbar;
    private FloatingActionButton fabAddNota;
    private EditText etTituloNota;
    private EditText etFechaNota;

<<<<<<< HEAD
    //La toolbar se referencia en base
=======
>>>>>>> 916f74eb31d36afd9d3979e93abc706bc3b3b0fe
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_add);

        toolbar = findViewById(R.id.tbNotesActivity);
        setSupportActionBar(toolbar);

        etFechaNota = findViewById(R.id.etTimeStampNota);
        etTituloNota = findViewById(R.id.etTituloNota);

        presenter = new AddPresenter(this);

        fabAddNota = findViewById(R.id.fabAddNota);
        fabAddNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etFechaNota.getText().toString().isEmpty() && !etTituloNota.getText().toString().isEmpty()) {
                    presenter.addNote(etTituloNota.getText().toString(), etFechaNota.getText().toString());
                }
            }
        });
    }

    @Override
    public void showAddNote() {
        Toast.makeText(this, "Nota añadida con exito", Toast.LENGTH_LONG).show();
    }
}
