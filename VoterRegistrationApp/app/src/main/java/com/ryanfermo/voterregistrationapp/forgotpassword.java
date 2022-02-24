package com.ryanfermo.voterregistrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotpassword extends AppCompatActivity implements View.OnClickListener {
    private EditText editemail;
    private Button resetbutton;
    private ProgressBar progressBar;
    ImageView banner;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        editemail=(EditText)findViewById(R.id.editemail);
        resetbutton=(Button)findViewById(R.id.resetpassword);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        banner=(ImageView) findViewById((R.id.banner));
        banner.setOnClickListener(this);

        auth=FirebaseAuth.getInstance();
        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetpassword();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent new_intent = new Intent(this, MainActivity.class);
        this.startActivity(new_intent);
        finish();

    }
    private void resetpassword() {
        String email=editemail.getText().toString().trim();
        if(email.isEmpty()) {
            editemail.setError("Email is required");
            editemail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editemail.setError("please provide valid email");
            editemail.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(forgotpassword.this,"Check your email to reset your password", Toast.LENGTH_SHORT).show();
                    Intent main = new Intent(forgotpassword.this, MainActivity.class);
                    startActivity(main);
                    finish();
                }else{
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(forgotpassword.this,"Try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}