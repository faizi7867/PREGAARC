package com.codewithfaizi.pregaarc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class sendmsg extends AppCompatActivity {
    EditText send;
    ImageView sndmsg,defaultt;

    Geocoder geocoder;
    List<Address> addresses;
    Double lat = 13.0305;
    FirebaseFirestore firestore;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    double lon = 77.5649;
    String PhoneNumber = "+91897102958";
    String uid = "";
    String num = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendmsg);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        uid = firebaseUser.getEmail();
        firestore = FirebaseFirestore.getInstance();
        send=findViewById(R.id.etphone);
        sndmsg = findViewById(R.id.sndphone);



        sndmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no = send.getText().toString();
                geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

                try {
                    addresses = geocoder.getFromLocation(lat,lon,1);
                    String address = addresses.get(0).getAddressLine(0);
                    String post = addresses.get(0).getPostalCode();
                    String area = addresses.get(0).getLocality();
                    String city = addresses.get(0).getAdminArea();
                    String msg  = "Hi i need help this is an  emergency my location is @ "+address;
                    Log.d("msg", no);

                    if (no.equals(""))
                    {
                        Toast.makeText(getApplicationContext(),"Please fill field",Toast.LENGTH_LONG).show();

                    }
                    else {
                        SmsManager smsManager =  SmsManager.getDefault();
                        smsManager.sendTextMessage(no,null,msg,null ,null );
                        Toast.makeText(getApplicationContext(),"messsage sent succesfullly",Toast.LENGTH_LONG).show();
                        send.setText("");
                    }
//                    loc.setText(address);

                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });


        defaultt = findViewById(R.id.defmsg);
        defaultt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               firestore.collection("user_details").whereEqualTo("uid", uid).get()
                       .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                           @Override
                           public void onComplete(@NonNull Task<QuerySnapshot> task) {
                               for (QueryDocumentSnapshot doc: task.getResult()){
                                   num = doc.getString("Husband_num");
                               }
                               geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                               try {
                                   addresses = geocoder.getFromLocation(lat,lon,1);
                                   String address = addresses.get(0).getAddressLine(0);
                                   String post = addresses.get(0).getPostalCode();
                                   String area = addresses.get(0).getLocality();
                                   String city = addresses.get(0).getAdminArea();
                                   String msg  = "Hi i need help this is an  emergency my location is @ "+address;
//                    loc.setText(address);
                                   if (num.equals(""))
                                   {
                                       Toast.makeText(getApplicationContext(),"number is not defined",Toast.LENGTH_LONG).show();

                                   }
                                   else {
                                       SmsManager smsManager =  SmsManager.getDefault();
                                       smsManager.sendTextMessage(num,null,msg,null ,null );
                                   }

                               } catch (IOException e) {
                                   e.printStackTrace();
                               }

                               Toast.makeText(getApplicationContext(),"messsage sent succesfullly",Toast.LENGTH_LONG).show();

                           }
                       }).addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                       Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                   }
               });




            }
        });
    }
}
