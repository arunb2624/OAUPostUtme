package com.example.oaupost_utme.Account_Years;

import static com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2013_acccount.correctAnswer13;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oaupost_utme.Account_Restult.year3_result;
import com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2013_acccount;
import com.example.oaupost_utme.R;
import com.example.oaupost_utme.Starting_Accunt_Page.start_accoun_year_3_past_question;
import com.example.oaupost_utme.caculator_account.calculator_year_3;

import java.util.Locale;
import java.util.Objects;

public class Year_model_3 extends AppCompatActivity {

    int currentExplantionIndex_Sub13 = 0;
    ImageView explain13;
    TextToSpeech textToSpeech13;
    TextView explanation13, sub_explanation_text13;

    public static int marks13 = 0, correct13 = 0, wrong13 = 0;
    TextView totalQues, questiontextview, questioncount, tvScore;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;
    ImageView show_answer_hint, calculate, left_prevision_question, next_question;
    ImageView A_ans_righ, B_ans_righ, C_ans_righ, D_ans_righ;
    ImageView A_ans_wron, B_ans_wron, C_ans_wron, D_ans_wron;

    int score13 = 0;
    int totalQuetion13 = QuestionAnswer_2013_acccount.question13.length;
    int currentQuestionIndex13 = 0;
    String selectedAnswer13 = "";
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    private TextView timerTextview;
    private CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_year_model3);


        // three  bottom button
        next_question = findViewById(R.id.right_next_quetion_btn_2013);
        left_prevision_question = findViewById(R.id.left_prevoius_btn_2013);
        show_answer_hint = findViewById(R.id.hint_show_answer_btn_2013);


        // Score
        tvScore = findViewById(R.id.scoreTV_2013);


        // explanation
        explanation13 = findViewById(R.id.text_explanation13);
        sub_explanation_text13 = findViewById(R.id.text_explanation_word_sub13);
        explain13 = findViewById(R.id.speaker13);


        //Question
        questiontextview = findViewById(R.id.text_view_questionTv13);


        timerTextview = findViewById(R.id.timer_2013);

        left_prevision_question.setVisibility(View.GONE);
        explanation13.setVisibility(View.GONE);
        sub_explanation_text13.setVisibility(View.GONE);
        explain13.setVisibility(View.GONE);


        //Options
        ansA = findViewById(R.id.option_a_2013);
        ansB = findViewById(R.id.option_b_2013);
        ansC = findViewById(R.id.option_c_2013);
        ansD = findViewById(R.id.option_d_2013);

        // Ans image
        A_ans_righ = findViewById(R.id.A_ans_right13);
        B_ans_righ = findViewById(R.id.B_ans_right13);
        C_ans_righ = findViewById(R.id.C_ans_right13);
        D_ans_righ = findViewById(R.id.D_ans_right13);


        // Ans image
        A_ans_wron = findViewById(R.id.A_ans_wrong13);
        B_ans_wron = findViewById(R.id.B_ans_wrong13);
        C_ans_wron = findViewById(R.id.C_ans_wrong13);
        D_ans_wron = findViewById(R.id.D_ans_wrong13);

        //Questionn count
        questioncount = findViewById(R.id.text_view_question_count13);

        totalQues = findViewById(R.id.timefor_question13);
        // submit
        submitBtn = findViewById(R.id.submit_2013);
        ImageView backHome = findViewById(R.id.home_year_2013);
        calculate = findViewById(R.id.calculateyear13);


        // to update score
        tvScore.setText("Score: " + score13);


        textToSpeech13 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech13.setLanguage(Locale.ENGLISH);
                }

            }
        });

        // speaker
        explain13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.requireNonNull(sub_explanation_text13.getText().toString().isEmpty())) {
                    Toast.makeText(Year_model_3.this, "null", Toast.LENGTH_SHORT).show();
                } else {
                    textToSpeech13.speak(sub_explanation_text13.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);

                }

            }
        });


        countDownTimer = new CountDownTimer(1800000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                int minutes = (int) (millisUntilFinished / 1000) / 60;

                int seconds = (int) (millisUntilFinished / 1000) % 60;

                String timeeleftformateted = String.format("%02d : %02d", minutes, seconds);

                timerTextview.setText(timeeleftformateted);

                if(millisUntilFinished  < 900000){
                    timerTextview.setTextColor(Color.parseColor("red"));
                }

               }

            @Override
            public void onFinish() {

                timerTextview.setText("00:00");
                timerTextview.setTextColor(Color.parseColor("red"));
                Toast.makeText(Year_model_3.this, "O.A.U Management Time is expired", Toast.LENGTH_SHORT).show();
                finishQuiz();

            }
        }.start();


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), calculator_year_3.class);
                startActivity(intent);


            }
        });


        // answer hint button
        show_answer_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                explanation13.setVisibility(View.VISIBLE);
                sub_explanation_text13.setVisibility(View.VISIBLE);
                explain13.setVisibility(View.VISIBLE);

                if (ansA.getText().toString().equals(correctAnswer13[currentQuestionIndex13])) {
                    ansA.setBackgroundColor(getResources().getColor(R.color.green));
                    A_ans_righ.setVisibility(View.VISIBLE);

                } else {
                    ansA.setBackgroundColor(getResources().getColor(R.color.red));
                    A_ans_wron.setVisibility(View.VISIBLE);
                }

                if (ansB.getText().toString().equals(correctAnswer13[currentQuestionIndex13])) {
                    ansB.setBackgroundColor(getResources().getColor(R.color.green));
                    B_ans_righ.setVisibility(View.VISIBLE);
                } else {
                    ansB.setBackgroundColor(getResources().getColor(R.color.red));
                    B_ans_wron.setVisibility(View.VISIBLE);

                }

                if (ansC.getText().toString().equals(correctAnswer13[currentQuestionIndex13])) {
                    ansC.setBackgroundColor(getResources().getColor(R.color.green));
                    C_ans_righ.setVisibility(View.VISIBLE);

                } else {
                    ansC.setBackgroundColor(getResources().getColor(R.color.red));
                    C_ans_wron.setVisibility(View.VISIBLE);
                }

                if (ansD.getText().toString().equals(correctAnswer13[currentQuestionIndex13])) {
                    ansD.setBackgroundColor(getResources().getColor(R.color.green));
                    D_ans_righ.setVisibility(View.VISIBLE);
                } else {
                    ansD.setBackgroundColor(getResources().getColor(R.color.red));
                    D_ans_wron.setVisibility(View.VISIBLE);
                }


            }
        });


        // options code
        ansA.setOnClickListener(v -> {
            selectedAnswer13 = ansA.getText().toString();
            if (selectedAnswer13.equals(correctAnswer13[currentQuestionIndex13])) {
                ansA.setBackgroundColor(getResources().getColor(R.color.green));
                correct13++;
                marks13++;

            } else {
                ansA.setBackgroundColor(getResources().getColor(R.color.red));

                wrong13++;
            }

        });
        ansB.setOnClickListener(v -> {
            selectedAnswer13 = ansB.getText().toString();
            if (selectedAnswer13.equals(correctAnswer13[currentQuestionIndex13])) {
                ansB.setBackgroundColor(getResources().getColor(R.color.green));
                correct13++;
                marks13++;


            } else {
                ansB.setBackgroundColor(getResources().getColor(R.color.red));

                wrong13++;

            }
        });
        ansC.setOnClickListener(v -> {
            selectedAnswer13 = ansC.getText().toString();
            if (selectedAnswer13.equals(correctAnswer13[currentQuestionIndex13])) {
                ansC.setBackgroundColor(getResources().getColor(R.color.green));
                correct13++;
                marks13++;

            } else {
                ansC.setBackgroundColor(getResources().getColor(R.color.red));

                wrong13++;
            }
        });
        ansD.setOnClickListener(v -> {
            selectedAnswer13 = ansD.getText().toString();
            if (selectedAnswer13.equals(correctAnswer13[currentQuestionIndex13])) {
                ansD.setBackgroundColor(getResources().getColor(R.color.green));
                correct13++;
                marks13++;
            } else {
                ansD.setBackgroundColor(getResources().getColor(R.color.red));

                wrong13++;


            }
        });


        //Submit button
        submitBtn.setOnClickListener(v -> {
            ansA.setBackgroundColor(Color.WHITE);
            ansB.setBackgroundColor(Color.WHITE);
            ansC.setBackgroundColor(Color.WHITE);
            ansD.setBackgroundColor(Color.WHITE);

            // sow info
            shownotice1();


        });


        // back home
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shownotice();


            }
        });


        totalQues.setText("Ques : " + totalQuetion13);

        // question count
        int quesNumber = currentQuestionIndex13+ 1;
        questioncount.setText(" " + "Question : " + quesNumber + "/" + QuestionAnswer_2013_acccount.question13.length);


        loadNewQuestion();


    }

    // notice before submit
    private void shownotice1() {


        builder = new AlertDialog.Builder(Year_model_3.this);
        builder.setIcon(R.drawable.newoau);
        builder.setTitle("O.A.U Campus Management");
        builder.setMessage("Are you sure you want to submit");
        builder.setCancelable(true);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (currentQuestionIndex13 == QuestionAnswer_2013_acccount.question13.length - 1) {
                    finishQuiz();
                } else {
                    Toast.makeText(Year_model_3.this, "O.A.U MANAGEMENT\nplease complete the Test", Toast.LENGTH_SHORT).show();
                }
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


    //back complete code
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(Year_model_3.this, start_accoun_year_3_past_question.class));
        finish();
    }


    //load next question
    void loadNewQuestion() {


        if (currentQuestionIndex13 == totalQuetion13) {


            finishQuiz();
            return;
        }

        questiontextview.setText(QuestionAnswer_2013_acccount.question13[currentQuestionIndex13]);

        sub_explanation_text13.setText(QuestionAnswer_2013_acccount.explanation13[currentExplantionIndex_Sub13]);


        // next button
        next_question.setOnClickListener(v -> {
            left_prevision_question.setVisibility(View.VISIBLE);

            if (selectedAnswer13.equals("")) {
                Toast.makeText(Year_model_3.this, "O.A.U MANAGEMENT\nplease select an option", Toast.LENGTH_SHORT).show();
            } else {

                if (currentQuestionIndex13 == QuestionAnswer_2013_acccount.question13.length - 1) {
                    next_question.setVisibility(View.GONE);

                } else {
                    currentQuestionIndex13++;

                    currentExplantionIndex_Sub13++;
                    ansA.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][0]);
                    ansB.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][1]);
                    ansC.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][2]);
                    ansD.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][3]);

                    ansA.setBackgroundColor(getResources().getColor(R.color.white));
                    ansB.setBackgroundColor(getResources().getColor(R.color.white));
                    ansC.setBackgroundColor(getResources().getColor(R.color.white));
                    ansD.setBackgroundColor(getResources().getColor(R.color.white));
                    A_ans_righ.setVisibility(View.GONE);
                    B_ans_righ.setVisibility(View.GONE);
                    C_ans_righ.setVisibility(View.GONE);
                    D_ans_righ.setVisibility(View.GONE);
                    A_ans_wron.setVisibility(View.GONE);
                    B_ans_wron.setVisibility(View.GONE);
                    C_ans_wron.setVisibility(View.GONE);
                    D_ans_wron.setVisibility(View.GONE);
                    sub_explanation_text13.setVisibility(View.GONE);
                    explanation13.setVisibility(View.GONE);
                    explain13.setVisibility(View.GONE);

                    if (selectedAnswer13.equals(correctAnswer13[currentQuestionIndex13 - 1])) {

                        score13++;
                        tvScore.setText("Score: " + score13);
                        selectedAnswer13 = "";


                        loadNewQuestion();

                    }

                    questiontextview.setText(QuestionAnswer_2013_acccount.question13[currentQuestionIndex13]);
                    sub_explanation_text13.setText(QuestionAnswer_2013_acccount.explanation13[currentExplantionIndex_Sub13]);
                }

                int quesNumber = currentQuestionIndex13 + 1;

                ansA.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][0]);
                ansB.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][1]);
                ansC.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][2]);
                ansD.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][3]);

                ansA.setBackgroundColor(getResources().getColor(R.color.white));
                ansB.setBackgroundColor(getResources().getColor(R.color.white));
                ansC.setBackgroundColor(getResources().getColor(R.color.white));
                ansD.setBackgroundColor(getResources().getColor(R.color.white));
                A_ans_righ.setVisibility(View.GONE);
                B_ans_righ.setVisibility(View.GONE);
                C_ans_righ.setVisibility(View.GONE);
                D_ans_righ.setVisibility(View.GONE);
                A_ans_wron.setVisibility(View.GONE);
                B_ans_wron.setVisibility(View.GONE);
                C_ans_wron.setVisibility(View.GONE);
                D_ans_wron.setVisibility(View.GONE);
                sub_explanation_text13.setVisibility(View.GONE);
                explanation13.setVisibility(View.GONE);
                explain13.setVisibility(View.GONE);

                questioncount.setText(" " + "Question : " + quesNumber + "/" + QuestionAnswer_2013_acccount.question13.length);
            }


        });


        //left button
        left_prevision_question.setOnClickListener(v -> {

            next_question.setVisibility(View.VISIBLE);
            if (currentQuestionIndex13 == 0) {
                Toast.makeText(Year_model_3.this, "O.A.U MANAGEMENT\nit's the first question", Toast.LENGTH_SHORT).show();
            } else {

                currentQuestionIndex13++;
                currentExplantionIndex_Sub13++;
                ansA.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][0]);
                ansB.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][1]);
                ansC.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][2]);
                ansD.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][3]);

                ansA.setBackgroundColor(getResources().getColor(R.color.white));
                ansB.setBackgroundColor(getResources().getColor(R.color.white));
                ansC.setBackgroundColor(getResources().getColor(R.color.white));
                ansD.setBackgroundColor(getResources().getColor(R.color.white));
                A_ans_righ.setVisibility(View.GONE);
                B_ans_righ.setVisibility(View.GONE);
                C_ans_righ.setVisibility(View.GONE);
                D_ans_righ.setVisibility(View.GONE);
                A_ans_wron.setVisibility(View.GONE);
                B_ans_wron.setVisibility(View.GONE);
                C_ans_wron.setVisibility(View.GONE);
                D_ans_wron.setVisibility(View.GONE);
                sub_explanation_text13.setVisibility(View.GONE);
                explanation13.setVisibility(View.GONE);
                explain13.setVisibility(View.GONE);
                questiontextview.setText(QuestionAnswer_2013_acccount.question13[currentQuestionIndex13]);

                sub_explanation_text13.setText(QuestionAnswer_2013_acccount.explanation13[currentExplantionIndex_Sub13]);
            }
            int quesNumber = currentQuestionIndex13 + 1;

            ansA.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][0]);
            ansB.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][1]);
            ansC.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][2]);
            ansD.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][3]);
            ansA.setBackgroundColor(getResources().getColor(R.color.white));
            ansB.setBackgroundColor(getResources().getColor(R.color.white));
            ansC.setBackgroundColor(getResources().getColor(R.color.white));
            ansD.setBackgroundColor(getResources().getColor(R.color.white));
            A_ans_righ.setVisibility(View.GONE);
            B_ans_righ.setVisibility(View.GONE);
            C_ans_righ.setVisibility(View.GONE);
            D_ans_righ.setVisibility(View.GONE);
            A_ans_wron.setVisibility(View.GONE);
            B_ans_wron.setVisibility(View.GONE);
            C_ans_wron.setVisibility(View.GONE);
            D_ans_wron.setVisibility(View.GONE);
            sub_explanation_text13.setVisibility(View.GONE);
            explanation13.setVisibility(View.GONE);
            explain13.setVisibility(View.GONE);


            questioncount.setText(" " + "Question : " + quesNumber + "/" + QuestionAnswer_2013_acccount.question13.length);
        });



        ansA.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][0]);
        ansB.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][1]);
        ansC.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][2]);
        ansD.setText(QuestionAnswer_2013_acccount.choice13[currentQuestionIndex13][3]);


    }


    // finish quetion
    void finishQuiz() {


        new AlertDialog.Builder(this)
                .setTitle("O.A.U POST-UTME SCREENING RESULT  GRADE ")
                .setIcon(R.drawable.newoau)
                .setMessage("From Obafemi Awolowo University O.A.U\n\nStudent screening result\n\nDear User\naggreagate = " + score13 + "  / " + totalQuetion13)
                .setPositiveButton("Restart ", (dialog, i) -> restartQuiz())

                .setNegativeButton("View Result", ((dialog, which) -> go_result_page()))
                .setNeutralButton("Quit", (dialog, which) -> quit_test())
                .setCancelable(false)
                .show();

    }

    private void quit_test() {
        Intent intent = new Intent(getApplicationContext(), start_accoun_year_3_past_question.class);
        startActivity(intent);
    }

    private void go_result_page() {

        Intent intent = new Intent(getApplicationContext(), year3_result.class);
        intent.putExtra("score13",score13);
        year3_result.score13 = score13;
        startActivity(intent);




    }

    // start again
    void restartQuiz() {
        finish();
        startActivity(getIntent());
    }

    // show notice when going back
    private void shownotice() {

        builder = new AlertDialog.Builder(Year_model_3.this);
        builder.setIcon(R.drawable.newoau);
        builder.setTitle("O.A.U Campus Management");
        builder.setMessage("Are you sure you want to exit");
        builder.setCancelable(true);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                onBackPressed();
                Intent intent = new Intent(getApplicationContext(), start_accoun_year_3_past_question.class);
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

    @Override
    protected void onPause() {
        if (textToSpeech13 != null) {
            textToSpeech13.stop();

        }
        super.onPause();
    }
}