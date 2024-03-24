package com.example.oaupost_utme.Account_Restult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oaupost_utme.Account_Years.Year_model_1;
import com.example.oaupost_utme.R;
import com.example.oaupost_utme.Starting_Accunt_Page.start_accoun_year_1_past_question;

import java.text.DateFormat;
import java.util.Calendar;

public class year1_result extends AppCompatActivity {

    TextView result, tv_name, to_time,tv_pohone, tv_sex,tv_score, tv_sub_topic, tv_total_quesiton,tv_correct, tv_wrong, tv_total_time;


    public static int score;


    private static  final  String KEY_GENDER="sex";

    private static  final  String KEY_phone ="phone";
    SharedPreferences sharedPreferences;
    private static  final  String KEY_NAME = "name";
    private static  final  String SHARED_PREF_NAME ="mypres";



    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year1_result);

        tv_name = (TextView)findViewById(R.id.student_name);
        tv_pohone = (TextView)findViewById(R.id.student_phone_number);
        tv_score = (TextView)findViewById(R.id.student_score);
        tv_sex = (TextView)findViewById(R.id.gender);
        tv_sub_topic = (TextView)findViewById(R.id.student_topic);
        tv_total_quesiton = (TextView)findViewById(R.id.total_ques);
        tv_correct = (TextView)findViewById(R.id.correct_select);
        tv_wrong = (TextView)findViewById(R.id.wrong_select);
        tv_total_time = (TextView)findViewById(R.id.total_time);

       result = (TextView)findViewById(R.id.grade);

       to_time = (TextView)findViewById(R.id.total_time_all_time_togetther);

        back = findViewById(R.id.home_year_15_re);


        to_time.setText("30 min");



        Calendar calendar = Calendar.getInstance();

        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        tv_total_time.setText("Today " + " "+" :" + " "+currentDate);





        tv_total_quesiton.setText("Total question" + " " +":"+ " " +"18");

        tv_sub_topic.setText("Topic " +" "+ ":"+" " +"finacial account" + " " + " "+"model I");


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), start_accoun_year_1_past_question.class);
                startActivity(in);

            }
        });





        sharedPreferences =getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME,null);
        String phone = sharedPreferences.getString(KEY_phone,null);
        String gender = sharedPreferences.getString(KEY_GENDER,null);


        if (name != null || phone !=null || gender !=null) {

            tv_name.setText("Student Name : " +name);
            tv_pohone.setText("Contact : "+ phone);
            tv_sex.setText("Gender : "+ gender);


        }







        StringBuffer sb = new StringBuffer();
        sb.append(Year_model_1.correct );
        StringBuffer sb2 = new StringBuffer();
        sb2.append(Year_model_1.wrong );
        StringBuffer sb3 = new StringBuffer();
        sb3.append(Year_model_1.correct );
        tv_correct.setText(sb);
        tv_wrong.setText(sb2);
        tv_score.setText(sb3);
       Year_model_1.correct=0;
        Year_model_1.wrong=0;






        if (score > 15) {


            result.setText("ELIGIBLE FOR ADMISSION");
            result.setTextColor(Color.parseColor("GREEN"));
        } else {

            result.setText("NOT ELIGIBLE FOR ADMISSION");
            result.setTextColor(Color.parseColor("RED"));

        }





    }

}
