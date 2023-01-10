package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

public class photoAdapter extends PagerAdapter {
    private Context context;
    private List<photo> mlistphoto;

    public photoAdapter(Context context, List<photo> mlistphoto) {
        this.context = context;
        this.mlistphoto = mlistphoto;
    }
    //overright_Method

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo,container, false);
        ImageView imgPhoto = view.findViewById(R.id.img_photo);
        photo photos = mlistphoto.get(position);
        if(photos != null){
            Glide.with(context).load(photos.getResourceID()).into(imgPhoto); // dungf thuw vieenj glide dde load anh
// load cos theer tair anhr tuwf treen mangj
        }
        container.addView(view);
        return  view;
    }

    @Override
    public int getCount() {
        if(mlistphoto != null){
            return mlistphoto.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    ///overright_Method atl+insert


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //de rermove riew
        container.removeView((View) object);
    }
}
