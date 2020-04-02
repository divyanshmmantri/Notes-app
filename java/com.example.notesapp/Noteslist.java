package com.example.notesapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Noteslist extends ArrayAdapter<Notes> {
    private Activity context;
    private List<Notes> noteslist;
    public Noteslist(Activity context,List<Notes> noteslist)
    {
        super(context,R.layout.list_layout,noteslist);
        this.context=context;
        this.noteslist=noteslist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.list_layout,null,true);
        TextView textView_date=listViewItem.findViewById(R.id.textView_date);
        TextView textView_note=listViewItem.findViewById(R.id.textView_note);
        Notes notes=noteslist.get(position);
        textView_date.setText(notes.getDate());
        textView_note.setText(notes.getNotes());
        return  listViewItem;
    }
}
