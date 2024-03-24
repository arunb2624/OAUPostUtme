package com.example.oaupost_utme.past_questiona;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oaupost_utme.Account_Years.Year_model_4;
import com.example.oaupost_utme.Account_Years.Year_model_5;
import com.example.oaupost_utme.MainActivity;
import com.example.oaupost_utme.R;
import com.example.oaupost_utme.Starting_Accunt_Page.start_accoun_year_1_past_question;
import com.example.oaupost_utme.Starting_Accunt_Page.start_accoun_year_2_past_question;
import com.example.oaupost_utme.Starting_Accunt_Page.start_accoun_year_3_past_question;
import com.example.oaupost_utme.Starting_Accunt_Page.start_accoun_year_4_past_question;
import com.example.oaupost_utme.past_question;

public class past_question_account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_question_account);

        ImageView imageView = findViewById(R.id.back_image_account);




        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);



            }
        });



        ListView listView = findViewById(R.id.listview_account);

        final  String[] texts = {"Model I","Model II","Model III","Model IV","Model V"};
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,texts);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){

                    case 0:

                        Intent intent = new Intent(past_question_account.this, start_accoun_year_1_past_question.class);
                        startActivity(intent);
                        break;

                    case 1:

                        Intent intent1 = new Intent(past_question_account.this, start_accoun_year_2_past_question.class);
                        startActivity(intent1);   break;

                    case 2:

                        Intent intent2 = new Intent(past_question_account.this, start_accoun_year_3_past_question.class);
                        startActivity(intent2);   break;


                    case 3:

                        Intent intent3 = new Intent(past_question_account.this, start_accoun_year_4_past_question.class);
                        startActivity(intent3);   break;

                    case 4:

                        Intent intent4 = new Intent(past_question_account.this, Year_model_5.class);
                        startActivity(intent4);   break;





                }
            }
        });

    }
}