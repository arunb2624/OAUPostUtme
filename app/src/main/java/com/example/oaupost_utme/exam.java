package com.example.oaupost_utme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.oaupost_utme.Account_Years.Year_model_1;
import com.example.oaupost_utme.Starting_Accunt_Page.start_accoun_year_1_past_question;

public class exam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);


        ImageView back =  findViewById(R.id.back_exam);

        CardView biology = findViewById(R.id.card_biologyE);
        CardView account = findViewById(R.id.card_accountE);
       CardView crk = findViewById(R.id.card_crkE);
        CardView current = findViewById(R.id.card_current_affairsE);
        CardView chemistry = findViewById(R.id.card_chemistryE);
        CardView commerce = findViewById(R.id.card_commerceE);
        CardView english = findViewById(R.id.card_englishE);
        CardView economic  = findViewById(R.id.card_economicE);
        CardView geo = findViewById(R.id.card_geographyE);
        CardView gov = findViewById(R.id.card_govermnetE);
        CardView irk = findViewById(R.id.card_irkE);
        CardView litr = findViewById(R.id.card_litratureE);
        CardView math = findViewById(R.id.card_mathE);
        CardView physic = findViewById(R.id.card_physicE);





        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exam.this,MainActivity.class);
                startActivity(intent);
            }
        });



        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(exam.this,account);
                popupMenu.getMenuInflater().inflate(R.menu.account_pop,popupMenu.getMenu());



                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id = item.getItemId();

                            if (id == R.id.account_mock){

                                Toast.makeText(exam.this, "mock", Toast.LENGTH_SHORT).show();

                               // Intent intent = new Intent(exam.this, Year_model_1.class);

                                //startActivity(intent);
                            } else if (id == R.id.account_study) {
                                Toast.makeText(exam.this, "studin", Toast.LENGTH_SHORT).show();
                            }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        biology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PopupMenu popupMenu = new PopupMenu(exam.this,biology);
                popupMenu.getMenuInflater().inflate(R.menu.biology,popupMenu.getMenu());



                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id = item.getItemId();

                        if (id == R.id.biology_mock){

                            Toast.makeText(exam.this, "mock2", Toast.LENGTH_SHORT).show();

                            // Intent intent = new Intent(exam.this, Year_model_1.class);

                            //startActivity(intent);
                        } else if (id == R.id.biology_study) {
                            Toast.makeText(exam.this, "studin2", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
                popupMenu.show();


            }
        });
        current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(exam.this,current);
                popupMenu.getMenuInflater().inflate(R.menu.current_affairs,popupMenu.getMenu());



                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id = item.getItemId();

                        if (id == R.id.current_mock){

                            Toast.makeText(exam.this, "mock 3", Toast.LENGTH_SHORT).show();

                            // Intent intent = new Intent(exam.this, Year_model_1.class);

                            //startActivity(intent);
                        } else if (id == R.id.current_study) {
                            Toast.makeText(exam.this, "studin 3", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
                popupMenu.show();

            }
        });












    }
}