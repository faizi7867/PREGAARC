package com.codewithfaizi.pregaarc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registration extends AppCompatActivity implements View.OnClickListener {
    private EditText email, password;
    private Button register;
    private TextView textViewsignin;
    private ProgressDialog progressDailog;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        email = findViewById(R.id.etemail);
        password = findViewById(R.id.etpassword);
        register = findViewById(R.id.signup);

        textViewsignin = findViewById(R.id.textViewsignin);
        register.setOnClickListener(this);
        textViewsignin.setOnClickListener(this);
        progressDailog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(this, navactivity.class));
        }

    }

    private void registerUSer() {
        String email1 = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if (TextUtils.isEmpty(email1)) {
            Toast.makeText(getApplicationContext(), "Enter Email to proceed", Toast.LENGTH_SHORT).show();
            return;

        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(getApplicationContext(), "Enter Password to proceed", Toast.LENGTH_SHORT).show();
            return;

        }
        //if validations are ok
        progressDailog.setMessage("Registering User. . . . .");
        progressDailog.show();
        firebaseAuth.createUserWithEmailAndPassword(email1, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Registering User!!!", Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(new Intent(registration.this, updateinfo.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Failed to registered please try again", Toast.LENGTH_LONG).show();
                }
                progressDailog.dismiss();


            }
        });

    }



    @Override
    public void onClick(View v) {
        if (v == register){
            registerUSer();
        }
        if (v == textViewsignin){
            finish();
            startActivity(new Intent(getApplicationContext(),loginact.class));
        }


    }
}
