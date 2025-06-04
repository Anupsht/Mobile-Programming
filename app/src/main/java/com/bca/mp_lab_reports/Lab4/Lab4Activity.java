package com.bca.mp_lab_reports.Lab4;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.bca.mp_lab_reports.R;
public class Lab4Activity extends AppCompatActivity {
    Button btnHome, btnProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab4);
        btnHome = findViewById(R.id.btnHome);
        btnProfile = findViewById(R.id.btnProfile);
        // Load default fragment
        loadFragment(new HomeFragment());
        btnHome.setOnClickListener(v -> loadFragment(new HomeFragment()));
        btnProfile.setOnClickListener(v -> loadFragment(new ProfileFragment()));
    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lab4_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            showSettingsDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showSettingsDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Settings")
                .setMessage("Settings clicked!")
                .setPositiveButton("OK", null)
                .show();
    }
}
