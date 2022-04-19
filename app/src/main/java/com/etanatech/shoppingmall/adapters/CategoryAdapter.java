package com.etanatech.shoppingmall.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.etanatech.shoppingmall.R;
import com.etanatech.shoppingmall.model.CategoryItem;
import com.etanatech.shoppingmall.model.ProductItem;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{
    private ArrayList<CategoryItem> mItems;
    private Context mContext;
    private int row_index=0;

    public CategoryAdapter(ArrayList<CategoryItem> mItems, Context mContext) {
        this.mItems = mItems;
        this.mContext = mContext;
    }
//    private int selectedPos = RecyclerView.NO_POSITION;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView itemName;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            itemName = view.findViewById(R.id.category_name);
        }

    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.category_item, viewGroup, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder,  int position) {
        viewHolder.itemName.setText(mItems.get(position).getName());
        viewHolder.itemName.setOnClickListener(view -> {
            row_index=viewHolder.getAdapterPosition();
            notifyDataSetChanged();
        });
        
        if (row_index==position) {
            viewHolder.itemName.setTextColor(Color.WHITE);
            viewHolder.itemName.setBackgroundResource(R.drawable.category_selected);
        } else {
            viewHolder.itemName.setTextColor(ContextCompat.getColor(mContext,R.color.textColor));
            viewHolder.itemName.setBackgroundResource(R.drawable.category_unselected);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
