package net.hafiznaufalr.petsin.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import net.hafiznaufalr.petsin.R;
import net.hafiznaufalr.petsin.events.Events;
import net.hafiznaufalr.petsin.events.EventsDetail;
import net.hafiznaufalr.petsin.lifestyle.LifeStyle;
import net.hafiznaufalr.petsin.nearby.MapsActivity;
import net.hafiznaufalr.petsin.store.store1.Store1;

import java.util.HashMap;
import java.util.Scanner;

public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, View.OnClickListener {

    private SliderLayout mDemoSlider;
    CardView c1,c2,c3,c4;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        c1 = (CardView) view.findViewById(R.id.d1);
        c1.setOnClickListener((View.OnClickListener) this);
        c2 = (CardView) view.findViewById(R.id.d2);
        c2.setOnClickListener((View.OnClickListener) this);
        c3 = (CardView) view.findViewById(R.id.d3);
        c3.setOnClickListener((View.OnClickListener) this);
        c4 = (CardView) view.findViewById(R.id.d4);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { createAlarm("jadwal hewan .....",00,00);

            }
        });


        mDemoSlider = view.findViewById(R.id.slider);
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Event 1",R.drawable.banner);
        file_maps.put("Event 2",R.drawable.banner);
        file_maps.put("Event 3",R.drawable.banner);
        file_maps.put("Event 4", R.drawable.banner);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterInside)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);


        }



        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


        return view;
    }

    private void createAlarm(String message, int hour,int minutes) {
        Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
        alarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE,message);
        alarmIntent.putExtra(AlarmClock.EXTRA_HOUR,hour);
        alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES,minutes);

        if(alarmIntent.resolveActivity(getActivity().getPackageManager()) != null)startActivity(alarmIntent);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

//    }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.d1:
                Intent yIntent = new Intent(getActivity(), MapsActivity.class);
                startActivity(yIntent);
                break;
            case R.id.d2:
                Intent dIntent = new Intent(getActivity(), Events.class);
                startActivity(dIntent);
                break;
            case R.id.d3:
                Intent lIntent = new Intent(getActivity(), LifeStyle.class);
                startActivity(lIntent);
                break;



        }


    }
}