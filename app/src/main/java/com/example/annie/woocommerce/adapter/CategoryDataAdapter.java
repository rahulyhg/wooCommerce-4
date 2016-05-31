package com.example.annie.woocommerce.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.annie.woocommerce.R;
import com.example.annie.woocommerce.model.ProductCategory;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by SONY on 5/27/2016.
 */
public class CategoryDataAdapter extends android.support.v7.widget.RecyclerView.Adapter {

    List<ProductCategory> mDataSet;
    Context context;
    public CategoryDataAdapter (Context context, List<ProductCategory>data)
    {
        this.context=context;
        this.mDataSet=data;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public static CardView cardView;
        public static ImageView photo;
        public static TextView textViewCategoryName;
        public static TextView textViewCategoryInfo;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.card_view_container);
            photo=(ImageView)itemView.findViewById(R.id.placeImage);
            textViewCategoryName=(TextView) itemView.findViewById(R.id.text_view_category_name);

            textViewCategoryInfo=(TextView) itemView.findViewById(R.id.text_view_category_info);
        }
    }
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_category_cell,parent,false);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Picasso.with(context).load(mDataSet.get(position).getImage()).into(((ViewHolder) holder).photo);
        String quantity= Integer.toString(mDataSet.get(position).getCount());
        ((ViewHolder) holder).textViewCategoryName.setText(mDataSet.get(position).getName() +":"+ " " +quantity);

        ((ViewHolder) holder).textViewCategoryInfo.setText(mDataSet.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    /*@Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }*/
}
