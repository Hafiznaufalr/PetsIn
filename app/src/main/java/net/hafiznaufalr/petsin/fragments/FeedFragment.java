package net.hafiznaufalr.petsin.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.hafiznaufalr.petsin.R;
import net.hafiznaufalr.petsin.events.Events;
import net.hafiznaufalr.petsin.nearby.MapsActivity;
import net.hafiznaufalr.petsin.store.store1.Store1;
import net.hafiznaufalr.petsin.store.store2.Store2;
import net.hafiznaufalr.petsin.store.store3.Store3;
import net.hafiznaufalr.petsin.store.store4.Store4;
import net.hafiznaufalr.petsin.store.store5.Store5;
import net.hafiznaufalr.petsin.store.store6.Store6;

public class FeedFragment extends Fragment implements View.OnClickListener {
    CardView f1,f2,f3,f4,f5,f6;

    public FeedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        f1 = (CardView) view.findViewById(R.id.utas);
        f1.setOnClickListener((View.OnClickListener) this);
        f2 = (CardView) view.findViewById(R.id.dua);
        f2.setOnClickListener((View.OnClickListener) this);
        f3 = (CardView) view.findViewById(R.id.tiga);
        f3.setOnClickListener((View.OnClickListener) this);
        f4 = (CardView) view.findViewById(R.id.empat);
        f4.setOnClickListener((View.OnClickListener) this);
        f5 = (CardView) view.findViewById(R.id.lima);
        f5.setOnClickListener((View.OnClickListener) this);
        f6 = (CardView) view.findViewById(R.id.enam);
        f6.setOnClickListener((View.OnClickListener) this);


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.utas:
                Intent yIntent = new Intent(getActivity(), Store1.class);
                startActivity(yIntent);
                break;
            case R. id.dua:
                Intent dIntent = new Intent(getActivity(), Store2.class);
                startActivity(dIntent);
                break;
            case R.id.tiga:
                Intent tIntent = new Intent(getActivity(), Store3.class);
                startActivity(tIntent);
                break;
            case R.id.empat:
                Intent eIntent = new Intent(getActivity(), Store4.class);
                startActivity(eIntent);
                break;
            case R.id.lima:
                Intent lIntent = new Intent(getActivity(), Store5.class);
                startActivity(lIntent);
                break;
            case R.id.enam:
                Intent enIntent = new Intent(getActivity(), Store6.class);
                startActivity(enIntent);
                break;




        }


    }

}
