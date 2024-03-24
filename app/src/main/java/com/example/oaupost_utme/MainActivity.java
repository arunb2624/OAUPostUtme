package com.example.oaupost_utme;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AlertDialog alertDialog;
    private  AlertDialog.Builder builder;
    private  NavigationView navigationView;

    androidx.appcompat.widget.Toolbar toolbar;

    ImageView fab;


    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        CardView exam = findViewById(R.id.card_exam);
        CardView study = findViewById(R.id.card_study);
        CardView developer = findViewById(R.id.card_developer);
         CardView management= findViewById(R.id.card_management);







       study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), past_question.class);
                startActivity(intent);
            }
        });

       exam.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(getApplicationContext(), exam.class);
               startActivity(intent);
           }
       });




        navigationView = findViewById(R.id.navigation_drawer);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {


                int id = item.getItemId();


                if (id == R.id.home) {


                    Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.past) {


                    Toast.makeText(MainActivity.this, "past question", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.bookmark_nav) {


                    Intent intent = new Intent(getApplicationContext(), Bookmark_Activity.class);
                    startActivity(intent);

                } else if (id == R.id.about) {



             Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();

            }

            drawerLayout.closeDrawer(GravityCompat.START);
             return true;
            }
        });

        toolbar = findViewById(R.id.toolBar);
        drawerLayout = findViewById(R.id.drawer_layout);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setTitle("O.A.U Post - UTME");

            toolbar.setTitleTextColor(Color.parseColor("WHITE"));
        }



         ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerSlideAnimationEnabled(true);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));








 } }