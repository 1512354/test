package com.example.lenovo.smarttravel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewCartAdapter  extends RecyclerView.Adapter<RecyclerViewCartAdapter.ViewHolder>{


    private ArrayList<PopularActivityModel> popularActivityModelArrayList = new ArrayList<>();
    private Context mcontext;

    public RecyclerViewCartAdapter(ArrayList<PopularActivityModel> popularActivityModelArrayList, Context mcontext) {
        this.popularActivityModelArrayList = popularActivityModelArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cart, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewCartAdapter.ViewHolder holder, int position) {

        final PopularActivityModel model = popularActivityModelArrayList.get(position);

        ViewHolder messageViewHolder = (ViewHolder) holder;

        //messageViewHolder.img.setImageResource(model.getImagePath());

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





        messageViewHolder.cbCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (messageViewHolder.cbCheck.isChecked()){
                    messageViewHolder.cbCheck.setChecked(true);
                }
               else {
                    messageViewHolder.cbCheck.setChecked(false);
                }

            }
        });




        messageViewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(mcontext, model.getTitle()+"", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mcontext, DetailActivity.class);
                intent.putExtra("activityModel",model);
                mcontext.startActivity(intent);
            }
        });

        messageViewHolder.txtEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext, "Edit cart item!", Toast.LENGTH_SHORT).show();
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
        TextView txtTitle,txtDate,txtType,txtQuantity,txtEdit,txtDelete,txtPrice;
        CheckBox cbCheck;
        LinearLayout parent_layout;


        public ViewHolder( View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imvUserCart);
            txtTitle = itemView.findViewById(R.id.txttitleCart);
            txtDate = itemView.findViewById(R.id.txtDateCart);
            txtQuantity = itemView.findViewById(R.id.txtQuantityCart);
            txtType = itemView.findViewById(R.id.txtTypeCart);
            cbCheck = itemView.findViewById(R.id.rdbCheck);
            parent_layout = itemView.findViewById(R.id.parentLinearlayout);
            txtPrice = itemView.findViewById(R.id.txtPriceCart);
            txtEdit = itemView.findViewById(R.id.txtEditCart);
            txtDelete =itemView.findViewById(R.id.txtDeleteCart);

//            cbCheck.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (cbCheck.isChecked()){
//                        cbCheck.setChecked(false);
//                    }
//                    else {
//                        cbCheck.setChecked(true);
//                    }
//                    //notifyDataSetChanged();
//                }
//            });


        }
    }



}
