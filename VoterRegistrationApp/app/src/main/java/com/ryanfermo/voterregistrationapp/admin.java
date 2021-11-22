package com.ryanfermo.voterregistrationapp;

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
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class admin extends AppCompatActivity implements View.OnClickListener,PopupMenu.OnMenuItemClickListener {
    private EditText editTextEmail, editTextpPassword;
    private ImageButton login;
    private TextView nouser;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        editTextEmail=(EditText)findViewById(R.id.editTextEmail);
        editTextpPassword=(EditText)findViewById(R.id.editTextTextPassword);
        nouser=(TextView)findViewById(R.id.nouser);
        nouser.setVisibility(View.GONE);

        login=(ImageButton)findViewById(R.id.Login);
        login.setOnClickListener(this);
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
        if (editTextEmail.getText().toString().equals("root") && editTextpPassword.getText().toString().equals("canal")){
            Intent intent=new Intent(this,registered.class);
            startActivity(intent);
        }
        else{
            nouser.setVisibility(View.VISIBLE);
        }
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
                startActivity(new Intent(this,MainActivity.class));
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