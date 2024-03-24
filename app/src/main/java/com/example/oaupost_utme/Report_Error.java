package com.example.oaupost_utme;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.oaupost_utme.Account_Years.Year_model_1;
import com.example.oaupost_utme.All_Year_fiil_result_form.account_fill_year;

public class Report_Error extends AppCompatActivity {

    ImageView imageView;
    EditText us;
    Button buy;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_error);


        imageView = findViewById(R.id.backRE);
        us = findViewById(R.id.input);
        buy = findViewById(R.id.SENDButton);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });



        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String name = us.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    us.setError("Please enter message..");
                    us.requestFocus();
                    Toast.makeText(Report_Error.this, "Please enter your message..", Toast.LENGTH_SHORT).show();
                }
                else {

                    openWhatsApp();

                }
            }
        });

    }


    private void openWhatsApp() {


        String phoneNumber = "23407042438455";
        String whatsappBusinessPackage = "com.whatsapp.w4b";

        String message1 = "God day Fem Zee Academy from o.a.u post umte app  i want t make a report";

        if (isAppInstalled(whatsappBusinessPackage)) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/" + phoneNumber+message1)).setPackage(whatsappBusinessPackage));
        } else {

            openWhatsAppWhatsApp(phoneNumber);

        }
    }



    private void openWhatsAppWhatsApp(String phoneNumber) {
        String whatsappPackage = "com.whatsapp";
        String message2 = "God day Fem Zee Academy from o.a.u post umte app  i want t make a report";


        if (isAppInstalled(whatsappPackage)) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/" + phoneNumber+message2)).setPackage(whatsappPackage));
        } else {

            Toast.makeText(this, "O.A.U Management\nwhatsapp is not installed", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean isAppInstalled(String packageName) {

        try {
            getPackageManager().getPackageInfo(packageName, 0);
            return true;

        }catch (PackageManager.NameNotFoundException e) {
            return false;
        }


    }}