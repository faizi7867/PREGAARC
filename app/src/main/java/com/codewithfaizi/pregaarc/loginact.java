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

public class loginact extends AppCompatActivity implements View.OnClickListener {
    private EditText email,password;
    private Button login1;
    private TextView textViewregister;
    private ProgressDialog progressDailog;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginact);
        email = findViewById(R.id.etemail);
        password = findViewById(R.id.etpassword);
        login1 = findViewById(R.id.login);

        textViewregister = findViewById(R.id.textViewregister);
        login1.setOnClickListener(this);
        textViewregister.setOnClickListener(this);
        progressDailog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(this,navactivity.class));
        }

    }
    public void loginUser(){
        String email1 = email.getText().toString().trim();
        String pass  = password.getText().toString().trim();

        if (TextUtils.isEmpty(email1)){
            Toast.makeText(this,"Enter Email to proceed",Toast.LENGTH_SHORT).show();
            return;

        }
        if (TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Enter Password to proceed",Toast.LENGTH_SHORT).show();
            return;

        }
        //if validations are ok
        progressDailog.setMessage("Logging In  Please Wiat. . . . .");
        progressDailog.show();
        firebaseAuth.signInWithEmailAndPassword(email1,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Login Successfull!!!!",Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(new Intent(getApplicationContext(), navactivity.class));
                }
                else {

                    Toast.makeText(getApplicationContext(),"Invalid E-mail or Password Retry Again!!!!",Toast.LENGTH_LONG).show();
                }
                progressDailog.dismiss();
            }

        });

    }

    @Override
    public void onClick(View v) {
        if (v==login1){
            loginUser();

        }
        if (v == textViewregister){
            finish();
            startActivity(new Intent(getApplicationContext(),registration.class));
        }

    }
}
