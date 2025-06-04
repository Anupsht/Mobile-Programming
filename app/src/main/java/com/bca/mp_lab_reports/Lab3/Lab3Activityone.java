package com.bca.mp_lab_reports.Lab3;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.bca.mp_lab_reports.R;
public class Lab3Activityone extends AppCompatActivity {
    EditText editTextName, editTextEmail;
    RadioGroup radioGroupGender;
    Spinner spinnerCity;
    Button buttonSubmit;
    String[] cities = {"Select City", "Kathmandu", "Bhaktapur", "Lalitpur", "Banepa",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab3_activityone);
        Log.d("Lifecycle", "MainActivity - onCreate");
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        spinnerCity = findViewById(R.id.spinnerCity);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(adapter);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String gender = ((RadioButton) findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
                String city = spinnerCity.getSelectedItem().toString();
                Intent intent = new Intent(Lab3Activityone.this, Lab3Activitysecond.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("gender", gender);
                intent.putExtra("city", city);
                startActivity(intent);
            }
        });
    }
    // Lifecycle logs
    @Override protected void onStart() { super.onStart(); Log.d("Lifecycle", "MainActivity - onStart"); }
    @Override protected void onResume() { super.onResume(); Log.d("Lifecycle", "MainActivity - onResume"); }
    @Override protected void onPause() { super.onPause(); Log.d("Lifecycle", "MainActivity - onPause"); }
    @Override protected void onStop() { super.onStop(); Log.d("Lifecycle", "MainActivity - onStop"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.d("Lifecycle", "MainActivity - onDestroy"); }
}
