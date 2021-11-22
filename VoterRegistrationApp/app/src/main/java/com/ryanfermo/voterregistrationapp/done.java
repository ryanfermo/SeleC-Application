package com.ryanfermo.voterregistrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class done extends AppCompatActivity implements View.OnClickListener {

    ImageButton back, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(this);
        exit = (ImageButton) findViewById(R.id.exit);
        exit.setOnClickListener(this);


    }
    @Override
    public void onBackPressed() {

        Intent new_intent = new Intent(this, MainActivity.class);
        this.startActivity(new_intent);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                Intent back = new Intent(this, MainActivity.class);
                startActivity(back);
            break;
            case R.id.exit:
                finish();
                break;
        }
    }
}