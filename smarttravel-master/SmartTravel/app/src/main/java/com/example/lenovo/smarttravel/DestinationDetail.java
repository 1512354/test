package com.example.lenovo.smarttravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class DestinationDetail extends AppCompatActivity {
Button btnExp;
RecyclerView rv;
ArrayList<String> name;
    ArrayList<Integer> image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_detail);
        btnExp = (Button)findViewById(R.id.btnExplore);
        rv = (RecyclerView)findViewById(R.id.rvActivity);
        name= new ArrayList<>();
        image = new ArrayList<>();
       name.add("Half-Day Mekong Delta by Speedboat and Leisure Biking");
        name.add("Hoi An Countryside Bike Tour Including Thu Bon River Cruise");
        name.add("Hoa Lu and Tam Coc Biking and Boat Day Trip from Hanoi");
        name.add("Oasis Bay Party Cruise - Halong Bay");
        name.add("Half-Day Marble Mountain and Son Tra Peninsula from Da Nang");
        image.add(R.drawable.hd1);
        image.add(R.drawable.hd2);
        image.add(R.drawable.hd3);
        image.add(R.drawable.hd4);
        image.add(R.drawable.hd5);
//        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getApplicationContext());
//        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
//        rv.setLayoutManager(layoutManager2);
        // Làm giùm t cái adapter nay với... Java t không biết fai làm sao.
        btnExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DesInfo.class);
                startActivity(intent);
            }
        });
    }
}
