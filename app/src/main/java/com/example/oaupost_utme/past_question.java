package com.example.oaupost_utme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.oaupost_utme.Account_Years.Year_model_1;
import com.example.oaupost_utme.past_questiona.past_question_account;

public class past_question extends AppCompatActivity {

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_question);

        back = findViewById(R.id.hpast_question);



        CardView biology = findViewById(R.id.card_biology);
        CardView account = findViewById(R.id.card_account);
       CardView crk = findViewById(R.id.card_crk);
       CardView current = findViewById(R.id.card_current_affairs);
       CardView chemistry = findViewById(R.id.card_chemistry);
        CardView commerce = findViewById(R.id.card_commerce);
        CardView english = findViewById(R.id.card_english);
        CardView economic  = findViewById(R.id.economic);
        CardView geo = findViewById(R.id.card_geography);
        CardView gov = findViewById(R.id.card_govermnet);
        CardView irk = findViewById(R.id.card_irk);
        CardView litr = findViewById(R.id.card_litrature);
        CardView math = findViewById(R.id.card_math);
        CardView physic = findViewById(R.id.card_physic);


                account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(getApplicationContext(), past_question_account.class);
                startActivity(intent);


            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);


            }
        });
    }
}