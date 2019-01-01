package com.example.lenovo.smarttravel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ViewPagerImageAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mResources;

    public ViewPagerImageAdapter(Context mContext, int[] mResources) {
        this.mContext = mContext;
        this.mResources = mResources;
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_image_view_page, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.img_pager_item);

        //imageView.setImageResource(mResources[position]);

//        imageView.setImageDrawable (container.getResources().getDrawable(mResources[position]));

        Glide.with(mContext)
                .asBitmap()
                .load(mResources[position])
                .into(imageView);
        container.addView(itemView);
        return itemView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
