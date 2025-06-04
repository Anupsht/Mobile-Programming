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

        TextView headingText = findViewById(R.id.helloHeadingText);
        Button submitButton = findViewById(R.id.helloSubmitButton);
        EditText fullNameInput = findViewById(R.id.helloFullNameInput);
        Button cancelButton = findViewById(R.id.helloCancelButton);

        submitButton.setOnClickListener(v ->{
            String inputValue = fullNameInput.getText().toString();
            if (inputValue.isEmpty()) {
                headingText.setText(R.string.na);
            }else {
                headingText.setText(inputValue);
            }
        });

        submitButton.setOnClickListener(v -> {
            Intent i = new Intent(Contact.this, About.class);


            i.putExtra("gender","Male" );
            i.putExtra("country","Nepal");
            i.putExtra("fullname", "Anup Shrestha");
            i.putStringArrayListExtra("sports", new ArrayList<>(Arrays.asList("Football","BasketBall","Tennis")));

            startActivity(i);
        });

        // Sending result back to the previous activity
        cancelButton.setOnClickListener(v -> {
            String sendBackData = fullNameInput.getText().toString();

            if(sendBackData.isEmpty()) sendBackData = "Default Value";

            Intent i = new Intent();
            i.putExtra("contactData", sendBackData);
            setResult(RESULT_OK, i);
            finish();
        });

    }



}
