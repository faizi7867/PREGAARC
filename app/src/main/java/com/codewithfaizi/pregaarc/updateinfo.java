package com.codewithfaizi.pregaarc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class updateinfo extends AppCompatActivity implements View.OnClickListener {
    private EditText FirstName, LastName,Phone,Address,dob,husbandorfathername, husbandno;
    private Button add,next;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firestoredb;
    FirebaseUser firebaseUser;
    private ProgressDialog progressDailog;
    String uid = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateinfo);
        firebaseUser = mAuth.getCurrentUser();
        uid = firebaseUser.getEmail();
        husbandno = findViewById(R.id.husband_no);
        FirstName = findViewById(R.id.fname);
        LastName = findViewById(R.id.lname);
        Address = findViewById(R.id.address);
        dob = findViewById(R.id.dob);
        Phone = findViewById(R.id.phone);
        husbandorfathername = findViewById(R.id.fatherorhus);
        add = findViewById(R.id.save);
        next = findViewById(R.id.next);
        progressDailog = new ProgressDialog(this);

        add.setOnClickListener(this);
        next.setOnClickListener(this);
        firestoredb = FirebaseFirestore.getInstance();
    }
    private void  SaveUserInfo() {
        String husband_num = husbandno.getText().toString().trim();
        String fname1 = FirstName.getText().toString().trim();
        String lname1 = LastName.getText().toString().trim();
        String dob1 = dob.getText().toString().trim();
        String address1 = Address.getText().toString().trim();
        String phone1 = Phone.getText().toString().trim();
        String husorfat = husbandorfathername.getText().toString().trim();

        Map<String, Object> db = new HashMap<String, Object>();
        db.put("First Name", fname1);
        db.put("Last Name", lname1);
        db.put("Date Of Birth", dob1);
        db.put("Address", address1);
        db.put("Phone", phone1);
        db.put("Husband/Father", husorfat);
        db.put("Husband_num", husband_num);
        db.put("uid", uid);

        firestoredb.collection("user_details").add(db).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                progressDailog.setMessage("Updating Info. . . . .");
                progressDailog.show();
                Toast.makeText(getApplicationContext(),"Information saved",Toast.LENGTH_LONG).show();

            }


        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Falied to save retry",Toast.LENGTH_LONG).show();
            }
        });


    }


    @Override
    public void onClick(View v) {
        if (v == add) {
            SaveUserInfo();
        }
        if (v == next){
            finish();
            startActivity(new Intent(getApplicationContext(),navactivity.class));
        }


    }
}
