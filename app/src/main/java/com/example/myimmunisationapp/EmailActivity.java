package com.example.myimmunisationapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmailActivity extends AppCompatActivity {
    Button sendingemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        sendingemail = findViewById(R.id.btnEmail);

        sendingemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendemail = new Intent(Intent.ACTION_SEND);
                sendemail.setData(Uri.parse("Email"));
                String[] luganda = {
                        "Helendennis4u@gmail.com"};
                sendemail.putExtra(Intent.EXTRA_EMAIL,luganda);
                sendemail.putExtra(Intent.EXTRA_SUBJECT, "Email Subject");
                sendemail.putExtra(Intent.EXTRA_TEXT, "Hello,");
                sendemail.setType("message/rfc822");
                Intent applicationchooser = Intent.createChooser(sendemail,"Start Mail");
                startActivity(applicationchooser);
            }
        });

    }

}
