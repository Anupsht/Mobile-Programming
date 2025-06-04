package com.bca.mp_lab_reports.Lab5;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.bca.mp_lab_reports.Lab.GeneralUtil;
import com.bca.mp_lab_reports.R;
public class ListViewMain extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        ActionBar bar = getSupportActionBar();
        if(bar != null) bar.hide();
    }
    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.lab5_list_view_main);
        Resources res = getResources();
        ListView listView = findViewById(R.id.ListViewMainList);
        ViewGroup rootLayout = findViewById(R.id.listViewMainRoot);
        String[] pokemonList = res.getStringArray(R.array.custom_image_list);
        ArrayAdapter<String> pokemonAdapter = new ArrayAdapter<>(this, R.layout.lab5_spinner_item, R.id.spinnerItemText, pokemonList);
        listView.setAdapter(pokemonAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View v, int position, long id) {
                String close = "okay";
                Adapter listAdapter = list.getAdapter();
                String value = listAdapter.getItem(position).toString();
                String message = value + "at position" + position + "with id" + id;
                GeneralUtil.showMySnack(rootLayout,message,close);
            }
        });
    }
}
