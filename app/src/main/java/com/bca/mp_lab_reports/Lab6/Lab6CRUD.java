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
            String name = nameInput.getText().toString().trim();
            String course = courseInput.getText().toString().trim();

            if (name.isEmpty() || course.isEmpty()) {
                Toast.makeText(this, "Please enter both name and course", Toast.LENGTH_SHORT).show();
                return;

            }

            boolean inserted = db.insertStudent(name, course);
            if (inserted) {
                Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
                nameInput.setText("");
                courseInput.setText("");
            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
            if (inserted) refreshStudentList();
        });

        updateBtn.setOnClickListener(v -> {
            String idText = idInput.getText().toString().trim();
            if (idText.isEmpty()) {
                Toast.makeText(this, "Enter ID to update", Toast.LENGTH_SHORT).show();
                return;
            }
            boolean updated = db.updateStudent(Integer.parseInt(idText),
                    nameInput.getText().toString(), courseInput.getText().toString());
            Toast.makeText(this, updated ? "Updated" : "Failed", Toast.LENGTH_SHORT).show();
            if (updated) refreshStudentList();
        });

        deleteBtn.setOnClickListener(v -> {
            String idText = idInput.getText().toString().trim();
            if (idText.isEmpty()) {
                Toast.makeText(this, "Enter ID to delete", Toast.LENGTH_SHORT).show();
                return;
            }
            boolean deleted = db.deleteStudent(Integer.parseInt(idText));
            Toast.makeText(this, deleted ? "Deleted" : "Failed", Toast.LENGTH_SHORT).show();
            if (deleted) refreshStudentList();
        });

        viewBtn.setOnClickListener(v -> refreshStudentList());

        viewBtn.setOnClickListener(v -> {
            Cursor c = db.getAllStudents();
            ArrayList<String> students = new ArrayList<>();
            while (c.moveToNext()) {
                students.add(c.getInt(0) + ": " + c.getString(1) + " - " + c.getString(2));
            }
            c.close();  // Don't forget to close the cursor!

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);
            studentList.setAdapter(adapter);
        });





    }

    private void refreshStudentList() {
        Cursor c = db.getAllStudents();
        ArrayList<String> students = new ArrayList<>();
        while (c.moveToNext()) {
            students.add(c.getInt(0) + ": " + c.getString(1) + " - " + c.getString(2));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);
        studentList.setAdapter(adapter);
    }
}
