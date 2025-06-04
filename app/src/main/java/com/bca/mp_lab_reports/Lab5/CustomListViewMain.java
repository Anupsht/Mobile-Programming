package com.bca.mp_lab_reports.Lab5;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import com.bca.mp_lab_reports.R;
import com.bca.mp_lab_reports.Lab.GeneralUtil;

import java.util.List;

public class CustomListViewMain extends AppCompatActivity {
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


        String[] titleList = res.getStringArray(R.array.custom_image_list);
        String[] descriptionList = res.getStringArray(R.array.custom_description_list);
        int[] imageList = {R.drawable.pikachu, R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i};


        CustomListItem customAdapter = new CustomListItem(this, titleList,descriptionList,imageList);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View v, int position, long id) {
                String close = "Okay";
                Adapter listAdapter = list.getAdapter();
                String value = listAdapter.getItem(position).toString();
                String message = value + "at position" + (position + 1) + "With id" + (id + 1);

                GeneralUtil.showMySnack(rootLayout,message,close);

            }
        });


    }
}
