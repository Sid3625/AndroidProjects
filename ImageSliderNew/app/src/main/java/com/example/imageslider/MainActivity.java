package com.example.imageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageSlider imageSlider=findViewById(R.id.slider1);

        List<SlideModel> slideModelList=new ArrayList<>();
        slideModelList.add(new SlideModel(R.drawable.img1,"1", ScaleTypes.FIT));
        slideModelList.add(new SlideModel(R.drawable.img2,"2",ScaleTypes.FIT));
        imageSlider.setImageList(slideModelList);
    }
}