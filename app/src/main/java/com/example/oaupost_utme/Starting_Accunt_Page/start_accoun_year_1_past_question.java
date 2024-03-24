package com.example.oaupost_utme.Starting_Accunt_Page;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oaupost_utme.Account_Restult.year1_result;
import com.example.oaupost_utme.Account_Years.Year_model_1;
import com.example.oaupost_utme.All_Year_fiil_result_form.account_fill_year;
import com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2015_acccount;
import com.example.oaupost_utme.R;
import com.example.oaupost_utme.past_questiona.past_question_account;

import java.util.Calendar;

public class start_accoun_year_1_past_question extends AppCompatActivity {

    EditText set_time;

    private TimePickerDialog timePickerDialog;

    ImageView back;
    public int name;
    private TextView textViewHighscore,time1;

    int totalQuetion15 = QuestionAnswer_2015_acccount.question15.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sartaccount_past_question);

        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        textViewHighscore = findViewById(R.id.question);
        back = findViewById(R.id.back_start_year1);






        textViewHighscore.setText("Total question : " +totalQuetion15);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(start_accoun_year_1_past_question.this, past_question_account.class);
                startActivity(intent);


            }
        });


        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(start_accoun_year_1_past_question.this, Year_model_1.class);

                startActivity(intent);

            }

        });
    }


}