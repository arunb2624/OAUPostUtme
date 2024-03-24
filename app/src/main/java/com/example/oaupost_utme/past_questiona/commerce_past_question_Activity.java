package com.example.oaupost_utme.past_questiona;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oaupost_utme.R;

public class commerce_past_question_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commerce_past_question);

        ImageView imageView = findViewById(R.id.back_image_commerce);
      //  TextView textView = findViewById(R.id.exam_commerce);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();


            }
        });

        ListView listView = findViewById(R.id.listview_commerce);

        final  String[] texts = {"1990","1991","1992","1993","1994","1995","1995","1996","1997","1998","1999","2000","2001","2002"};
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,texts);
        listView.setAdapter(adapter);
    }
}