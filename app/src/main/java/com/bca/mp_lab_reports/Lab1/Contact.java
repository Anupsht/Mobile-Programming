package com.bca.mp_lab_reports.Lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.bca.mp_lab_reports.R;
import java.util.ArrayList;
import java.util.Arrays;

public class Contact extends Activity {
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.lab1);
        Button submitButton = findViewById(R.id.helloSubmitButton);
        EditText fullNameInput = findViewById(R.id.helloFullNameInput);
        submitButton.setOnClickListener(v -> {
            String inputValue = fullNameInput.getText().toString();
            Intent i = new Intent(Contact.this, About.class);
            i.putExtra("gender", "Male");
            i.putExtra("country", "Nepal");
            i.putExtra("fullname", inputValue); // Send user input instead of hardcoded name
            i.putStringArrayListExtra("sports", new ArrayList<>(Arrays.asList("COC", "PUBG", "FreeFire","CandyCross")));
            startActivity(i);
        });

    }
}
