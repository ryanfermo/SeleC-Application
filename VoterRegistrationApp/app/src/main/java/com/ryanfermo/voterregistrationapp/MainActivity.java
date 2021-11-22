package com.ryanfermo.voterregistrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,PopupMenu.OnMenuItemClickListener {
    private TextView  forgot, nouser;
    private EditText editTextEmail, editTextpPassword;
    private ImageButton Login, Google;
    private long backPressedTime;
    private Toast backToast;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nouser=(TextView)findViewById(R.id.nouser);
        nouser.setVisibility(View.GONE);

        Login=(ImageButton)findViewById(R.id.Login);
        Login.setOnClickListener(this);

        Google=(ImageButton)findViewById(R.id.usergoogle);

        editTextEmail=(EditText)findViewById(R.id.editTextEmail);
        editTextpPassword=(EditText)findViewById(R.id.editTextTextPassword);

        forgot=(TextView)findViewById(R.id.forgot);
        forgot.setOnClickListener(this);

        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        mAuth=FirebaseAuth.getInstance();


        Google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GoogSignIn.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(backPressedTime+2000>System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else{
            backToast= Toast.makeText(getBaseContext(),"Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime=System.currentTimeMillis();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.Login:
                userLogin();
                break;

            case R.id.forgot:
                startActivity(new Intent(this,forgotpassword.class));
                break;
        }
    }

    private void userGoogle() {

    }


    private void userLogin() {
        String email=editTextEmail.getText().toString().trim();
        String password=editTextpPassword.getText().toString().trim();

        if(email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter valid password");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextpPassword.setError("Password is required");
            editTextpPassword.requestFocus();
            return;
        }
        if(password.length()<6) {
            editTextpPassword.setError("Minimun password length is 6 characters");
            editTextpPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
                    if(user.isEmailVerified()){
                        startActivity(new Intent(MainActivity.this, voter.class));
                        progressBar.setVisibility(View.GONE);
                    }else{
                        user.sendEmailVerification();
                        Toast.makeText(MainActivity.this,"Check your email to verify the account!", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }else{
                    progressBar.setVisibility(View.GONE);
                    nouser.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Failed to Login! Please check your credentials", Toast.LENGTH_LONG).show();;
                }
            }
        });
    }

    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.appvoter:
                Toast.makeText(this, "Voter Section", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.appadmin:
                Toast.makeText(this, "Admin Section", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,admin.class));
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.popup_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}