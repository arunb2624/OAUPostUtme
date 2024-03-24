package com.example.oaupost_utme.caculator_account;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oaupost_utme.Account_Years.Year_model_1;
import com.example.oaupost_utme.Account_Years.Year_model_2;
import com.example.oaupost_utme.R;
import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class calculator_year_2 extends AppCompatActivity implements  View.OnClickListener{



    TextView result,solution;


    MaterialButton button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9;
    MaterialButton   button_Add, button_Sub,  button_Mul, button_Div, button_Equ;

    MaterialButton button_c, button_brakectopen,buttonbrackt_close;
    MaterialButton button_ac,button_dot;
    ImageView ba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_year2);






        ba = (ImageView) findViewById(R.id.back_2);


        result = findViewById(R.id.result_tv);
        solution = findViewById(R.id.solution_tv14);

        assignId(button_0,R.id.button_0);
        assignId(button_1,R.id.button_1);
        assignId(button_2,R.id.button_2);
        assignId(button_3,R.id.button_3);
        assignId(button_4,R.id.button_4);
        assignId(button_5,R.id.button_5);
        assignId(button_6,R.id.button_6);
        assignId(button_7,R.id.button_7);
        assignId(button_8,R.id.button_8);
        assignId(button_9,R.id.button_9);
        assignId(button_Add,R.id.button_add);
        assignId(button_Sub,R.id.button_minus);
        assignId(button_Mul,R.id.button_mutiply);
        assignId(button_Div,R.id.button_divide);
        assignId(button_dot,R.id.button_dot);
        assignId(button_Equ,R.id.button_equal);
        assignId(button_ac,R.id.button_ac);
        assignId(button_brakectopen,R.id.button_open_bracket);
        assignId(buttonbrackt_close,R.id.button_close_bracket);
        assignId(button_c,R.id.button_c);

        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();


            }
        });

    }

    void  assignId(MaterialButton btn,int id){

        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {



        MaterialButton button = (MaterialButton) view;

        String buttontext = button.getText().toString();
        String datatoccalculate = solution.getText().toString();

        if (buttontext.equals("D")){
            solution.setText("0");
            result.setText("0");
            return;
        }
        if (buttontext.equals("C".isEmpty())){
            solution.setText("0");

            return ;
        }
        if (buttontext.equals("=")){

            solution.setText(result.getText());
            return;
        }

        if (buttontext.equals("C")){
            datatoccalculate = datatoccalculate.substring(0,datatoccalculate.length()-1);

            if (datatoccalculate.isEmpty()){
                solution.setText("0");
                return ;
            }
        } else {


            datatoccalculate = datatoccalculate+buttontext;

        }
        solution.setText(datatoccalculate);

        String finalResult = getresult(datatoccalculate);

        if (!finalResult.equals("Err")){
            result.setText(finalResult);
        }


    }

    String getresult(String data){

        try {

            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult =  context.evaluateString(scriptable,data,"Javascript",1,null).toString();


            if (finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0","");
            }
            return  finalResult;


        }catch (Exception e){
            return "Err";
        }
    }

}
