package com.example.oaupost_utme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2015_acccount;
import com.example.oaupost_utme.Starting_Accunt_Page.start_accoun_year_1_past_question;

public class Bookmark_Activity extends AppCompatActivity {

    ImageView back;

        private  RecyclerView questionview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        back = findViewById(R.id.back_book_mark);





        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        LinearLayoutManager linearManager = new LinearLayoutManager(this);
        linearManager.setOrientation(RecyclerView.VERTICAL);
        questionview.setLayoutManager(linearManager);


        BookMarkAdapter adapter = new BookMarkAdapter(QuestionAnswer_2015_acccount.question15);
        questionview.setAdapter(adapter);













    }
}