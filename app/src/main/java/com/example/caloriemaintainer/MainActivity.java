package com.example.caloriemaintainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        imageView.startAnimation(animation);
        Thread timer =new Thread() {
            @Override
            public void run() {

                    try {
                        sleep(3000);

                        Intent intent = new Intent(getApplicationContext(),Login.class);
                        startActivity(intent);
                        finish();
                        super.run();

                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }



            }
        };


        timer.start();
    }
}

