package com.example.scango.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.scango.DetailedActivity;
import com.example.scango.R;
import com.example.scango.model.PopularProduct;

import java.util.List;

public class PopularProductAdapter extends RecyclerView.Adapter<PopularProductAdapter.PopularStoreViewHolder> {

    private List<PopularProduct> popularProductList;
    public Context mContext;
    public PopularProductAdapter(Context mContext, List<PopularProduct> popularProductList){
        this.popularProductList=popularProductList;
        this.mContext=mContext;
    }
    @NonNull
    @Override
    public PopularStoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.store_visit,parent,false);
//        return new PopularStoreViewHolder(view);
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.skeleton_item_view, parent, false);
        return new PopularStoreViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull PopularStoreViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(mContext)
                .load(popularProductList.get(position).getImage_url())
                .into(holder.mImageView);
        holder.name.setText(popularProductList.get(position).getName());
        holder.weight.setText(popularProductList.get(position).getWeight());
        holder.price.setText(popularProductList.get(position).getPrice());


        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(mContext, DetailedActivity.class);
                Bundle bundle= new Bundle();
                bundle.putInt("id",popularProductList.get(position).getId());
                bundle.putString("base_price",popularProductList.get(position).getPrice());
                bundle.putString("name",popularProductList.get(position).getName());
                bundle.putString("image_url",popularProductList.get(position).getImage_url());
                bundle.putInt("rating",popularProductList.get(position).getRating());
                intent.putExtras(bundle);
                mContext.startActivity(intent);





                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return popularProductList.size();
    }

    public class PopularStoreViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private TextView id,name,weight,price;
        ConstraintLayout constraintLayout;


        public PopularStoreViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.sidsa);
            name=itemView.findViewById(R.id.product_name);
            weight=itemView.findViewById(R.id.weight);
            price=itemView.findViewById(R.id.price);
            constraintLayout=itemView.findViewById(R.id.skeleton);




        }
    }
}

