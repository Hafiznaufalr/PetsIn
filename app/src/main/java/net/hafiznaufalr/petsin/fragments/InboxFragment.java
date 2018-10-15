package net.hafiznaufalr.petsin.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import net.hafiznaufalr.petsin.R;
import net.hafiznaufalr.petsin.events.Events;
import net.hafiznaufalr.petsin.forum.Forum;
import net.hafiznaufalr.petsin.lifestyle.LifeStyle;
import net.hafiznaufalr.petsin.nearby.MapsActivity;

public class InboxFragment extends Fragment implements View.OnClickListener {

    RelativeLayout r1,r2,r3,r4;

    public InboxFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inbox, container, false);

        r1 = (RelativeLayout) view.findViewById(R.id.inb1);
        r1.setOnClickListener((View.OnClickListener) this);
        r2 = (RelativeLayout) view.findViewById(R.id.inb2);
        r2.setOnClickListener((View.OnClickListener) this);
        r3 = (RelativeLayout) view.findViewById(R.id.inb3);
        r3.setOnClickListener((View.OnClickListener) this);
        r4 = (RelativeLayout) view.findViewById(R.id.inb4);
        r4.setOnClickListener((View.OnClickListener) this);


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.inb1:
                Intent yIntent = new Intent(getActivity(), Forum.class);
                startActivity(yIntent);
                break;

            case R.id.inb4:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "app3nity@gmail.com", null));

                getActivity().startActivity(Intent.createChooser(emailIntent, null));
                break;




        }


    }
}