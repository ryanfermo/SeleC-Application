package com.ryanfermo.voterregistrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class congrats extends AppCompatActivity implements View.OnClickListener {


    ImageButton back, next;
    EditText emailadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);

        back=(ImageButton)findViewById(R.id.back);
        back.setOnClickListener(this);
        next=(ImageButton)findViewById(R.id.next);
        next.setOnClickListener(this);
        emailadd=(EditText)findViewById(R.id.emailadd);
        Intent intent=getIntent();
        String address=intent.getStringExtra("editemail");
        emailadd.setText(address);
    }
    @Override
    public void onBackPressed() {

        Intent new_intent = new Intent(this, registered.class);

        this.startActivity(new_intent);

    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.back:
                Intent back = new Intent(this, MainActivity.class);
                startActivity(back);
               break;
            case R.id.next:
                Intent next = new Intent(this, MainActivity.class);
                startActivity(next);
                break;
        }

    }
}