package com.example.oaupost_utme;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class splash_activity extends AppCompatActivity {


    private TextView Appname,devname;

    private static int DELAY_TIME = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        Appname = findViewById(R.id.appName);
        ImageView imageView = findViewById(R.id.imageView2);
        devname = findViewById(R.id.developerName);


        Animation top = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        Animation button = AnimationUtils.loadAnimation(this,R.anim.button_anim);
        //Animation bounce = AnimationUtils.loadAnimation(this,R.anim.devloper);




        imageView.setAnimation(top);
        Appname.setAnimation(button);
      //  devname.setAnimation(bounce);

        devname.setTextColor(Color.parseColor("red"));



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(splash_activity.this, activity_activation_layout.class);
                startActivity(intent);
                finish();
            }
        },DELAY_TIME);


    }
}