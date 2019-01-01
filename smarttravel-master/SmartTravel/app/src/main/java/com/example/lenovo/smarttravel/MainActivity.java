package com.example.lenovo.smarttravel;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.robertlevonyan.views.chip.Chip;
import com.robertlevonyan.views.chip.OnChipClickListener;
import com.robertlevonyan.views.chip.OnSelectClickListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements CommunicationInterface {

    private Chip chip1,chip2,chip3,chip4,chip5;


    private ArrayList<String> ImageUrls = new ArrayList<>();
    private ArrayList<String> ImageNames = new ArrayList<>();

    private Fragment fragment;
    public BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Mapping();
        navigation = (BottomNavigationView) findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //navigation.setSelectedItemId(R.id.navigation_discover);
        //navigation.performClick();
        // attaching bottom sheet behaviour - hide / show on scroll
       // CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        //layoutParams.setBehavior(new BottomNavigationBehavior());


        loadFragment(new HomeFragment());
        Bundle extras = getIntent().getExtras();
        if(extras == null){
            return;
        } else{
            int value = extras.getInt("DetailToCart");
            if (value == 22){
                Toast.makeText(this, "Test cart!!", Toast.LENGTH_SHORT).show();
            }
        }


    } //onCreate



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_discover:
                    fragment = new DiscoverFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_destination:
                    fragment = new DestinationFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_cart:
                    fragment = new CartFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_account:
                    fragment = new AccountFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        } //onNavigationItemSelected
    }; //mOnNavigationItemSelectedListener




    public void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(null);
        transaction.commit();
    }



    @Override
    public void onClickTopFragment(String str) {

    }








}
