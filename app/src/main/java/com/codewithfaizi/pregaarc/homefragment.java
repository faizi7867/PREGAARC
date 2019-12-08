package com.codewithfaizi.pregaarc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homefragment extends Fragment {
    BottomNavigationView navigationView;
    FrameLayout frameLayout;

    private fragment_afi afi;
    private fragment_fhr fhr;
    private fragment_el el;
    private fragment_crl crl;
    private void InitializeFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_analyze, fragment);
        fragmentTransaction.commit();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_home,container,false);
       navigationView = v.findViewById(R.id.topnav);
       frameLayout = v.findViewById(R.id.frame_analyze);
       afi = new fragment_afi();
       fhr = new fragment_fhr();
       el = new fragment_el();
       crl = new fragment_crl();


       navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               switch (menuItem.getItemId()){
                   case  R.id.afi :
                       InitializeFragment(afi);
                       return true;
                   case R.id.fhr :
                       InitializeFragment(fhr);
                       return true;
                   case R.id.el:
                       InitializeFragment(el);
                       return true;
                   case R.id.crl:
                       InitializeFragment(crl);
                       return true;
               }


               return false;
           }
       });

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_analyze,new fragment_afi()).addToBackStack("analyzefragment");
        ft.commit();
       return  v;
    }



}
