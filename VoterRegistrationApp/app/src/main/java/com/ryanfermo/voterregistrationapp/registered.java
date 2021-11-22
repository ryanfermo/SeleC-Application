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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class registered extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener,PopupMenu.OnMenuItemClickListener  {
    FirebaseAuth mAuth;
    FirebaseUser muser;
    CheckBox checkBox;
    String course;
    ImageButton RegisterUser, back;
    EditText editfullname, editnumber, editemail, editpassword;
    Spinner editcourse;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);

        mAuth=FirebaseAuth.getInstance();
        muser=mAuth.getCurrentUser();

        RegisterUser=(ImageButton)findViewById(R.id.RegisterUser);
        RegisterUser.setOnClickListener(this);

        checkBox=(CheckBox)findViewById(R.id.checkBox);

        back=(ImageButton)findViewById(R.id.back);
        back.setOnClickListener(this);

        editfullname=(EditText)findViewById(R.id.fullname);
        editnumber=(EditText)findViewById(R.id.number);
        editcourse=(Spinner)findViewById(R.id.course);
        editemail=(EditText)findViewById(R.id.email);
        editpassword=(EditText)findViewById(R.id.password);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Course, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editcourse.setAdapter(adapter);
        editcourse.setOnItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        Intent new_intent = new Intent(this, admin.class);
        this.startActivity(new_intent);
        finish();

    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.back:
                Intent intent=new Intent(this,admin.class);
                startActivity(intent);
                break;

            case R.id.RegisterUser:
                RegisterUser();
                break;
        }

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice=parent.getItemAtPosition(position).toString();
        if(choice.equals("Course")){course="Course";}
        if(choice.equals("BSIT")){course="BSIT";}
        if(choice.equals("BSED")){course="BSED";}
        if(choice.equals("BSEE")){course="BSEE";}
        if(choice.equals("BSBA")){course="BSBA";}
        if(choice.equals("BSN")){course="BSN";}
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void RegisterUser() {
        String email=editemail.getText().toString().trim();
        String password=editpassword.getText().toString().trim();
        String fullname=editfullname.getText().toString().trim();
        String number=editnumber.getText().toString().trim();
        if(checkBox.isChecked()) {
            if (fullname.isEmpty()) {
                editfullname.setError("Fullname is required!");
                editfullname.requestFocus();
                return;
            }
            if (number.isEmpty()) {
                editnumber.setError("Student No. is required!");
                editnumber.requestFocus();
                return;
            }
            if (email.isEmpty()) {
                editemail.setError("E-mail Address is required!");
                editemail.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                editemail.setError("Please enter valid email");
                editemail.requestFocus();
                return;
            }
            if (password.isEmpty()) {
                editpassword.setError("Password is required!");
                editpassword.requestFocus();
                return;
            }
            if (password.length() < 6) {
                editpassword.setError("Minimum length of password is 6 characters");
                editpassword.requestFocus();
                return;
            }
            progressBar.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                User user = new User(fullname, number, email, password, course);
                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(registered.this, "Account successfully Added", Toast.LENGTH_LONG).show();
                                            progressBar.setVisibility(View.GONE);
                                            String emailadd;
                                            Intent intent = new Intent(registered.this, congrats.class);
                                            emailadd=editemail.getText().toString();
                                            intent.putExtra("editemail", emailadd);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(registered.this, "Failed to Submit, Try again", Toast.LENGTH_LONG).show();
                                            progressBar.setVisibility(View.GONE);
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(registered.this, "Failed to Submit, Try again", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
        }
        else {
            Toast.makeText(registered.this, "To register click if you confirmed that all information above is true", Toast.LENGTH_LONG).show();
        }
    }

    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
        popup.inflate(R.menu.pop_menu1);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.admin_register:
                Toast.makeText(this, "Register Section", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.admin_update:
                Toast.makeText(this, "Update Section", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,content.class));
                return true;
            case R.id.admin_result:
                Toast.makeText(this, "Results Section", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,results.class));
                finish();
                return true;
            default:
                return false;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.pop_menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }
}