package com.example.lenovo.smarttravel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.vlstr.fluentappbar.FluentAppBar;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imvBack;
    private FluentAppBar fluentAppBar;
    private  PopularActivityModel popularActivityModel;
    private DatabaseReference mDatabase;
    public static int Count = 0;
    private ImageView imvHeader,imvCart;
    private TextView txtTitle, txtPrice;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imvBack = (ImageView) findViewById(R.id.imgBack);
        imvHeader = (ImageView) findViewById(R.id.imgHeader);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        imvCart = (ImageView) findViewById(R.id.imgCart);


        fluentAppBar = (FluentAppBar) findViewById(R.id.fluent_app_bar);
        fluentAppBar.setNavigationMenu(R.menu.app_bar_main, this);
       // fluentAppBar.setSecondaryMenu(R.menu.fluent_app_bar_secondary_menu, this);
        fluentAppBar.setBlurRadius(10);
       // fluentAppBar.setBackgroundColour(getResources().getColor(android.R.color.holo_purple));

        //getIntent
        popularActivityModel = new PopularActivityModel();
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            popularActivityModel = extras.getParcelable("activityModel");
        }

        //imvHeader.setImageBitmap(decodeSampledBitmapFromResource(getResources(),
          //      popularActivityModel.getImagePath(), 300, 300));
       //imvHeader.setImageResource(popularActivityModel.getImagePath());

        Glide.with(getBaseContext())
                .asBitmap()
                .load(popularActivityModel.getImagePath())
                .into(imvHeader);
        txtTitle.setText(popularActivityModel.getTitle());
        txtPrice.setText("Ticket: đ "+ popularActivityModel.getPrice());


        Intent intent2 =new Intent(this,MainActivity.class);
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        imvCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2.putExtra("DetailToCart",22);
                startActivity(intent2);
            }
        });



        ArrayList<PopularActivityModel> popularActivityModelsArrayList = new ArrayList<>();
        PopularActivityModel popularActivityModel1 = new PopularActivityModel();
        popularActivityModel1.setId(System.currentTimeMillis());
        popularActivityModel1.setDestination("Singapore");
        popularActivityModel1.setImagePath(R.drawable.rsz_1seoul);
        popularActivityModel1.setPrice("699,000");
        popularActivityModel1.setReview("2202 reviews");
        popularActivityModel1.setTitle("Universal Studios Singapore Ticket");
        popularActivityModelsArrayList.add(popularActivityModel1);

        PopularActivityModel popularActivityModel2 = new PopularActivityModel();
        popularActivityModel2.setId(System.currentTimeMillis());
        popularActivityModel2.setDestination("Paris");
        popularActivityModel2.setImagePath(R.drawable.rsz_1seoul);
        popularActivityModel2.setPrice("1,500,000");
        popularActivityModel2.setReview("202 reviews");
        popularActivityModel2.setTitle("Montparnasse Tower Observation Deck");
        popularActivityModelsArrayList.add(popularActivityModel2);


        PopularActivityModel popularActivityModel3 = new PopularActivityModel();
        popularActivityModel3.setId(System.currentTimeMillis());
        popularActivityModel3.setDestination("London");
        popularActivityModel3.setImagePath(R.drawable.rsz_1seoul);
        popularActivityModel3.setPrice("2,200,000");
        popularActivityModel3.setReview("102 reviews");
        popularActivityModel3.setTitle("London Sightseeing Day Tour");
        popularActivityModelsArrayList.add(popularActivityModel3);


        PopularActivityModel popularActivityModel4 = new PopularActivityModel();
        popularActivityModel4.setId(System.currentTimeMillis());
        popularActivityModel4.setDestination("Tokyo");
        popularActivityModel4.setImagePath(R.drawable.rsz_1seoul);
        popularActivityModel4.setPrice("1,000,000");
        popularActivityModel4.setReview("502 reviews");
        popularActivityModel4.setTitle("Tokyo Tower Main Deck Admission");
        popularActivityModelsArrayList.add(popularActivityModel4);

        popularActivityModelsArrayList.add(popularActivityModel1);

        //popular activity recyclerview horizontal
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recyOthersActivities);
        RecyclerViewPopularAdapter adapter2 = new RecyclerViewPopularAdapter(popularActivityModelsArrayList,this);
        recyclerView2.setAdapter(adapter2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(layoutManager2);





    }// onCreate

    @Override
    public void onClick(View view) {
        int resId = (int) view.getTag();
       // int resId = (int) view.getId();

//        int id2 = (int) view.getId();
//        if(resId == R.id.imgCart){
//                Toast.makeText(this, "Back to Cart!", Toast.LENGTH_SHORT).show();
////                Intent intent2 = new Intent(this, BookingDate.class);
////                intent2.putExtra("activityModel",popularActivityModel);
////                startActivity(intent2);
//
//        }



        switch (resId) {
            //Navigation Menu
            case R.id.nav_favorite:
                fluentAppBar.collapse();
                Toast.makeText(this, "Added to like list!", Toast.LENGTH_SHORT).show();
//                //add item to firebase database
//               mDatabase = FirebaseDatabase.getInstance().getReference("Favorite");
//               //mDatabase.child("Favorite").child("2").setValue(popularActivityModel);
//                final String key = mDatabase.push().getKey();
//                //mDatabase.child(key).setValue(popularActivityModel);
//                Query allPost = FirebaseDatabase.getInstance().getReference().child("Favorite");
//
//                allPost.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        ArrayList<PopularActivityModel> popularActivityModelArrayList = new ArrayList<>();
//                        //PopularActivityModel  popularActivityModel2 = dataSnapshot.getValue(PopularActivityModel.class);
//                        Toast.makeText(DetailActivity.this, "" + dataSnapshot.getValue().toString(),
//                             Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//                    }
//                });

                break;
            case R.id.nav_cart:
                Toast.makeText(this, "Added to cart!", Toast.LENGTH_SHORT).show();
                fluentAppBar.collapse();
                break;
            case R.id.nav_book:
                fluentAppBar.collapse();
                Intent intent = new Intent(this, BookingDate.class);
                intent.putExtra("activityModel",popularActivityModel);
                startActivity(intent);
                break;



        }



    }



    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }





}
