package com.example.caloriemaintainer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {

    EditText txt_name, txt_email,txt_pass,txt_confirmpass;
    RadioGroup RadioGroup;
    RadioButton male,female;
    Button rgstr;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txt_name = findViewById(R.id.name);
        txt_email = findViewById(R.id.email);
        txt_pass = findViewById(R.id.Pass);
        txt_confirmpass = findViewById(R.id.confirmPass);

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        rgstr = findViewById(R.id.rgstr);
            //firebase authentication//
        firebaseAuth = FirebaseAuth.getInstance();
        rgstr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txt_name.getText().toString().trim();
                String email = txt_email.getText().toString().trim();
                String password = txt_pass.getText().toString().trim();
                String confrimpass = txt_confirmpass.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {

                    Toast.makeText(signup.this, "please enter your name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)) {

                    Toast.makeText(signup.this, "email is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {

                    Toast.makeText(signup.this, "password is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(confrimpass)) {

                    Toast.makeText(signup.this, "re_enter password ", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {

                    Toast.makeText(signup.this, "password is too short", Toast.LENGTH_SHORT).show();
                }

                if (password.equals(confrimpass)) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        startActivity(new Intent(getApplicationContext(), Navbar.class));
                                        Toast.makeText(signup.this, "You Are Registered", Toast.LENGTH_SHORT).show();

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(signup.this, "Registration Failed", Toast.LENGTH_SHORT).show();

                                    }

                                    // ...
                                }
                            });




        /*rgstr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"You Are Register",Toast.LENGTH_SHORT).show();
                  Intent i = new Intent(signup.this, Login.class);
                                      startActivity(i);

                if(!validate()){
                    Toast.makeText(signup.this,"Success...",Toast.LENGTH_LONG).show();

                }
            }
            private boolean validate(){
                if(name.getText().toString().trim().length()<=0){

                    Toast.makeText(signup.this,"Enter your Name",Toast.LENGTH_SHORT).show();
                    return true;
                }else if (email.getText().toString().trim().length()<=0){

                    Toast.makeText(signup.this,"Enter your Email",Toast.LENGTH_SHORT).show();
                    return true;
                }else if (pass.getText().toString().trim().length()<=0){

                    Toast.makeText(signup.this,"Enter your Password",Toast.LENGTH_SHORT).show();
                    return true;
                }else if (email.getText().toString().trim().length()<=0){

                    Toast.makeText(signup.this,"Password is not same",Toast.LENGTH_SHORT).show();
                    return true;
                }

                return false;
            }
        });*/

            }


        }
            }
        );}
}

