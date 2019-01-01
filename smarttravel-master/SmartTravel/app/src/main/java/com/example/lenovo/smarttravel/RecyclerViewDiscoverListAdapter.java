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

public class RecyclerViewDiscoverListAdapter extends RecyclerView.Adapter<RecyclerViewDiscoverListAdapter.ViewHolder>{

    private ArrayList<DiscoverListModel> discoverListModels = new ArrayList<>();
    private Context mContext;

    public RecyclerViewDiscoverListAdapter(ArrayList<DiscoverListModel> discoverListModels, Context mContext) {
        this.discoverListModels = discoverListModels;
        this.mContext = mContext;
    }


    @Override
    public RecyclerViewDiscoverListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_discover,
                viewGroup, false);
        ViewHolder holder = new ViewHolder(view);


        return holder;

    }

    @Override
    public void onBindViewHolder(final RecyclerViewDiscoverListAdapter.ViewHolder viewHolder, int position) {

        DiscoverListModel model = discoverListModels.get(position);

        ViewHolder messageViewHolder = (ViewHolder) viewHolder;

        messageViewHolder.txtTitle.setText(model.getTitle());
        messageViewHolder.txtSubtitle.setText(model.getSubtitle());
        messageViewHolder.txtDayPlace.setText(model.getPlaceDay());

        //messageViewHolder.img.setImageResource(model.getThumbnail());
        Glide.with(mContext)
                .asBitmap()
                .load(model.getThumbnail())
                .into(viewHolder.img);

        messageViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(mContext, "Test discover list!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext,DetailDiscoverActivity.class);
                mContext.startActivity(intent);

            }
        });


    }



    @Override
    public int getItemCount() {
        return discoverListModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtTitle,txtSubtitle,txtDayPlace;
        RelativeLayout relativeLayout;


        public ViewHolder( View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imvThumbnailDiscoverList);
            txtTitle = itemView.findViewById(R.id.txtTitlelistdiscover);
            txtSubtitle = itemView.findViewById(R.id.txtSubtitlelistdiscover);
            relativeLayout= itemView.findViewById(R.id.parent_layout);
            txtDayPlace = itemView.findViewById(R.id.txtPlaceDaylistdiscover);


        }
    }



}
