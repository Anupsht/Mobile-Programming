package com.bca.mp_lab_reports.Lab5;


import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bca.mp_lab_reports.Lab.GeneralUtil;
import com.bca.mp_lab_reports.R;


public class GridViewMain extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();

        ActionBar bar = getSupportActionBar();
        if (bar != null) bar.hide();
    }

    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.lab5_grid_view_main);

        Resources res = getResources();

        GridView gridView = findViewById(R.id.gridViewMainList);
        ViewGroup rootLayout = findViewById(R.id.gridViewMainRoot);

        String[] pokemonList = res.getStringArray(R.array.custom_image_list);

        ArrayAdapter<String> pokemonAdapter = new ArrayAdapter<>(
                this,
                R.layout.lab5_spinner_item,
                R.id.spinnerItemText,
                pokemonList
        );

        gridView.setAdapter(pokemonAdapter);

        gridView.setOnItemClickListener((list, v, position, id) -> {
            String close = "Okay";
            Adapter listAdapter = list.getAdapter();
            String value = listAdapter.getItem(position).toString();
            String message = value + " at position " + position + " with id " + id;
            GeneralUtil.showMySnack(rootLayout, message, close);
        });
    }
}