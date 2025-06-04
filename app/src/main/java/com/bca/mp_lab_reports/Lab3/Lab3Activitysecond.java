package com.bca.mp_lab_reports.Lab3;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bca.mp_lab_reports.R;
public class Lab3Activitysecond extends AppCompatActivity {
    TextView textViewGreeting, textViewDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab3_activitysecond);
        Log.d("Lifecycle", "SecondActivity - onCreate");
        textViewGreeting = findViewById(R.id.textViewGreeting);
        textViewDetails = findViewById(R.id.textViewDetails);
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String gender = getIntent().getStringExtra("gender");
        String city = getIntent().getStringExtra("city");
        String info = "Name: " + name + "\nEmail: " + email + "\nGender: " + gender + "\nCity: " + city;
        textViewDetails.setText(info);
    }
    // Lifecycle logs
    @Override protected void onStart() { super.onStart(); Log.d("Lifecycle", "SecondActivity - onStart"); }
    @Override protected void onResume() { super.onResume(); Log.d("Lifecycle", "SecondActivity - onResume"); }
    @Override protected void onPause() { super.onPause(); Log.d("Lifecycle", "SecondActivity - onPause"); }
    @Override protected void onStop() { super.onStop(); Log.d("Lifecycle", "SecondActivity - onStop"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.d("Lifecycle", "SecondActivity - onDestroy"); }
}
