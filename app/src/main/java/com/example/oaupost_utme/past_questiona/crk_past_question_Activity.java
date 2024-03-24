package com.example.oaupost_utme.past_questiona;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oaupost_utme.R;

public class crk_past_question_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crk_past_question);

        ImageView imageView = findViewById(R.id.back_image_crk);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();


            }
        });

        ListView listView = findViewById(R.id.listview_crk);



        final  String[] texts = {"Model I","Model II","Model III","Model IV","Model V","Model VI"};

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,texts);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                  //      Intent intent = new Intent(crk_past_question_Activity.this, year_2015_crk_activity.class);
                    //    startActivity(intent);
                        break;

                //    case 1:
                  //      Intent intent1 = new Intent(biology_past_question_Activity.this, year_2014_bio_activity.class);
                    //    startActivity(intent1);
                      //  break;

                    //case 2:
                      //  Intent intent2 = new Intent(biology_past_question_Activity.this, year_2013_bio_activity.class);
                        //startActivity(intent2);
                        //break;

                    //case 3:
                      //  Intent intent3 = new Intent(biology_past_question_Activity.this, year_2012_bio_activity.class);
                        //startActivity(intent3);
                        //break;

                    //case 4:
                      //  Intent intent4 = new Intent(biology_past_question_Activity.this, year_2011_bio_activity.class);
                        //startActivity(intent4);
                        //break;



                    //case 5:
                        //Intent intent5 = new Intent(biology_past_question_Activity.this, year_2010_bio_activity.class);
                       // startActivity(intent5);
                        //break;

                }
            }
        });
    }
}