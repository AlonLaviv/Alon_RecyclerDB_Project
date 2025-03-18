package com.example.alon_recyclerdb_project;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    EditText nameTextView;
    EditText lastNameTextView;
    EditText adressTextView;
    EditText phoneTextView;
    Button button;
    List<Note> noteList;
    NoteDAO noteDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int how_big = 20;
        List<DataItem> dataList = new ArrayList<>();
        for (int i = 0; i < how_big; i++) dataList.add(new DataItem("item"+(i+1)));
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(dataList,this);
        recyclerView.setAdapter(adapter);
        ////
        NoteDatabase database = NoteDatabase.getInstance(this);
        noteDAO = database.noteDao();
        nameTextView = findViewById(R.id.editTextName);
        lastNameTextView = findViewById(R.id.editTextTextLastName);
        adressTextView = findViewById(R.id.editTextTextAdress);
        phoneTextView = findViewById(R.id.editTextTextPhone);
        button = findViewById(R.id.buttonAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteList = noteDAO.getAllNotes();
                noteDAO.insert(new Note(nameTextView.getText().toString(),lastNameTextView.getText().toString(),adressTextView.getText().toString(),phoneTextView.getText().toString()));


            }
        });
    }







}
