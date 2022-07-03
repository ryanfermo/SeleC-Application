package com.ryanfermo.voterregistrationapp;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.UUID;

public class content extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener,NavigationView.OnNavigationItemSelectedListener {
    private Button Insert, Clear;
    EditText Name, Party, Advocacy;
    Spinner Position;
    String po,url;
    DatabaseReference candidate;
    Button button;
    ImageView ImageView;
    Uri imageUri;
    FirebaseStorage Storage;
    TextView sample;
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Position = (Spinner) findViewById(R.id.position);
        Storage = FirebaseStorage.getInstance();
        sample=(TextView)findViewById(R.id.textView16);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        ImageView = (ImageView) findViewById(R.id.imageView3);

        Insert = (Button) findViewById(R.id.insert);
        Insert.setOnClickListener(this);
        Clear = (Button) findViewById(R.id.clear);
        Clear.setOnClickListener(this);

        updateNavHeader();
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

        Name = findViewById(R.id.Name);
        Party = findViewById(R.id.Party);
        Advocacy=findViewById(R.id.Advocacy);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Position, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Position.setAdapter(adapter);
        Position.setOnItemSelectedListener(this);

        candidate = FirebaseDatabase.getInstance().getReference().child("Candidate");

        ImageView = (ImageView) findViewById(R.id.imageView3);
        ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetContent.launch("image/*");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadImage();
            }
        });
    }
        private void UploadImage() {
            if (imageUri!=null){
                StorageReference reference= Storage.getReference().child("image/"+ UUID.randomUUID().toString());
                reference.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(content.this, "Photo Uploaded", Toast.LENGTH_SHORT).show();
                            reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String URL= uri.toString();
                                    url=URL;
                                    sample.setText(URL);
                                }
                            });
                        }
                        else
                        {
                            Toast.makeText(content.this, "Failed to Upload", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
    ActivityResultLauncher<String>mGetContent=registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
        @Override
        public void onActivityResult(Uri result) {

            if(result!=null){
                ImageView.setImageURI(result);
                imageUri=result;
            }
        }
    });
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice=parent.getItemAtPosition(position).toString();
        if(choice.equals("Select Position")){po="Position";}
        if(choice.equals("President")){po="C1";}
        if(choice.equals("Vice President")){po="C3";}
        if(choice.equals("Secretary")){po="C5";}
        if(choice.equals("Treasurer")){po="C7";}
        if(choice.equals("Auditor")){po="C9";}
        if(choice.equals("PRO")){po="C11";}
        if(choice.equals("Representative")){po="C13";}
        if(choice.equals("1President")){po="C2";}
        if(choice.equals("1Vice President")){po="C4";}
        if(choice.equals("1Secretary")){po="C6";}
        if(choice.equals("1Treasurer")){po="C8";}
        if(choice.equals("1Auditor")){po="C10";}
        if(choice.equals("1PRO")){po="C12";}
        if(choice.equals("1Representative")){po="C14";}
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.insert:
                insertcandidate();
                break;
            case R.id.clear:
                clearcandidate();
                break;

        }
    }

    private void clearcandidate() {
        Name.setText("");
        Party.setText("");
        Advocacy.setText("");
        sample.setText("");
        ImageView.setImageResource(R.drawable.avatars);
        Position.setSelection(0);
    }

    private void insertcandidate() {
        String name = Name.getText().toString().trim();
        String party = Party.getText().toString().trim();
        String advocacy= Advocacy.getText().toString().trim();
        String image = sample.getText().toString().trim();
        HashMap hashMap = new HashMap();
        hashMap.put("name", name);
        hashMap.put("party", party);
        hashMap.put("advocacy", advocacy);
        hashMap.put("image", image);

        if (name.isEmpty() || party.isEmpty() || po == "Position" || image.isEmpty() || advocacy.isEmpty()) {
            Toast.makeText(content.this, "No data to be updated! Please Select Position, Choose Photo and Fill-up the Field", Toast.LENGTH_LONG).show();
        } else {
            if (po == "C1") {
                candidate.child("Candidate1").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(content.this,content.class);
                        startActivity(intent1);
                        finish();
                    }
                });
            }
            if (po == "C2") {
                candidate.child("Candidate2").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(content.this,content.class);
                        startActivity(intent1);
                        finish();
                    }
                });
            }
            if (po == "C3") {
                candidate.child("Candidate3").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(content.this,content.class);
                        startActivity(intent1);
                        finish();
                    }
                });
            }
            if (po == "C4") {
                candidate.child("Candidate4").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(content.this,content.class);
                        startActivity(intent1);
                        finish();
                    }
                });
            }
            if (po == "C5") {
                candidate.child("Candidate5").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(content.this,content.class);
                        startActivity(intent1);
                        finish();
                    }
                });
            }
            if (po == "C6") {
                candidate.child("Candidate6").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(content.this,content.class);
                        startActivity(intent1);
                        finish();
                    }
                });
            }
            if (po == "C7") {
                candidate.child("Candidate7").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(content.this,content.class);
                        startActivity(intent1);
                        finish();
                    }
                });
            }
            if (po == "C8") {
                candidate.child("Candidate8").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(content.this,content.class);
                        startActivity(intent1);
                        finish();
                    }
                });
            }
            if (po == "C9") {
                candidate.child("Candidate9").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(content.this,content.class);
                        startActivity(intent1);
                        finish();
                    }
                });
            }
            if (po == "C10") {
                candidate.child("Candidate10").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(content.this,content.class);
                        startActivity(intent1);
                        finish();
                    }
                });
            }
            if (po == "C11") {
                candidate.child("Candidate11").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(content.this,content.class);
                        startActivity(intent1);
                        finish();
                    }
                });
            }
            if (po == "C12") {
                candidate.child("Candidate12").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(content.this,content.class);
                        startActivity(intent1);
                        finish();
                    }
                });
            }
            if (po == "C13") {
                candidate.child("Candidate13").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(content.this,content.class);
                        startActivity(intent1);
                        finish();
                    }
                });
            }
            if (po == "C14") {
                candidate.child("Candidate14").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(content.this,content.class);
                        startActivity(intent1);
                        finish();
                    }
                });
            }
        }
    }
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
            Intent intent4=new Intent(this,registered.class);
            startActivity(intent4);
            finish();
        }
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