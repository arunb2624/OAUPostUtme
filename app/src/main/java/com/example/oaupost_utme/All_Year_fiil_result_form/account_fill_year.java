package com.example.oaupost_utme.All_Year_fiil_result_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.oaupost_utme.Account_Restult.year1_result;
import com.example.oaupost_utme.R;
import com.example.oaupost_utme.Starting_Accunt_Page.start_accoun_year_1_past_question;

public class account_fill_year extends AppCompatActivity {


    private static  final  String KEY_GENDER="sex";

    private static  final  String KEY_phone ="phone";
    SharedPreferences sharedPreferences;
    private static  final  String KEY_NAME = "name";
    private static  final  String SHARED_PREF_NAME ="mypres";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_fill_year);




        sharedPreferences =getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);


        Button startbutton=(Button)findViewById(R.id.button);
        final EditText nametext=(EditText)findViewById(R.id.editName);
        final EditText namephone=(EditText)findViewById(R.id.editphoneNumber);
        final EditText namegender=(EditText)findViewById(R.id.editgender);
        ImageView back = (ImageView) findViewById(R.id.fill_2014);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(account_fill_year.this, start_accoun_year_1_past_question.class);
                startActivity(intent);

            }
        });



        String name  = sharedPreferences.getString(KEY_NAME,null);
        String phone = sharedPreferences.getString(KEY_phone,null);
        String gender = sharedPreferences.getString(KEY_GENDER,null);
        if (name != null || phone !=null || gender !=null) {
            Intent intent = new Intent(account_fill_year.this, year1_result.class);
            startActivity(intent);
        }




        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = nametext.getText().toString();
                String phone = namephone.getText().toString();
                String gender = namegender.getText().toString();


                if (TextUtils.isEmpty(name)) {
                    nametext.setError("Please enter name..");
                    nametext.requestFocus();
                    Toast.makeText(account_fill_year.this, "Please enter your name..", Toast.LENGTH_SHORT).show();


                } else if (TextUtils.isEmpty(phone)) {
                    namephone.setError("Please enter phone no.");
                    namephone.requestFocus();

                    Toast.makeText(account_fill_year.this, "Please enter your phone number..", Toast.LENGTH_SHORT).show();


                } else if (phone.length() < 11) {

                    namephone.setError("Invalid phone no.");
                    namephone.requestFocus();

                } else if (phone.length() > 11) {

                    namephone.setError("Invalid phone no.");
                    namephone.requestFocus();

                } else if (name.length() < 10) {
                    nametext.setError("name must be 10 long");
                    nametext.requestFocus();


                } else if (name.length() > 12) {
                    nametext.setError("name is too  long");
                    nametext.requestFocus();

                } else if (gender.length() < 4) {
                    namegender.setError("gender is not valid e.g female or male");
                    namegender.requestFocus();


                } else if (gender.length() > 6) {
                    namegender.setError("Invalid gender e.g female or male");
                    namegender.requestFocus();


                } else {


                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_NAME, nametext.getText().toString());
                    editor.putString(KEY_phone, namephone.getText().toString());
                    editor.putString(KEY_GENDER, namegender.getText().toString());

                    editor.apply();

                    Intent mainIntent = new Intent(account_fill_year.this, year1_result.class);
                                        startActivity(mainIntent);

                }



            }
        });
    }}