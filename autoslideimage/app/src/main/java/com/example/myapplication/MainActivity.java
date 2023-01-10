package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private photoAdapter photoAdapter;
// auto
    private List<photo> mListPhoto;
    private Timer mtimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        circleIndicator = findViewById(R.id.circle_indicate);

        //auto
        mListPhoto = getListPhoto();
        //
       // photoAdapter = new photoAdapter(this, getListPhoto());// tuwj tao getListPhoto
//auto
        photoAdapter = new photoAdapter(this, mListPhoto);// tuwj tao getListPhoto

        viewPager.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        autoSlideImage();
    }

    private List<photo> getListPhoto() {
        List<photo> list = new ArrayList<>();
        list.add(new photo(R.drawable.mu5));
        list.add(new photo(R.drawable.mu4));
        list.add(new photo(R.drawable.mu3));
        list.add(new photo(R.drawable.mu2));

        return list;
    }
    private void autoSlideImage(){
        if(mListPhoto == null || mListPhoto.isEmpty() || viewPager == null){
            return;
        }
        //khowir taoj timer
        if(mtimer == null){
            mtimer = new Timer();
        }
        mtimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = mListPhoto.size()-1;
                        if(currentItem <totalItem){
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }else{
                            viewPager.setCurrentItem(0);
                        }
                    }
                });

            }
        },500,3000);//(delay,thowi gian sau moi lan xu ly)
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mtimer != null){
            mtimer.cancel();
            mtimer = null;
        }
    }
}