package com.example.oaupost_utme.Starting_Accunt_Page;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oaupost_utme.Account_Years.Year_model_1;
import com.example.oaupost_utme.Account_Years.Year_model_2;
import com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2014_acccount;
import com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2015_acccount;
import com.example.oaupost_utme.R;
import com.example.oaupost_utme.past_questiona.past_question_account;

public class start_accoun_year_2_past_question extends AppCompatActivity {

    ImageView back;
    private TextView textViewHighscore,time;
    Button buttonStartQuiz;

    int totalQuetion14 = QuestionAnswer_2014_acccount.question14.length;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_accoun_year2_past_question);


         buttonStartQuiz = findViewById(R.id.button_start_quiz2);
        textViewHighscore = findViewById(R.id.question2);
        time = findViewById(R.id.time2);
        back = findViewById(R.id.back_start_year2);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                Intent intent = new Intent(start_accoun_year_2_past_question.this, past_question_account.class);
                startActivity(intent);


            }
        });









        textViewHighscore.setText("Total question : " +totalQuetion14);
        time.setText("Time required to study this past question : 30 min");



        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startQuiz();


            }
        });
    }

    private void startQuiz() {
        Intent intent = new Intent(start_accoun_year_2_past_question.this, Year_model_2.class);
        startActivity(intent);



    }

}