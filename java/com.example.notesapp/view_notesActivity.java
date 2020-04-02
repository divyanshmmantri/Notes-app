package com.example.notesapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class view_notesActivity extends AppCompatActivity {
    ListView listViewNotes;
    DatabaseReference reference;
    List<Notes> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notes);
        listViewNotes=findViewById(R.id.listViewNotes);
        reference= FirebaseDatabase.getInstance().getReference().child("Notes");
        notesList=new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                notesList.clear();
                for(DataSnapshot notesSnapshot:dataSnapshot.getChildren()){
                    Notes notes=notesSnapshot.getValue(Notes.class);
                     notesList.add(notes);
                }
                Noteslist adapter=new Noteslist(view_notesActivity.this,notesList);
                listViewNotes.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
