package com.example.caloriemaintainer;

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
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText name, email,pass,confirmpass;
    RadioButton male,female;
    Button rgstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.Pass);
        confirmpass = findViewById(R.id.confirmPass);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        rgstr = findViewById(R.id.rgstr);

        rgstr.setOnClickListener(new View.OnClickListener() {
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
        });



    }
}
