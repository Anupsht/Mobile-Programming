package com.bca.mp_lab_reports.Lab5;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bca.mp_lab_reports.R;
public class CustomListItem extends ArrayAdapter<String> {
    int[] image;
    Activity ctx;
    String[] title;
    String[] description;
    public CustomListItem(Activity Context, String[] title, String[] description, int[] image){
        super(Context, R.layout.lab5_custom_list_item,title);
        this.ctx = Context;
        this.title = title;
        this.description= description;
        this.image = image;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View listItem, @NonNull ViewGroup parent) {
        ListItemHolder holder;
        if(listItem == null){
            LayoutInflater inflater = ctx.getLayoutInflater();
            //Inflate the layout
            listItem = inflater.inflate(R.layout.lab5_custom_list_item, parent, false);
            //Creating a new ViewHolder
            holder = new ListItemHolder();
            //find individual views and store in the ViewHolder
            holder.title = listItem.findViewById(R.id.customListItemTitle);
            holder.image = listItem.findViewById(R.id.customListItemImage);
            holder.description = listItem.findViewById(R.id.customListItemDescription);
            //Store the viewHolder within the view
            listItem.setTag(holder);
        } else holder = (ListItemHolder) listItem.getTag();
        //set relevant data to the widgets
        holder.title.setText(title[position]);
        holder.image.setImageResource(image[position]);
        holder.description.setText(description[position]);
        return listItem;
    }
}
