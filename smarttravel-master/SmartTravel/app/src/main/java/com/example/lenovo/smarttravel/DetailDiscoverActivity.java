package com.example.lenovo.smarttravel;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class DetailDiscoverActivity extends AppCompatActivity {

    private ViewPager mPager;
    private ViewPagerImageAdapter mPagerAdapter;
    private  Toolbar toolbar;

    private int[] mImageResources = {
            R.drawable.mot,R.drawable.hai,R.drawable.ba,R.drawable.bon,R.drawable.nam,R.drawable.sau,R.drawable.bay,R.drawable.tam,
            R.drawable.chin,R.drawable.muoi
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_discover);
        mPager = (ViewPager) findViewById(R.id.view_pager_image);
        mPagerAdapter = new ViewPagerImageAdapter(this, mImageResources);
        mPager.setAdapter(mPagerAdapter);
        Intent intent = getIntent();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //toolbar.setMenu();



    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu_like:
                Toast.makeText(this, "Added to Like List!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_share:
                Toast.makeText(this, "Share to my friends", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }//onOptionItemSelected

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_discover, menu);
        return true;
    }



}
