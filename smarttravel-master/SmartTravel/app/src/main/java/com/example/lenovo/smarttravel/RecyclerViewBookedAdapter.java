package com.example.lenovo.smarttravel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewBookedAdapter extends RecyclerView.Adapter<RecyclerViewBookedAdapter.ViewHolder> {

    private ArrayList<PopularActivityModel> popularActivityModelArrayList = new ArrayList<>();
    private Context mcontext;

    public RecyclerViewBookedAdapter(ArrayList<PopularActivityModel> popularActivityModelArrayList, Context mcontext) {
        this.popularActivityModelArrayList = popularActivityModelArrayList;
        this.mcontext = mcontext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_booked, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewBookedAdapter.ViewHolder holder, int position) {

        final PopularActivityModel model = popularActivityModelArrayList.get(position);
        RecyclerViewBookedAdapter.ViewHolder messageViewHolder = (RecyclerViewBookedAdapter.ViewHolder) holder;
        Glide.with(mcontext)
                .asBitmap()
                .load(model.getImagePath())
                .into(holder.img);
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inSampleSize = 5;
//        Bitmap bitmap=BitmapFactory.decodeResource(mcontext.getResources(), model.getImagePath(),options);
//        messageViewHolder.img.setImageBitmap(bitmap);
//        Log.d("mybyte", "onBindViewHolder: "+ options.outHeight + " ,"+options.outWidth
//                + ","+bitmap.getByteCount()+ ","+ model.getTitle());


        messageViewHolder.txtTitle.setText(model.getTitle());
        messageViewHolder.txtDate.setText("22 Nov 2019");
        messageViewHolder.txtType.setText("Type: Adult");
        messageViewHolder.txtQuantity.setText("Quantity: 1");
        messageViewHolder.txtPrice.setText("đ "+ model.getPrice());




        messageViewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(mcontext, model.getTitle()+"", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mcontext, DetailActivity.class);
                intent.putExtra("activityModel",model);
                mcontext.startActivity(intent);
            }
        });


        messageViewHolder.txtDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext, "Delete cart item!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return popularActivityModelArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtTitle,txtDate,txtType,txtQuantity,txtDelete,txtPrice;
        LinearLayout parent_layout;


        public ViewHolder( View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imvUserCart);
            txtTitle = itemView.findViewById(R.id.txttitleCart);
            txtDate = itemView.findViewById(R.id.txtDateCart);
            txtQuantity = itemView.findViewById(R.id.txtQuantityCart);
            txtType = itemView.findViewById(R.id.txtTypeCart);
            parent_layout = itemView.findViewById(R.id.parentLinearlayout);
            txtPrice = itemView.findViewById(R.id.txtPriceCart);
            txtDelete =itemView.findViewById(R.id.txtDeleteCart);


        }
    }

    public  int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
         int height = options.outHeight;
         int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        Log.d("mybyte", "calculateInSampleSize: "+ inSampleSize);

        return inSampleSize;
    }
    public  Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {
        // First decode with inJustDecodeBounds=true to check dimensions
         BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        Log.d("mybyte", "onBindViewHolder: "+ options.outHeight + " ,"+options.outWidth);
        return BitmapFactory.decodeResource(res, resId, options);
    }





}
