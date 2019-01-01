package com.example.lenovo.smarttravel;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
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

import java.util.ArrayList;

public class RecyclerViewDiscoverAdapter extends RecyclerView.Adapter<RecyclerViewDiscoverAdapter.ViewHolder>{
    private ArrayList<DiscoverModel> discoverModelArrayList = new ArrayList<>();
    private Context mContext;

    public RecyclerViewDiscoverAdapter(ArrayList<DiscoverModel> discoverModelArrayList, Context mContext) {
        this.discoverModelArrayList = discoverModelArrayList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerViewDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_discover,
                viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        Log.d("test", "onCreateViewholder: co vo day ko");


        return holder;

    }

    @Override
    public void onBindViewHolder(final RecyclerViewDiscoverAdapter.ViewHolder holder, int position) {

//        final PopularActivityModel model = popularActivityModelArrayList.get(position);

        DiscoverModel model = discoverModelArrayList.get(position);

        ViewHolder messageViewHolder = (ViewHolder) holder;

        //messageViewHolder.img.setImageResource(model.getThumbnail());

        Glide.with(mContext)
                    .asBitmap()
                    .load(model.getThumbnail())
                    .into(holder.img);

        messageViewHolder.txtTitle.setText(model.getTitle());
        Log.d("test", "onBindViewHolder: co vo day ko");

        messageViewHolder.cardViewDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DiscoverListActivity.class);
                //intent.putExtra("activityModel",model);
                mContext.startActivity(intent);

            }
        });




    }

    @Override
    public int getItemCount() {
        return discoverModelArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtTitle;
        CardView cardViewDiscover;


        public ViewHolder( View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imvThumbnailDiscover);
            txtTitle = itemView.findViewById(R.id.txtTitleDiscover);
            cardViewDiscover = itemView.findViewById(R.id.cardviewDiscover);

        }
    }


}
