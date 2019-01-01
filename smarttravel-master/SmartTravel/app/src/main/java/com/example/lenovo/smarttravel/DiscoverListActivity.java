package com.example.lenovo.smarttravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

public class DiscoverListActivity extends AppCompatActivity {

    private ArrayList<DiscoverListModel> discoverListModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        loadData();
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recyclerviewDiscoverList);
        RecyclerViewDiscoverListAdapter adapter2 = new
                RecyclerViewDiscoverListAdapter(discoverListModels,this);
        recyclerView2.setAdapter(adapter2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(layoutManager2);

        Intent intent = getIntent();



    }


    public void loadData()
    {
        discoverListModels.add(new DiscoverListModel(1,"National Parks of the Canadian Rockies Westbound",
                "The Rockies are a great reason to explore the Canadian West!",R.drawable.roadtrip,"1 PLACES * 14 DAYS"));
        discoverListModels.add(new DiscoverListModel(2,"Patagonia",
                "Blissfully remote",R.drawable.patagonia2,"2 PLACES * 17 DAYS"));
        discoverListModels.add(new DiscoverListModel(3,"Mandalay",
                "A city and former royal capital Myanmar",R.drawable.mandalay,"1 PLACES * 3 DAYS"));
        discoverListModels.add(new DiscoverListModel(4,"Canyonlands - The Needles District",
                "Three day backpacking adventure near Moab,UT",R.drawable.canyonlands,"2 PLACES * 3 DAYS"));
        discoverListModels.add(new DiscoverListModel(5,"I Left My Heart In Jerusalem",
                "Doing it yourself",R.drawable.jerusalemdiscover2,"4 PLACES * 4 DAYS"));

        discoverListModels.add(new DiscoverListModel(6,"World Peace Pagoda",
                "Exploring the Shanti Stupa in Nepan",R.drawable.nepan2,"2 PLACES * 4 DAYS"));

        discoverListModels.add(new DiscoverListModel(7,"Northern Ireland",
                "Road trip through a beautiful Island",R.drawable.ireland2,"10 PLACES * 4 DAYS"));

        discoverListModels.add(new DiscoverListModel(8,"Hoi An - Viet Nam",
                "Graceful, historic Hoi An is Vietnam’s most atmospheric and delightful town",R.drawable.hoian2,"1 PLACES * 7 DAYS"));

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }//onOptionItemSelected





}
