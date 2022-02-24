package com.ryanfermo.voterregistrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class done extends AppCompatActivity implements View.OnClickListener {

    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(this);

    }
    @Override
    public void onBackPressed() {
        Intent new_intent = new Intent(this, MainActivity.class);
        this.startActivity(new_intent);
        finish();

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exit:
                Signout();
                break;
        }
    }
    private void Signout() {
                Toast.makeText(done.this, "You will be SignOut", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(done.this,MainActivity.class );
                startActivity(intent);
                finish();
    }
}