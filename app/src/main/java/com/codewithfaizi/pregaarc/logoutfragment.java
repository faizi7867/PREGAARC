package com.codewithfaizi.pregaarc;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;

public class logoutfragment extends Fragment {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_logout,container,false);
        Button yes = v.findViewById(R.id.yes);
        final FirebaseAuth mAuth = FirebaseAuth.getInstance();
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
                mAuth.signOut();

                startActivity(new Intent(getActivity(),loginact.class));
                Toast.makeText(getActivity(),"Logged Out successfully",Toast.LENGTH_SHORT).show();


            }
        });

        Button no = v.findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,new homefragment());
                ft.commit();

            }
        });

        return v;
    }
}
