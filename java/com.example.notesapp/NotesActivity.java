package com.example.notesapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NotesActivity extends AppCompatActivity {
    EditText enter_date,enter_note;
    Button button_notesave;
    DatabaseReference reference;
    Notes notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        enter_date=findViewById(R.id.enter_date);
        enter_note=findViewById(R.id.enter_note);
        button_notesave=findViewById(R.id.button_notesave);
        reference= FirebaseDatabase.getInstance().getReference().child("Notes");
        notes=new Notes();
        button_notesave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes.setDate(enter_date.getText().toString().trim());
                notes.setNotes(enter_note.getText().toString().trim());
                reference.push().setValue(notes);
                Toast.makeText(NotesActivity.this,"Saved successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
}
