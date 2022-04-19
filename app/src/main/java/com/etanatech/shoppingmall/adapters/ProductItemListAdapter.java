package com.etanatech.shoppingmall.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.etanatech.shoppingmall.R;
import com.etanatech.shoppingmall.model.ProductItem;

import java.util.ArrayList;
import java.util.Locale;

public class ProductItemListAdapter extends RecyclerView.Adapter<ProductItemListAdapter.ViewHolder> implements Filterable {

    private ArrayList<ProductItem> mItems;
    private Context mContext;
    private ArrayList<ProductItem> FullList;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatTextView itemName;
        private final AppCompatTextView itemPrice;
        private final AppCompatImageView itemThumbnailURL;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            itemName = view.findViewById(R.id.item_name);
            itemPrice = view.findViewById(R.id.item_price);
            itemThumbnailURL = view.findViewById(R.id.item_thumbnail);
        }

    }

    public ProductItemListAdapter(ArrayList<ProductItem> items, Context context) {
        mItems = items;
        mContext = context;
        FullList = new ArrayList<>(items);
    }

    @Override
    public Filter getFilter() {
        return Searched_Filter;
    }

    private Filter Searched_Filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<ProductItem> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(FullList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ProductItem item : FullList) {
                    if (item.getItemName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mItems.clear();
            mItems.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
//        int imageUrl = Integer.parseInt(mItems.get(position).getItemThumbnailURL());

        int imageUrl = mContext.getResources().getIdentifier(mItems.get(position).getItemThumbnailURL(), "drawable", mContext.getPackageName());



        viewHolder.itemName.setText(mItems.get(position).getItemName());
        viewHolder.itemPrice.setText(mItems.get(position).getItemPrice());
        viewHolder.itemThumbnailURL.setImageResource(imageUrl);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mItems.size();
    }
}

