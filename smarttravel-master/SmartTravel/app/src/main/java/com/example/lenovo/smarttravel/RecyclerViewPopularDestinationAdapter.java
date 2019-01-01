package com.example.lenovo.smarttravel;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class RecyclerViewPopularDestinationAdapter  extends RecyclerView.Adapter<RecyclerViewPopularDestinationAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    //private ArrayList<String> mImages = new ArrayList<>();
    //private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<ImageModel> imageModelArrayList = new ArrayList<>();
    private Context mcontext;

    public RecyclerViewPopularDestinationAdapter(ArrayList<ImageModel> imageModelArrayList, Context mcontext) {
        this.imageModelArrayList = imageModelArrayList;
        this.mcontext = mcontext;
    }




    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popular_destination, parent, false);
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

       // messageViewHolder.img.setImageResource(model.getImagePath());

        messageViewHolder.txt.setText(model.getImageName());
        messageViewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mcontext, model.getImageName(), Toast.LENGTH_SHORT).show();
                // load fragment

               // ((MainActivity)mcontext).navigation.setSelectedItemId(R.id.navigation_destination);
                //((MainActivity)mcontext).loadFragment(new DestinationFragment());
                //Intent đến Detail Destination Activity
                //thay activitiy xuong duoi nha

                Intent intent = new Intent(mcontext, DestinationDetail.class);
                intent.putExtra("activityModel",model);
                mcontext.startActivity(intent);


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
        RelativeLayout parent_layout;


        public ViewHolder( View itemView) {
            super(itemView);
//

            img = itemView.findViewById(R.id.imvThumbnailPopularDestination);
            txt = itemView.findViewById(R.id.txtTitlePopularDestination);
            parent_layout = itemView.findViewById(R.id.parent_layout_PopularDetination);

        }
    }




}
