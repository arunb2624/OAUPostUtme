package com.example.oaupost_utme;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Buy_activation_key_Activity extends AppCompatActivity {
    ImageView imageView;
    EditText us;
    Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_activation_key);

        imageView = findViewById(R.id.back);
        us = findViewById(R.id.username);
        buy = findViewById(R.id.buyButton);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                openWhatsApp();


            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Buy_activation_key_Activity.this, activity_activation_layout.class);
                startActivity(intent);


            }
        });
    }

    private void openWhatsApp() {


        String phoneNumber = "23407042438455";
        String whatsappBusinessPackage = "com.whatsapp.w4b";

        String message = "God day Fem Zee Academy I just download your app i need activation key to use the app features";

        if (isAppInstalled(whatsappBusinessPackage)) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/" + phoneNumber+message)).setPackage(whatsappBusinessPackage));
        } else {

            openWhatsAppWhatsApp(phoneNumber);

        }
    }



    private void openWhatsAppWhatsApp(String phoneNumber) {
        String whatsappPackage = "com.whatsapp";
        String message = "God day Fem Zee Academy I just download your app i need activation key to use the app features";


        if (isAppInstalled(whatsappPackage)) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/" + phoneNumber+message)).setPackage(whatsappPackage));
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


    }
}