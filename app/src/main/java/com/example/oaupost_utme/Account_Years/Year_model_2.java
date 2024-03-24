package com.example.oaupost_utme.Account_Years;

import static com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2014_acccount.correctAnswer2014;
import static com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2014_acccount.explanation14;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oaupost_utme.Account_Restult.year1_result;
import com.example.oaupost_utme.Account_Restult.year2_result;
import com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2014_acccount;
import com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2015_acccount;
import com.example.oaupost_utme.R;
import com.example.oaupost_utme.Starting_Accunt_Page.start_accoun_year_2_past_question;
import com.example.oaupost_utme.caculator_account.calculator_year_2;

import java.util.Locale;
import java.util.Objects;

public class Year_model_2 extends AppCompatActivity {



    public static int marks = 0, correct = 0, wrong = 0;


    private RadioGroup radio_g;
    private int name;
    private RadioButton rb1, rb2, rb3, rb4;

    ImageView explain;
    TextView explanation14, sub_explanation_text14;

    private TextView totalQues, questiontextview, questioncount, tvScore;

    Button show_answer_hint, submitBtn;
    ImageView calculate, left_prevision_question, next_question,back,book;
    ImageView A_ans_righ, B_ans_righ, C_ans_righ, D_ans_righ;
    ImageView A_ans_wron, B_ans_wron, C_ans_wron, D_ans_wron;


    int score = 0;
    int totalQuetion14 = QuestionAnswer_2014_acccount.question14.length;
    private int currentQuestionIndex14 = 0;
    int currentExplantionIndex_Sub14 = 0;
    String selectedAnswer14 = "";
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    private TextView timerTextview;
    private CountDownTimer countDownTimer;
    TextToSpeech textToSpeech14;


    SharedPreferences sharedPreferences14;
    SharedPreferences.Editor editor14;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_year_model2);


        radio_g = (RadioGroup) findViewById(R.id.answersgrp);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);


        // three bottom button
        next_question = findViewById(R.id.right_next_quetion_btn_2014);
        left_prevision_question = findViewById(R.id.left_prevoius_btn_2014);
        show_answer_hint = findViewById(R.id.hint_show_answer_btn_2014);


        // explanation
        explanation14 = findViewById(R.id.text_explanation);
        sub_explanation_text14 = findViewById(R.id.text_explanation_word_sub14);
        explain = findViewById(R.id.speaker14);

        back = findViewById(R.id.home_year_2014);

        //Question
        questiontextview = findViewById(R.id.text_view_questionTv14);


        // disable visability
        left_prevision_question.setVisibility(View.GONE);
        explanation14.setVisibility(View.GONE);
        sub_explanation_text14.setVisibility(View.GONE);
        explain.setVisibility(View.GONE);


        // Ans image
        A_ans_righ = findViewById(R.id.A_ans_right);
        B_ans_righ = findViewById(R.id.B_ans_right);
        C_ans_righ = findViewById(R.id.C_ans_right);
        D_ans_righ = findViewById(R.id.D_ans_right);


        // Ans image
        A_ans_wron = findViewById(R.id.A_ans_wrong);
        B_ans_wron = findViewById(R.id.B_ans_wrong);
        C_ans_wron = findViewById(R.id.C_ans_wrong);
        D_ans_wron = findViewById(R.id.D_ans_wrong);


        //Questionn count

        questioncount = findViewById(R.id.text_view_question_count14);


        questioncount.setText("Question: 1/" + totalQuetion14);
        totalQues = findViewById(R.id.question_all_year14);
        // submit
        submitBtn = findViewById(R.id.submit_2014);
        calculate = findViewById(R.id.calculateyear14);

        book = findViewById(R.id.bookmark14);

        totalQues.setText("All Ques : " + totalQuetion14);


    }    }