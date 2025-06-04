package com.bca.mp_lab_reports.Lab6;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bca.mp_lab_reports.R;

import java.util.ArrayList;

public class Lab6CRUD extends AppCompatActivity {
    DBHelper db;
    EditText nameInput, courseInput, idInput;
    Button insertBtn, updateBtn, deleteBtn, viewBtn;
    ListView studentList;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.lab6_crud);
        db = new DBHelper(this);

        nameInput = findViewById(R.id.nameInput);
        courseInput = findViewById(R.id.courseInput);
        idInput = findViewById(R.id.idInput);
        insertBtn = findViewById(R.id.insertBtn);
        updateBtn = findViewById(R.id.updateBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        viewBtn = findViewById(R.id.viewBtn);
        studentList = findViewById(R.id.studentList);

        insertBtn.setOnClickListener(v -> {
            boolean inserted = db.insertStudent(nameInput.getText().toString(), courseInput.getText().toString());
            Toast.makeText(this, inserted ? "Inserted" : "Failed", Toast.LENGTH_SHORT).show();
        });

        updateBtn.setOnClickListener(v -> {
            boolean updated = db.updateStudent(Integer.parseInt(idInput.getText().toString()),
                    nameInput.getText().toString(), courseInput.getText().toString());
            Toast.makeText(this, updated ? "Updated" : "Failed", Toast.LENGTH_SHORT).show();
        });

        deleteBtn.setOnClickListener(v -> {
            boolean deleted = db.deleteStudent(Integer.parseInt(idInput.getText().toString()));
            Toast.makeText(this, deleted ? "Deleted" : "Failed", Toast.LENGTH_SHORT).show();
        });

        viewBtn.setOnClickListener(v -> {
            Cursor c = db.getAllStudents();
            ArrayList<String> students = new ArrayList<>();
            while (c.moveToNext()) {
                students.add(c.getInt(0) + ": " + c.getString(1) + " - " + c.getString(2));
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);
            studentList.setAdapter(adapter);
        });
    }
}
