package com.example.lenovo.smarttravel;



import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
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
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    //private ArrayList<String> mImages = new ArrayList<>();
    //private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<ImageModel> imageModelArrayList = new ArrayList<>();
    private Context mcontext;

    public RecyclerViewAdapter(ArrayList<ImageModel> imageModelArrayList, Context mcontext) {
        this.imageModelArrayList = imageModelArrayList;
        this.mcontext = mcontext;
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_destination, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)
    {
        final ImageModel model = imageModelArrayList.get(position);

        ViewHolder messageViewHolder = (ViewHolder) holder;

        Glide.with(mcontext)
                .asBitmap()
                .load(model.getImagePath())
                .into(holder.img);

//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inSampleSize = 3;
//        Bitmap bitmap=BitmapFactory.decodeResource(mcontext.getResources(), model.getImagePath(),options);
//        messageViewHolder.img.setImageBitmap(bitmap);
//        Log.d("mybyte", "onBindViewHolder: "+ options.outHeight + " ,"+options.outWidth
//                + ","+bitmap.getByteCount()+ ","+ model.getImageName());

       // messageViewHolder.img.setImageBitmap(decodeSampledBitmapFromResource(mcontext.getResources(),
         //       model.getImagePath(), 160, 160));
        messageViewHolder.txt.setText(model.getImageName());
        messageViewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mcontext, model.getImageName()+"", Toast.LENGTH_SHORT).show();
                 ((MainActivity)mcontext).navigation.setSelectedItemId(R.id.navigation_destination);
                // load fragment
                ((MainActivity)mcontext).loadFragment(new DestinationFragment());

            }
        });



    }



    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        CardView parent_layout;


        public ViewHolder( View itemView) {
            super(itemView);

                img = itemView.findViewById(R.id.imgDestination);
                txt = itemView.findViewById(R.id.txtDestination);
                parent_layout = itemView.findViewById(R.id.parent_layout);

        }
    }





}

