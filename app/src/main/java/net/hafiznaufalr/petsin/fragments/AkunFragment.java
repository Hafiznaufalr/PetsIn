package net.hafiznaufalr.petsin.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.hafiznaufalr.petsin.MainActivity;
import net.hafiznaufalr.petsin.R;
import net.hafiznaufalr.petsin.logout.Logout;

public class AkunFragment extends Fragment {




    public AkunFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_akun, container, false);






        return view;
    }


}
