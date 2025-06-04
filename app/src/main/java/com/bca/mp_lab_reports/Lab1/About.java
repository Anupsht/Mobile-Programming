package com.bca.mp_lab_reports.Lab1;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;


import com.bca.mp_lab_reports.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class About extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.about);
        TextView genderText = findViewById(R.id.aboutGenderValue);
        TextView countryText = findViewById(R.id.aboutCountryValue);
        TextView fullnameText = findViewById(R.id.aboutFullNameValue);
        TextView sportsText = findViewById(R.id.aboutSportsValue);
        Intent i = getIntent();
        String gender = i.getStringExtra("gender");
        String country = i.getStringExtra("country");
        String fullname = i.getStringExtra("fullname");
        ArrayList<String> sports = i.getStringArrayListExtra("sports");


        genderText.setText(gender);
        countryText.setText(country);

        if(fullname != null && !fullname.isEmpty()) fullnameText.setText(fullname);
        else fullnameText.setText("Anonymous");

        if(sports != null && !sports.isEmpty()){
            String joinedSports = String.join(", " ,sports);
            sportsText.setText(joinedSports);
        } else{
            Toast.makeText(getApplicationContext(), "No Sports found", Toast.LENGTH_SHORT).show();
            sportsText.setText("N/A");
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("myStateLog", "About - onStart ");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("myStateLog", "About: onResume");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("myStateLog", "About: onRestart");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("myStateLog", "About: onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("myStateLog", "About: onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("myStateLog", "About: onDestroy");
    }
}
