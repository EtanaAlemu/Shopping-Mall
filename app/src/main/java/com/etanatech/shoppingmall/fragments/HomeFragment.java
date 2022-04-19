package com.etanatech.shoppingmall.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.etanatech.shoppingmall.R;
import com.etanatech.shoppingmall.adapters.CategoryAdapter;
import com.etanatech.shoppingmall.adapters.ProductItemListAdapter;
import com.etanatech.shoppingmall.model.CategoryItem;
import com.etanatech.shoppingmall.model.ProductItem;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView productRecycler;
    RecyclerView categoryRecycler;

    ArrayList<ProductItem> productItems;
    ArrayList<CategoryItem> categories;

    public ProductItemListAdapter productItemListAdapter;
    CategoryAdapter categoryAdapter;

    SearchView searchView;

    private AdView adView;
    AdRequest adRequest;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        searchView = view.findViewById(R.id.search_product);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                productItemListAdapter.getFilter().filter(newText);
                return false;
            }
        });


        adView = (AdView) view.findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        productRecycler = view.findViewById(R.id.product_recycler);
        productRecycler.setHasFixedSize(true);
        productRecycler.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        categoryRecycler = view.findViewById(R.id.category_recycler);
        categoryRecycler.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryRecycler.setItemAnimator(new DefaultItemAnimator());
        categoryAdapter = new CategoryAdapter(prepareCategoryData(), getContext());
        categoryRecycler.setAdapter(categoryAdapter);

        productItemListAdapter = new ProductItemListAdapter(initData(), getContext());

        productRecycler.setAdapter(productItemListAdapter);

        return view;
    }

    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

    private ArrayList<CategoryItem> prepareCategoryData() {
        categories = new ArrayList<>();
        categories.add(new CategoryItem("Bloomers"));
        categories.add(new CategoryItem("Blouse"));
        categories.add(new CategoryItem("Bodysuit"));
        categories.add(new CategoryItem("Bustier"));
        categories.add(new CategoryItem("Caftan"));
        categories.add(new CategoryItem("Cardigan"));
        categories.add(new CategoryItem("Dress"));
        categories.add(new CategoryItem("Dungarees"));
        return categories;
    }

    private ArrayList<ProductItem> initData() {
        productItems = new ArrayList<>();
        productItems.add(new ProductItem("Red Dress", "$300", "image", true));
        productItems.add(new ProductItem("Red Dress", "$400", "images", true));
        productItems.add(new ProductItem("Red Dress", "$500", "shoes", true));
        productItems.add(new ProductItem("Red Dress", "$500", "image2", true));
        productItems.add(new ProductItem("Red Dress", "$300", "shoes1", true));
        productItems.add(new ProductItem("Red Dress", "$400", "image", true));
        productItems.add(new ProductItem("Red Dress", "$500", "image2", true));
        productItems.add(new ProductItem("Red Dress", "$500", "images", true));
        productItems.add(new ProductItem("Red Dress", "$400", "images", true));
        productItems.add(new ProductItem("Red Dress", "$500", "shoes2", true));
        productItems.add(new ProductItem("Red Dress", "$500", "image2", true));
        productItems.add(new ProductItem("Red Dress", "$300", "shoes", true));
        productItems.add(new ProductItem("Red Dress", "$400", "image", true));
        productItems.add(new ProductItem("Red Dress", "$500", "image2", true));
        productItems.add(new ProductItem("Red Dress", "$500", "images", true));
        return productItems;
    }
}