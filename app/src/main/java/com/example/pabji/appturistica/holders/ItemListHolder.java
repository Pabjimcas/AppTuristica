package com.example.pabji.appturistica.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pabji.appturistica.R;
import com.example.pabji.appturistica.models.Destination;
import com.squareup.picasso.Picasso;

/**
 * Created by pabji on 01/06/2016.
 */
public class ItemListHolder extends RecyclerView.ViewHolder {

    private final ImageView imageItem;
    private final TextView nameItem;
    private final Context mContext;

    public ItemListHolder(Context context,View itemView) {
        super(itemView);
        imageItem = (ImageView) itemView.findViewById(R.id.image_item);
        nameItem = (TextView)itemView.findViewById(R.id.name_item);
        mContext = context;
    }

    public void bindItem(Destination item) {
        nameItem.setText(item.getName());
        Picasso.with(mContext).load(item.getImage_url()).fit().centerCrop().into(imageItem);
    }
}
