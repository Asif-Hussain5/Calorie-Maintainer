package com.example.caloriemaintainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email,password;
    Button login,signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        //login.setOnClickListener(this);

         login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"You are logged in",Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(Login.this,Navbar.class);
               // startActivity(i);
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Login.this,signup.class);
                startActivity(i);

                if(!validate()){
                    Toast.makeText(Login.this,"Success...",Toast.LENGTH_LONG).show();

                }
            }
            private boolean validate(){
                if(email.getText().toString().trim().length()<=0){

                    Toast.makeText(Login.this,"Enter your Email",Toast.LENGTH_SHORT).show();
                    return true;
                }else if (password.getText().toString().trim().length()<=0){

                    Toast.makeText(Login.this,"Enter your Password",Toast.LENGTH_SHORT).show();
                    return true;
                }

                return false;
            }
        });
    }
}
