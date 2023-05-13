package com.example.scango.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.scango.ProductResult;
import com.example.scango.R;

import java.util.List;

public class RVRetrofitAdapter extends RecyclerView.Adapter<RVRetrofitAdapter.RVHolderRetrofit> {
    List<ProductResult.Result> productResults;
    Context mContext;

    public RVRetrofitAdapter() {
    }

    public RVRetrofitAdapter(Context mContext,List<ProductResult.Result> productResults) {
        this.productResults = productResults;
        this.mContext = mContext;
    }



    @NonNull
    @Override
    public RVRetrofitAdapter.RVHolderRetrofit onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.rv_lay1, parent, false);
        return new RVHolderRetrofit(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RVRetrofitAdapter.RVHolderRetrofit holder, int position) {
        Glide.with(mContext).load(productResults.get(position).getImage_url()).into(holder.imageView);
        holder.textView.setText(productResults.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return productResults.size();
    }

    public class RVHolderRetrofit extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public RVHolderRetrofit(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.product_names);
            imageView=itemView.findViewById(R.id.sidsaa);
        }
    }
}
