package com.codewithfaizi.pregaarc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class wkbywkfragment extends Fragment {
    private ImageView m1,m2,m3,m4,m5,m6,m7,m8,m9,m10;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_weekbyweek,container,false);
        m1 = v.findViewById(R.id.m1);
        m2 = v.findViewById(R.id.m2);
        m3 = v.findViewById(R.id.m3);
        m4 = v.findViewById(R.id.m4);
        m5 = v.findViewById(R.id.m5);
        m6 = v.findViewById(R.id.m6);
        m7 = v.findViewById(R.id.m7);
        m8 = v.findViewById(R.id.m8);
        m9 = v.findViewById(R.id.m9);
        m10 = v.findViewById(R.id.m10);

        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,new m1()).addToBackStack(null);
                ft.commit();

            }
        });

        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,new m2()).addToBackStack(null);
                ft.commit();

            }
        });
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,new m3()).addToBackStack(null);
                ft.commit();

            }
        });
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,new m4()).addToBackStack(null);
                ft.commit();

            }
        });
        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,new m5()).addToBackStack(null);
                ft.commit();

            }
        });
        m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,new m6()).addToBackStack(null);
                ft.commit();

            }

        });
        m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,new m7()).addToBackStack(null);
                ft.commit();

            }
        });
        m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,new m8()).addToBackStack(null);
                ft.commit();


            }
        });
        m9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,new m9()).addToBackStack(null);
                ft.commit();


            }
        });
        m10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,new m10()).addToBackStack(null);
                ft.commit();


            }
        });





        return v;

    }
}
