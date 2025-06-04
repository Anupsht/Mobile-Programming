package com.bca.mp_lab_reports.Lab5;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
public class RecyclerItemHolder extends RecyclerView.ViewHolder {
    ViewGroup rootView;
    ImageView imageView;
    TextView titleView, descriptionView;
    public RecyclerItemHolder(View v, int r, int t, int i, int d){
        super(v);
        rootView = v.findViewById(r);
        titleView = v.findViewById(t);
        imageView = v.findViewById(i);
        descriptionView = v.findViewById(d);
    }
}
