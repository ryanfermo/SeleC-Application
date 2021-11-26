package com.ryanfermo.voterregistrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Welcome extends AppCompatActivity {
    private ImageButton Google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Google=(ImageButton)findViewById(R.id.usergoogle);
        Google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Welcome.this,GoogSignIn.class);
                startActivity(intent);
            }
        });
    }
}