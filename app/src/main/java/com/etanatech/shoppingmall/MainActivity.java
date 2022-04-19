package com.etanatech.shoppingmall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.etanatech.shoppingmall.fragments.CartFragment;
import com.etanatech.shoppingmall.fragments.FavoriteFragment;
import com.etanatech.shoppingmall.fragments.HomeFragment;
import com.etanatech.shoppingmall.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}