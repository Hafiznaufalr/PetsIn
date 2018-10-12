package net.hafiznaufalr.petsin.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import net.hafiznaufalr.petsin.R;

import java.util.ArrayList;
import java.util.HashMap;

public class NotifFragment extends Fragment {

    ListView lstNotif;
    SimpleAdapter simpleAdapter;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();

    public NotifFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notif, container, false);
        lstNotif =view.findViewById(R.id.lstNotif);
        setNotif();


        return view;
    }

    private void setNotif(){

        for (int i = 1; i <= 5; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("title",  "PetsIn Official");
            arrayList.add(map);
        }
        simpleAdapter = new SimpleAdapter(getActivity(), arrayList, R.layout.adapter_notif,
                new String[] { "title", },
                new int[] { R.id.txtTitle });

        lstNotif.setAdapter(simpleAdapter);
        lstNotif.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView txtDesc = ((TextView) view.findViewById(R.id.txtDesc));
                if ( txtDesc.getVisibility() == View.GONE) {
                    txtDesc.setVisibility(View.VISIBLE);
                } else {
                    txtDesc.setVisibility(View.GONE);
                }
            }
        });
    }
}
