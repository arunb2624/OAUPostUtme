
package com.example.oaupost_utme.Account_Years;

import static com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2014_acccount.correctAnswer2014;
import static com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2015_acccount.correctAnswer15;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oaupost_utme.Account_Restult.year1_result;
import com.example.oaupost_utme.Account_Restult.year2_result;
import com.example.oaupost_utme.All_Year_fiil_result_form.account_fill_year;
import com.example.oaupost_utme.Bookmark_Activity;
import com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2014_acccount;
import com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2015_acccount;
import com.example.oaupost_utme.MainActivity;
import com.example.oaupost_utme.R;
import com.example.oaupost_utme.Report_Error;
import com.example.oaupost_utme.Starting_Accunt_Page.start_accoun_year_1_past_question;
import com.example.oaupost_utme.Starting_Accunt_Page.start_accoun_year_2_past_question;
import com.example.oaupost_utme.caculator_account.calculator_account_year1;
import com.example.oaupost_utme.caculator_account.calculator_year_2;
import com.example.oaupost_utme.exam;

import java.util.Locale; import java.util.Objects;

public class Year_model_1 extends AppCompatActivity {




    public static int marks = 0, correct = 0, wrong = 0;


    private RadioGroup radio_g;
    private int name;
    private RadioButton rb1, rb2, rb3, rb4;

    ImageView explain;
    TextView explanation, sub_explanation_text,course_Name;

    private TextView totalQues, questiontextview, questioncount, tvScore;

    Button show_answer_hint, submitBtn;
    ImageView calculate, left_prevision_question, next_question,back,book;
    ImageView A_ans_righ, B_ans_righ, C_ans_righ, D_ans_righ;
    ImageView A_ans_wron, B_ans_wron, C_ans_wron, D_ans_wron;


    int score = 0;
    int totalQuetion15 = QuestionAnswer_2015_acccount.question15.length;
    private int currentQuestionIndex15 = 0;
    int currentExplantionIndex_Sub15 = 0;
    String selectedAnswer15 = "";
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    private TextView timerTextview;
    private CountDownTimer countDownTimer;
    TextToSpeech textToSpeech;


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;



    @SuppressLint({"WrongViewCast", "MissingInﬂatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year_model1);


        radio_g = (RadioGroup) findViewById(R.id.answersgrp);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);


        // three  bottom button
        next_question = findViewById(R.id.right_next_quetion_btn_2015);
        left_prevision_question = findViewById(R.id.left_prevoius_btn_2015);
        show_answer_hint = findViewById(R.id.hint_show_answer_btn_2015);


        // explanation
        explanation = findViewById(R.id.text_explanation);
        sub_explanation_text = findViewById(R.id.text_explanation_word_sub);
        explain = findViewById(R.id.speaker15);

        back = findViewById(R.id.home_year_2015);




        //Question
        questiontextview = findViewById(R.id.text_view_questionTv15);



        // disable visability
        left_prevision_question.setVisibility(View.GONE);
        explanation.setVisibility(View.GONE);
        sub_explanation_text.setVisibility(View.GONE);
        explain.setVisibility(View.GONE);



        course_Name = findViewById(R.id.course_name);

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

        book=findViewById(R.id.bookmark15);

        //Questionn count

        questioncount = findViewById(R.id.text_view_question_count15);


        questioncount.setText("Question: 1/" + totalQuetion15);


        // submit

        calculate = findViewById(R.id.calculateyear);

        course_Name.setText("ACCOUNTS");


        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(Year_model_1.this,book);
                popupMenu.getMenuInflater().inflate(R.menu.bookmark,popupMenu.getMenu());



                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id = item.getItemId();

                        if (id == R.id.bookmark_1){



                            builder = new AlertDialog.Builder(Year_model_1.this);
                            builder.setIcon(R.drawable.newoau);
                            builder.setTitle("O.A.U Campus Management");
                            builder.setMessage("did you want to save this question to bookmark");
                            builder.setCancelable(true);
                            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    saveToMarkBook();
                                    alertDialog.cancel();


                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    alertDialog.cancel();
                                }
                            });

                            alertDialog = builder.create();
                            alertDialog.show();



                        } else if (id == R.id.report) {
                            // write a code to open my whatsapp


                            Intent intent = new Intent (Year_model_1.this, Report_Error.class);
                            startActivity(intent);

                        } else if (id == R.id.quit) {

                            Intent intent = new Intent (Year_model_1.this, start_accoun_year_1_past_question.class);
                            editor.clear();
                            editor.apply();
                            startActivity(intent);

                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });


        sharedPreferences = getSharedPreferences("year1", 0);



        radio_g.clearCheck();
        editor = sharedPreferences.edit();


       // Intent intent = getIntent();
        //int time = intent.getIntExtra("time", 0);



        // options code
        rb1.setOnClickListener(v -> {
            selectedAnswer15 = rb1.getText().toString();
            if (selectedAnswer15.equals(correctAnswer15[currentQuestionIndex15])) {

                correct++;
                marks++;
                score++;

            } else {

                wrong++;
            }

        });
        rb2.setOnClickListener(v -> {
            selectedAnswer15 = rb2.getText().toString();
            if (selectedAnswer15.equals(correctAnswer15[currentQuestionIndex15])) {

                correct++;
                score++;
                marks++;


            } else {

                wrong++;

            }
        });
        rb3.setOnClickListener(v -> {
            selectedAnswer15 = rb3.getText().toString();
            if (selectedAnswer15.equals(correctAnswer15[currentQuestionIndex15])) {
                correct++;
                marks++;
                score++;

            } else {
                wrong++;
            }
        });
        rb4.setOnClickListener(v -> {
            selectedAnswer15 = rb4.getText().toString();
            if (selectedAnswer15.equals(correctAnswer15[currentQuestionIndex15])) {
                correct++;
                marks++;
                score++;
            } else {

                wrong++;


            }
        });




        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);

                }

            }
        });

        // speaker
        explain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.requireNonNull(sub_explanation_text.getText().toString().isEmpty())) {
                    Toast.makeText(Year_model_1.this, "null", Toast.LENGTH_SHORT).show();
                } else {


                    textToSpeech.speak("you can't crak this one " + "  " +"This is the explanation " + sub_explanation_text.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);

                }

            }
        });






        // answer hint button
        show_answer_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                explanation.setVisibility(View.VISIBLE);
                sub_explanation_text.setVisibility(View.VISIBLE);
                explain.setVisibility(View.VISIBLE);

                if (rb1.getText().toString().equals(correctAnswer15[currentQuestionIndex15])) {
                    A_ans_righ.setVisibility(View.VISIBLE);

                } else {
                    A_ans_wron.setVisibility(View.VISIBLE);
                }

                if (rb2.getText().toString().equals(correctAnswer15[currentQuestionIndex15])) {
                    B_ans_righ.setVisibility(View.VISIBLE);
                } else {
                    B_ans_wron.setVisibility(View.VISIBLE);

                }

                if (rb3.getText().toString().equals(correctAnswer15[currentQuestionIndex15])) {
                    C_ans_righ.setVisibility(View.VISIBLE);

                } else {
                    C_ans_wron.setVisibility(View.VISIBLE);
                }

                if (rb4.getText().toString().equals(correctAnswer15[currentQuestionIndex15])) {
                    D_ans_righ.setVisibility(View.VISIBLE);
                } else {
                    D_ans_wron.setVisibility(View.VISIBLE);
                }
            }
        });



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), calculator_account_year1.class);
                startActivity(intent);


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shownotice();



            }
        });

        radio_g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton) {
                    editor.putInt(String.valueOf(currentQuestionIndex15), 1);
                } else if (checkedId == R.id.radioButton2) {
                    editor.putInt(String.valueOf(currentQuestionIndex15), 2);

                } else if (checkedId == R.id.radioButton3) {
                    editor.putInt(String.valueOf(currentQuestionIndex15), 3);


                } else if (checkedId == R.id.radioButton4) {
                    editor.putInt(String.valueOf(currentQuestionIndex15), 4);
                }
                editor.commit();
            }
        });
        showQuestion(currentQuestionIndex15);


        next_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "O.A.U Management  Please select an option", Toast.LENGTH_SHORT).show();
                } else {
                    left_prevision_question.setVisibility(View.VISIBLE);

                if (currentQuestionIndex15 != totalQuetion15 - 1) {
                    currentQuestionIndex15++;
                    currentExplantionIndex_Sub15++;
                    showQuestion(currentQuestionIndex15);
                    A_ans_righ.setVisibility(View.GONE);
                    B_ans_righ.setVisibility(View.GONE);
                    C_ans_righ.setVisibility(View.GONE);
                    D_ans_righ.setVisibility(View.GONE);
                    A_ans_wron.setVisibility(View.GONE);
                    B_ans_wron.setVisibility(View.GONE);
                    C_ans_wron.setVisibility(View.GONE);
                    D_ans_wron.setVisibility(View.GONE);
                    sub_explanation_text.setVisibility(View.GONE);
                    explanation.setVisibility(View.GONE);
                    explain.setVisibility(View.GONE);


                    questioncount.setText("Question: " + (currentQuestionIndex15 + 1) + "/" + totalQuetion15);
                } else {
                    next_question.setVisibility(View.GONE);
                    finishQuiz();
                    Toast.makeText(Year_model_1.this, "O.A.U Management you have complete this model ", Toast.LENGTH_SHORT).show();


                }
            }
        }

        });
        left_prevision_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   if (radio_g.getCheckedRadioButtonId() == -1) {
                     Toast.makeText(getApplicationContext(), "O.A.U Management Please select an option before going back", Toast.LENGTH_SHORT).show();
                   }else {
                       next_question.setVisibility(View.VISIBLE);
                       if (currentQuestionIndex15 == 0) {
                           Toast.makeText(Year_model_1.this, "O.A.U MANAGEMENT\nit's the first question", Toast.LENGTH_SHORT).show();

                           left_prevision_question.setVisibility(View.GONE);
                       } else {
                           if (currentQuestionIndex15 != 0) {
                               currentQuestionIndex15--;

                               currentExplantionIndex_Sub15--;
                           }
                           A_ans_righ.setVisibility(View.GONE);
                           B_ans_righ.setVisibility(View.GONE);
                           C_ans_righ.setVisibility(View.GONE);
                           D_ans_righ.setVisibility(View.GONE);
                           A_ans_wron.setVisibility(View.GONE);
                           B_ans_wron.setVisibility(View.GONE);
                           C_ans_wron.setVisibility(View.GONE);
                           D_ans_wron.setVisibility(View.GONE);
                           sub_explanation_text.setVisibility(View.GONE);
                           explanation.setVisibility(View.GONE);
                           explain.setVisibility(View.GONE);
                           showQuestion(currentQuestionIndex15);
                           questioncount.setText("Question: " + (currentQuestionIndex15 + 1) + "/" + totalQuetion15);

                       }

                   }
            }

        });
    }




    // save to mark book

    private void saveToMarkBook() {








    }





















    private void shownotice() {



        builder = new AlertDialog.Builder(Year_model_1.this);
        builder.setIcon(R.drawable.newoau);
        builder.setTitle("O.A.U Campus Management");
        builder.setMessage("Are you sure you want to exit");
        builder.setCancelable(true);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                onBackPressed();
                Intent intent = new Intent(getApplicationContext(), start_accoun_year_1_past_question.class);
                editor.clear();
                editor.apply();
                startActivity(intent);
                alertDialog.cancel();


            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.cancel();
            }
        });

        alertDialog = builder.create();
        alertDialog.show();
    }


    private void showQuestion(int currentIndex) {
        questiontextview.setText(QuestionAnswer_2015_acccount.question15[currentQuestionIndex15]);
        sub_explanation_text.setText(QuestionAnswer_2015_acccount.explanation15[currentExplantionIndex_Sub15]);

        rb1.setText(QuestionAnswer_2015_acccount.choice15[currentIndex][0]);
        rb2.setText(QuestionAnswer_2015_acccount.choice15[currentIndex][1]);
        rb3.setText(QuestionAnswer_2015_acccount.choice15[currentIndex][2]);
        rb4.setText(QuestionAnswer_2015_acccount.choice15[currentIndex][3]);


        int choice = sharedPreferences.getInt(String.valueOf(currentIndex), 5);
        Log.d("showQuestion", currentIndex + " showQuestion: " + choice);
        if (choice == 1) {
            rb1.setChecked(true);
        } else if (choice == 1) {
            rb2.setChecked(true);
        } else if (choice == 3) {
            rb3.setChecked(true);
        } else if (choice == 4) {
            rb4.setChecked(true);
        } else {
            radio_g.clearCheck();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        editor.clear();
        editor.apply();
    }


    private void finishQuiz() {
        new AlertDialog.Builder(this)
                .setTitle("O.A.U POST-UTME STUDY MODEL")
                .setIcon(R.drawable.newoau)
                .setMessage("From Obafemi Awolowo University O.A.U\n\nyou have complete this model "+"with " + totalQuetion15+" question")
                .setPositiveButton("Restart ", (dialog, i) -> restartQuiz())

                .setNegativeButton("Quit",(dialog, which) -> quit_test())
                .setCancelable(false)
                .show();
        editor.clear();
        editor.apply();

    }

    private void quit_test() {
        Intent intent = new Intent(getApplicationContext(), start_accoun_year_1_past_question.class);
        startActivity(intent);
        editor.clear();
        editor.apply();
    }
/*
    private void go_result_page() {

        Intent intent = new Intent(getApplicationContext(), year1_result.class);
        intent.putExtra("score",score);
        year1_result.score = score;
        startActivity(intent);
        editor.clear();
        editor.apply();





    }


 */
    // start again
    void restartQuiz() {
        finish();
        startActivity(getIntent());
        editor.clear();
        editor.apply();
    }


    @Override
    protected void onPause() {
        if (textToSpeech != null){
            textToSpeech.stop();


        }
        super.onPause();
    }

}