package com.ryanfermo.voterregistrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView  forgot, nouser, admin;
    private EditText editTextEmail, editTextpPassword;
    private Button Login;
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

        Login=(Button)findViewById(R.id.Login);
        Login.setOnClickListener(this);

        admin=(TextView)findViewById(R.id.admin);
        admin.setOnClickListener(this);

        editTextEmail=(EditText)findViewById(R.id.editTextEmail);
        editTextpPassword=(EditText)findViewById(R.id.editTextTextPassword);

        forgot=(TextView)findViewById(R.id.forgot);
        forgot.setOnClickListener(this);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        mAuth=FirebaseAuth.getInstance();

    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.Login:
                userLogin();
                break;

            case R.id.forgot:
                startActivity(new Intent(this,forgotpassword.class));
                finish();
                break;

            case R.id.admin:
                startActivity(new Intent(this,admin.class));
                finish();
                break;
        }
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
                        startActivity(new Intent(MainActivity.this, advocacy.class));
                        finish();
                        progressBar.setVisibility(View.GONE);
                    }else{
                        user.sendEmailVerification();
                        Toast.makeText(MainActivity.this,"Check your email to verify the account!", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }else{
                    progressBar.setVisibility(View.GONE);
                    nouser.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Failed to Login! You already Voted or Please check your credentials", Toast.LENGTH_LONG).show();;
                }
            }
        });
    }
}