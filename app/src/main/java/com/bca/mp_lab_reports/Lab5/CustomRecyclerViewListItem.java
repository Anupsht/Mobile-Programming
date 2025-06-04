package com.bca.mp_lab_reports.Lab5;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bca.mp_lab_reports.Lab.GeneralUtil;
import com.bca.mp_lab_reports.R;
import java.util.ArrayList;
public class CustomRecyclerViewListItem extends RecyclerView.Adapter<RecyclerItemHolder> {
    Activity ctx;
    ArrayList<AlbumDetail> data;
    public CustomRecyclerViewListItem(Activity context, ArrayList<AlbumDetail> d){
        this.data = d;
        this.ctx = context;
    }
    @NonNull
    @Override
    public RecyclerItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View listItem = layoutInflater.inflate(R.layout.lab5_custom_list_item, parent, false);
        return new RecyclerItemHolder(listItem, R.id.customListItemRoot, R.id.customListItemTitle, R.id.customListItemImage, R.id.customListItemDescription);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerItemHolder holder, int position) {
        AlbumDetail albumDetail = data.get(position);
        holder.imageView.setImageResource(albumDetail.getImage());
        holder.titleView.setText(albumDetail.getTitle());
        holder.descriptionView.setText(albumDetail.getDescription());
        holder.rootView.setOnClickListener(v ->{
            String close = "Begone";
            String message = albumDetail.getTitle();
            GeneralUtil.showMySnack(holder.rootView,message,close);
        });
        holder.imageView.setOnClickListener(v-> Toast.makeText(ctx,
                String.valueOf(albumDetail.getImage()), Toast.LENGTH_SHORT).show());

    }
    @Override
    public int getItemCount() {
        return data.size();
    }
}
