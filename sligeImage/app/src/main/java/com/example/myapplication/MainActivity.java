package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private photoAdapter photoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        circleIndicator = findViewById(R.id.circle_indicate);

        photoAdapter = new photoAdapter(this, getListPhoto());// tuwj tao getListPhoto


        viewPager.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
    }

    private List<photo> getListPhoto() {
        List<photo> list = new ArrayList<>();
        list.add(new photo(R.drawable.mu5));
        list.add(new photo(R.drawable.mu4));
        list.add(new photo(R.drawable.mu3));
        list.add(new photo(R.drawable.mu2));

        return list;
    }
}