package com.example.notesmvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.notesmvp.R;
import com.example.notesmvp.data.db.model.Note;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesHolder> {
    private NotesAdapter.OnItemClickListener listener;
    private ArrayList<Note> noteArrayList;

    public interface OnItemClickListener{
        void onItemCLick(Note note);
        void onLongClick(Note note);

    }

    public NotesAdapter(NotesAdapter.OnItemClickListener listener) {
        this.listener = listener;
        noteArrayList = new ArrayList<Note>();
    }

    public NotesAdapter(NotesAdapter.OnItemClickListener listener, ArrayList<Note> notes) {
        this.listener = listener;
        this.noteArrayList = notes;
    }

    @Override
    public NotesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_item, parent, false);
        NotesHolder notesHolder = new NotesHolder(view);
        return notesHolder;
    }

    @Override
    public void onBindViewHolder(NotesHolder holder, int position) {
        holder.title.setText(noteArrayList.get(position).getTitle());
        holder.timeStamp.setText(noteArrayList.get(position).getTime());
        holder.bind(noteArrayList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    public static class NotesHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView timeStamp;

        public NotesHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitleNote);
            timeStamp = itemView.findViewById(R.id.tvTimeStampNote);
        }

        public void bind(final Note note, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemCLick(note);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onLongClick(note);
                    return true;
                }
            });
        }
    }
}
