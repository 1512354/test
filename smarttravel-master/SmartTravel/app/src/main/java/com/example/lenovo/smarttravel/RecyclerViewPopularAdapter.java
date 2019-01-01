package com.example.lenovo.smarttravel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewPopularAdapter extends RecyclerView.Adapter<RecyclerViewPopularAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<PopularActivityModel> popularActivityModelArrayList = new ArrayList<>();
    private Context mcontext;

    public RecyclerViewPopularAdapter(ArrayList<PopularActivityModel> popularActivityModelArrayList, Context mcontext) {
        this.popularActivityModelArrayList = popularActivityModelArrayList;
        this.mcontext = mcontext;
    }


    @NonNull
    @Override
    public RecyclerViewPopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_activity,
                viewGroup, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
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

    @Override
    public void onBindViewHolder(final RecyclerViewPopularAdapter.ViewHolder holder, final int position)
    {
        final PopularActivityModel model = popularActivityModelArrayList.get(position);



        ViewHolder messageViewHolder = (ViewHolder) holder;

        //messageViewHolder.img.setImageBitmap(decodeSampledBitmapFromResource(mcontext.getResources(),
          //      model.getImagePath(), 300, 200));
        //messageViewHolder.img.setImageResource(model.getImagePath());

        Glide.with(mcontext)
                    .asBitmap()
                    .load(model.getImagePath())
                    .into(holder.img);

//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds =true;
//        BitmapFactory.decodeResource(mcontext.getResources(), model.getImagePath(),options);
//        Log.d("mybyte", "onBind: "+ options.outWidth + " ,"+options.outHeight);
//        options.inSampleSize = 2;
//        options.inJustDecodeBounds =false;
//        Bitmap bitmap=BitmapFactory.decodeResource(mcontext.getResources(), model.getImagePath(),options);
//
//        messageViewHolder.img.setImageBitmap(bitmap);
//        Log.d("mybyte", "onBindViewHolder: "+ options.outHeight + " ,"+options.outWidth
//                + ","+bitmap.getByteCount()+ ","+ model.getTitle());


        messageViewHolder.txtDestination.setText(model.getDestination());
        messageViewHolder.txtTitle.setText(model.getTitle());
        messageViewHolder.txtReview.setText(model.getReview());
        messageViewHolder.txtPrice.setText(model.getPrice());


        messageViewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mcontext, model.getTitle()+"popular", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mcontext, DetailActivity.class);
                intent.putExtra("activityModel",model);
                mcontext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return popularActivityModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtTitle,txtPrice,txtReview,txtDestination;
        RelativeLayout parent_layout;


        public ViewHolder( View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgDestination);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDestination = itemView.findViewById(R.id.txtDestination);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtReview = itemView.findViewById(R.id.txtReview);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }



}
