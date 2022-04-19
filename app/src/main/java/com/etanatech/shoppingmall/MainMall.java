package com.etanatech.shoppingmall;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;

import com.etanatech.shoppingmall.adapters.ProductItemListAdapter;
import com.etanatech.shoppingmall.fragments.CartFragment;
import com.etanatech.shoppingmall.fragments.FavoriteFragment;
import com.etanatech.shoppingmall.fragments.HomeFragment;
import com.etanatech.shoppingmall.fragments.ProfileFragment;
import com.etanatech.shoppingmall.model.ProductItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainMall extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener {

    HomeFragment homeFragment;
    CartFragment cartFragment;
    FavoriteFragment favoriteFragment;
    ProfileFragment profileFragment;
    BottomNavigationView bottomNavigationView;
    private ProductItemListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mall);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//  set status text dark
        getWindow().setStatusBarColor(ContextCompat.getColor(MainMall.this,R.color.colorPrimaryDark));// set status background white

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);

        homeFragment = new HomeFragment();
        cartFragment = new CartFragment();
        favoriteFragment = new FavoriteFragment();
        profileFragment = new ProfileFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, homeFragment).commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Home:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, homeFragment).commit();
                return true;
            case R.id.Cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, cartFragment).commit();
                return true;
            case R.id.Favorite:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, favoriteFragment).commit();
                return true;
            case R.id.Profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, profileFragment).commit();
                return true;
        }
        return false;
    }
}