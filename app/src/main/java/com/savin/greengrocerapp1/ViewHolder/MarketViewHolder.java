package com.savin.greengrocerapp1.ViewHolder;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.savin.greengrocerapp1.Interface.ItemClickListener;
import com.savin.greengrocerapp1.R;

public class MarketViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtMarketName;
    public ImageView imageView;

    private ItemClickListener itemClickListener;

    public MarketViewHolder(View itemView) {
        super(itemView);

        txtMarketName = (TextView)itemView.findViewById(R.id.Market_name);
        imageView = (ImageView)itemView.findViewById(R.id.Market_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
