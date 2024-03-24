package com.example.oaupost_utme;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class activity_activation_layout extends AppCompatActivity {


    EditText username,password;
    TextView textView;
    private Dialog dialog;




    private static  final  String KEY_MAIL="email";
    SharedPreferences sharedPreferences;
    private static  final  String KEY_NAME = "dummy_value";
    private static  final  String SHARED_PREF_NAME ="mypres";


    Button loginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activation_layout);

        textView = findViewById(R.id.signupText);
        username= findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);



        sharedPreferences =getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity_activation_layout.this, Buy_activation_key_Activity.class);
                startActivity(intent);
                finish();

            }
        });


        String name  = sharedPreferences.getString(KEY_NAME,null);
        if (name != null){
            Intent intent = new Intent(activity_activation_layout.this,MainActivity.class);
            startActivity(intent);
        }


        //Create the Dialog here
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.sucess_filecustom_dialog_layout);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

        Button Okay = dialog.findViewById(R.id.btn_okay);
        Okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SendUserToMainActivity();

                Toast.makeText(activity_activation_layout.this, "Okay", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                valad();

            }
        });


    }

    private boolean valad() {

        String email = username.getText().toString();
        String Password = password.getText().toString();

        if (TextUtils.isEmpty(email))

        {
            username.setError("Please enter email...");
            username.requestFocus();

            Toast.makeText(this, "Please enter email...", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(Password))
        {
            password.setError("Inavid key");
            password.requestFocus();



            Toast.makeText(this, "Please enter password...", Toast.LENGTH_SHORT).show();
        }if (isPasswordUsed(password)){

            Toast.makeText(this, "fffffffffffffffffffffffffffffffff n22222222222222222222222222222222", Toast.LENGTH_SHORT).show();

            return isPasswordUsed(password);
        }
        else
        {

            Toast.makeText(this, "validation in progress", Toast.LENGTH_SHORT).show();

            dialog.show();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_NAME,password.getText().toString());
            editor.putString(KEY_MAIL,username.getText().toString());
            editor.apply();
        }
        return false;
    }


    private void SendUserToMainActivity()
    {
        dialog.dismiss();
        Intent mainIntent = new Intent(activity_activation_layout.this, activity_activation_layout.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish();
    }

    private boolean isPasswordUsed(EditText password) {
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String existingPassword = sharedPreferences.getString(KEY_NAME, "");
        return existingPassword.equals(password);


    }}