package com.bca.mp_lab_reports.Lab2;

import android.app.Activity;
import android.os.Bundle;
import com.bca.mp_lab_reports.R;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Lab2Linear extends Activity {

        private EditText inputName;
        private RadioGroup genderGroup;
        private RadioButton radioMale, radioFemale;
        private CheckBox termsCheckBox;
        private Button btnGreet;
        private TextView textGreeting;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.linearlayout); // link your XML layout here

            // Initialize UI components
            inputName = findViewById(R.id.inputName);
            genderGroup = findViewById(R.id.genderGroup);
            radioMale = findViewById(R.id.radioMale);
            radioFemale = findViewById(R.id.radioFemale);
            termsCheckBox = findViewById(R.id.termsCheckBox);
            btnGreet = findViewById(R.id.btnGreet);
            textGreeting = findViewById(R.id.textGreeting);

            // Set button click listener
            btnGreet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleGreetButton();
                }
            });
        }

        private void handleGreetButton() {
            String name = inputName.getText().toString().trim();

            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
                return;
            }

            // Check gender selection
            int selectedGenderId = genderGroup.getCheckedRadioButtonId();
            if (selectedGenderId == -1) {
                Toast.makeText(this, "Please select a gender", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!termsCheckBox.isChecked()) {
                Toast.makeText(this, "Please agree to the terms", Toast.LENGTH_SHORT).show();
                return;
            }

            String gender = selectedGenderId == R.id.radioMale ? "Mr." : "Ms.";
            String greeting = "Hello, " + " " + name + "! 👋";
            textGreeting.setText(greeting);
        }
    }

