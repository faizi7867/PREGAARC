package com.codewithfaizi.pregaarc;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class m1 extends Fragment {
     Button next;
     Button previous;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v =  inflater.inflate(R.layout.f_m1, container, false);
       next = v.findViewById(R.id.next1);
       next.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FragmentTransaction ft = getFragmentManager().beginTransaction();
               ft.replace(R.id.fragment_container,new m2()).addToBackStack(null);

               ft.commit();
           }
       });

       previous = v.findViewById(R.id.next);

       previous.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FragmentTransaction ft = getFragmentManager().beginTransaction();
               ft.replace(R.id.fragment_container,new wkbywkfragment());
               ft.commit();

           }
       });

       return  v;
    }





}
