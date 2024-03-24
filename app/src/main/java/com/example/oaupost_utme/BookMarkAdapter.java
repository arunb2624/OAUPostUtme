package com.example.oaupost_utme;

import static com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2015_acccount.correctAnswer15;
import static com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2015_acccount.question15;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oaupost_utme.Class_account_past_question.QuestionAnswer_2015_acccount;

import java.util.Arrays;
import java.util.List;

public class BookMarkAdapter extends RecyclerView.Adapter<BookMarkAdapter.ViewHolder> {


    private String[] question;

    public BookMarkAdapter(String[] question){this.question = question;}



    @NonNull
    @Override
    public BookMarkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_book,parent,false);

        return new BookMarkAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookMarkAdapter.ViewHolder holder, int position) {

        String ques = QuestionAnswer_2015_acccount.question15[position];

        String a = Arrays.toString(QuestionAnswer_2015_acccount.choice15[1] );
        String b = Arrays.toString(QuestionAnswer_2015_acccount.choice15[2] );
        String c = Arrays.toString(QuestionAnswer_2015_acccount.choice15[3] );
        String d = Arrays.toString(QuestionAnswer_2015_acccount.choice15[4] );


        int ans = Integer.parseInt(correctAnswer15[position]);


        holder.setData(position,ques,a,b,c,d,ans);

    }

    @Override
    public int getItemCount() {
        return question.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView quesNo, quest, aop,bop,cop,dop,resultp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            quesNo = itemView.findViewById(R.id.questioncount1);
            quest = itemView.findViewById(R.id.questionsss);
            aop = itemView.findViewById(R.id.option1);
            bop = itemView.findViewById(R.id.option2);
            cop = itemView.findViewById(R.id.option3);
            dop = itemView.findViewById(R.id.option4);
            resultp = itemView.findViewById(R.id.answer);

        }
        private  void setData(int pos, String ques,String a,String b,String c,String d, int  ans)

        {


            quesNo.setText("Question No."+String.valueOf(pos+1));
            quest.setText(ques);
            aop.setText("A"+a);
            bop.setText("B"+b);
            cop.setText("C"+c);
            dop.setText("D"+d);


            if (ans == 1){
                resultp.setText("ANSWER : " +a);
            } else if (ans ==2) {

                resultp.setText("ANSWER : " +b);

            } else if (ans == 3) {

                resultp.setText("ANSWER : " +c);

            }else{

                resultp.setText("ANSWER : " +d);
            }



        }

    }
}
