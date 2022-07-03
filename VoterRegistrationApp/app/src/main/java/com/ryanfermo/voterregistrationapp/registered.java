package com.ryanfermo.voterregistrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

public class registered extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener{
    FirebaseAuth mAuth;
    FirebaseUser muser;
    Button RegisterUser, clear;
    EditText editfullname, editnumber, editemail, editpassword;
    EditText editcourse;
    ProgressBar progressBar;
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navigationView;
    Button button;
    String idnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);

        drawer=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        mAuth=FirebaseAuth.getInstance();
        muser=mAuth.getCurrentUser();
        updateNavHeader();
        RegisterUser=(Button)findViewById(R.id.RegisterUser);
        RegisterUser.setOnClickListener(this);

        clear=(Button)findViewById(R.id.clear);
        clear.setOnClickListener(this);

        editfullname=(EditText)findViewById(R.id.fullname);
        editnumber=(EditText)findViewById(R.id.number);
        editcourse=(EditText) findViewById(R.id.course);
        editemail=(EditText)findViewById(R.id.email);
        editpassword=(EditText)findViewById(R.id.number);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.clear:
                editnumber.setText("");
                editfullname.setText("");
                editcourse.setText("");
                editemail.setText("");
                break;

            case R.id.RegisterUser:
                RegisterUser();
                break;

            case R.id.button:
                informations();
                break;
        }
    }
    private void informations() {
        idnumber=editnumber.getText().toString();
        try {
            getData();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void getData() throws MalformedURLException {
        URL url = new URL("https://api.jsonserve.com/ii3iXI");
        new DOTask().execute(url);
    }

    class DOTask extends AsyncTask<URL,Void,String> {
        @Override
        protected String doInBackground(URL... urls) {
            URL url = urls[0];
            String data = null;
            try {
                data = VoterInfo.makeHTTPRequest(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }
        @Override
        protected void onPostExecute(String s){
            try {
                parseJson(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private void parseJson(String data) throws JSONException {
            JSONObject jsonObject=null;
            try {
                jsonObject=new JSONObject(data);
            }
            catch (JSONException e){
                e.printStackTrace();
            }
            JSONArray numberID= jsonObject.getJSONArray("data");

            for(int i=0;i<numberID.length();i++){
                JSONObject numbero=numberID.getJSONObject(i);
                String numbern=numbero.get("number").toString();
                if(numbern.equals(idnumber)){
                    String sname=numbero.get("name").toString();
                    String scourse=numbero.get("course").toString();
                    String semail=numbero.get("email").toString();
                    editfullname.setText(sname);
                    editcourse.setText(scourse);
                    editemail.setText(semail);
                }else{
                }
            }
        }
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
            Intent intent4=new Intent(this,admin.class);
            startActivity(intent4);
            finish();
        }
    }
    private void RegisterUser() {
        String email=editemail.getText().toString().trim();
        String password=editpassword.getText().toString().trim();
        String fullname=editfullname.getText().toString().trim();
        String number=editnumber.getText().toString().trim();
        String course=editcourse.getText().toString().trim();
          if (course.isEmpty()) {
            editcourse.setError("Course is required!");
            editcourse.requestFocus();
            return;
           }

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
             if (number.length() > 8 || number.length() < 8) {
            editnumber.setError("Student ID length is 8 characters");
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
            if (password.length() > 8 || password.length() < 8) {
                editpassword.setError("Error");
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
                                            Toast.makeText(registered.this, "Account successfully Added", Toast.LENGTH_SHORT).show();
                                            progressBar.setVisibility(View.GONE);
                                            String emailadd;
                                            Intent intent = new Intent(registered.this, congrats.class);
                                            emailadd=editemail.getText().toString();
                                            intent.putExtra("editemail", emailadd);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(registered.this, "Failed to Submit, Try again", Toast.LENGTH_SHORT).show();
                                            progressBar.setVisibility(View.GONE);
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(registered.this, "Failed to Submit, Try again", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.admin_register:
                Intent intent=new Intent(this,registered.class);
                startActivity(intent);
                finish();
                break;
            case R.id.admin_update:
                Intent intent1=new Intent(this,content.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.admin_result:
                Intent intent2=new Intent(this,results.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.admin_chart:
                Intent intent5=new Intent(this,charting.class);
                startActivity(intent5);
                finish();
                break;
            case R.id.admin_archive:
                Intent intent3=new Intent(this,archive_votes.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.appadmin:
                Intent intent4=new Intent(this,admin.class);
                startActivity(intent4);
                finish();
                break;
        }
        return true;
    }

    public void updateNavHeader(){
        navigationView=findViewById(R.id.nav_view);
        View HeaderView=navigationView.getHeaderView(0);
        TextView navUserName= HeaderView.findViewById(R.id.nav_username);
        ImageView imageview = (ImageView) HeaderView.findViewById(R.id.nav_imageView);
        imageview.setImageResource(R.drawable.selecprofileadmin);
       navUserName.setText("SeleC Admin");
    }
}