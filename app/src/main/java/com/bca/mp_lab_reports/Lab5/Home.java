package com.bca.mp_lab_reports.Lab5;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.bca.mp_lab_reports.R;
public class Home extends AppCompatActivity {
    //    private Button dashButton;
    private ViewGroup rootLayout;
    @Override
    protected void onCreate( Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.lab5_home);
        rootLayout = findViewById(R.id.homeRoot);//
    }
    @Override
    protected void onStart() {
        super.onStart();
        //setting color of status bar
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        ActionBar bar = getSupportActionBar();
        if(bar != null){
            int color = ContextCompat.getColor(this, R.color.sky_blue);
            int textColor = ContextCompat.getColor(this, R.color.black);
            Spannable text = new SpannableString(getResources().getString(R.string.home));
            text.setSpan(new AbsoluteSizeSpan(20,true),0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            text.setSpan(new ForegroundColorSpan(textColor),0,text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            text.setSpan(new LeadingMarginSpan.Standard(20),0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            bar.setTitle(text);
            bar.setElevation(10);
            bar.setBackgroundDrawable(new ColorDrawable(color));
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_option, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String close = "Go Away";
        int selectedItem = item.getItemId();
        if (selectedItem == R.id.appOptionsListView){
            Intent i = new Intent(Home.this, ListViewMain.class);
            startActivity(i);
            Toast.makeText(this, "Hello World!!", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (selectedItem == R.id.appOptionsCustomGridView) {
            Intent i = new Intent(Home.this, CustomGridViewMain.class);
            startActivity(i);
            return true;
        }
        else if (selectedItem == R.id.appOptionsRecyclerListView) {
            Intent i = new Intent(Home.this, RecyclerViewListMain.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
