package com.ryanfermo.voterregistrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class admin extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextEmail, editTextpPassword;
    private Button login;
    private TextView nouser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        editTextEmail=(EditText)findViewById(R.id.editTextEmail);
        editTextpPassword=(EditText)findViewById(R.id.editTextTextPassword);
        nouser=(TextView)findViewById(R.id.nouser);
        nouser.setVisibility(View.GONE);
        login=(Button)findViewById(R.id.Login);
        login.setOnClickListener(this);

    }
    @Override
    public void onBackPressed() {
        Intent new_intent = new Intent(this, MainActivity.class);
        this.startActivity(new_intent);
        finish();
    }
    @Override
    public void onClick(View v) {
        if (editTextEmail.getText().toString().equals("admin") && editTextpPassword.getText().toString().equals("admin")){
            Intent intent=new Intent(this,registered.class);
            startActivity(intent);
            finish();
        }
        else{
            nouser.setVisibility(View.VISIBLE);
        }
    }
}