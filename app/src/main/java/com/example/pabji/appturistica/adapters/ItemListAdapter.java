package com.example.pabji.appturistica.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pabji.appturistica.R;
import com.example.pabji.appturistica.holders.ItemListHolder;
import com.example.pabji.appturistica.models.DataModel;
import com.example.pabji.appturistica.models.Destination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by pabji on 01/06/2016.
 */
public class ItemListAdapter extends RecyclerView.Adapter<ItemListHolder> {

    private final Context mContext;
    private DataModel data;
    private List<Destination> randomList;

    public ItemListAdapter(Context context,DataModel data) {
        this.data = data;
        mContext = context;
        randomList = new ArrayList<Destination>();
        randomList.addAll(data.getTrips());
        randomList.addAll(data.getDestinations());
        long seed = System.nanoTime();
        Collections.shuffle(randomList, new Random(seed));
    }

    @Override
    public ItemListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ItemListHolder(mContext,view);
    }

    @Override
    public void onBindViewHolder(ItemListHolder holder, int position) {
        holder.bindItem(randomList.get(position));
    }

    @Override
    public int getItemCount() {
        return randomList.size();
    }
}
