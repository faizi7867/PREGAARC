package com.codewithfaizi.pregaarc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class analyzefragment extends Fragment {
    EditText afi,fhr,el,crl;
    Button analyze;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_analyze,container,false);

        afi = v.findViewById(R.id.afi);
        fhr = v.findViewById(R.id.fhr);
        el  = v.findViewById(R.id.el);
        crl = v.findViewById(R.id.crl);
        analyze = v.findViewById(R.id.analyze);



        analyze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp  = getActivity().getSharedPreferences("analyze",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("afi",afi.getText().toString());
                editor.putString("fhr",fhr.getText().toString());
                editor.putString("el",el.getText().toString());
                editor.putString("crl",crl.getText().toString());
                editor.apply();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,new homefragment());
                ft.commit();
            }
        });
        return v;
    }
}


//    TextView tv = v.findViewById(R.id.textviewfhr);
//    SharedPreferences sp = getActivity().getSharedPreferences("analyze", Context.MODE_PRIVATE);
//    String sp_fhr = sp.getString("fhr","empty");
//
//    double val = Double.parseDouble(sp_fhr);
//
//        if (val < 120   ){
//        tv.setText(" Bradycardia (Low) ");
//
//        }
//        else if (val >= 120 && val <=160){
//        tv.setText("Normal");
//        }
//        else  if (val > 160 && val <= 200 ){
//        tv.setText(" Tachycardia (High) ");
//        }
//        else
//        tv.setText(" enter a correct value ");
//
