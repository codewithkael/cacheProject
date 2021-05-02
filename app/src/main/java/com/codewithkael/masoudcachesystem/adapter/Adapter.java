package com.codewithkael.masoudcachesystem.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewithkael.masoudcachesystem.R;


public class Adapter extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;



    public Adapter(@NonNull View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.itemImageview);
        textView = (TextView) itemView.findViewById(R.id.itemId);
    }
}
