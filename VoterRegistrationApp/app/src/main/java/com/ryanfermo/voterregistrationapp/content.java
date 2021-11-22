package com.ryanfermo.voterregistrationapp;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.UUID;

public class content extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener,PopupMenu.OnMenuItemClickListener {
    private ImageButton Insert;
    EditText Name, Party;
    Spinner Position;
    String po,url;
    DatabaseReference candidate;
    Button button;
    ImageView ImageView;
    Uri imageUri;
    FirebaseStorage Storage;
    TextView sample;
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

        Insert = (ImageButton) findViewById(R.id.insert);
        Insert.setOnClickListener(this);


        Name = findViewById(R.id.Name);
        Party = findViewById(R.id.Party);

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
                            Toast.makeText(content.this, "Photo Uploaded", Toast.LENGTH_LONG).show();
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
                            Toast.makeText(content.this, "Failed to Upload", Toast.LENGTH_LONG).show();
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
        if(choice.equals("President C1")){po="C1";}
        if(choice.equals("President C2")){po="C2";}
        if(choice.equals("Vice President C1")){po="C3";}
        if(choice.equals("Vice President C2")){po="C4";}
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

        }
    }

    private void insertcandidate() {
        String name = Name.getText().toString().trim();
        String party = Party.getText().toString().trim();
        String image = sample.getText().toString().trim();
        HashMap hashMap = new HashMap();
        hashMap.put("name", name);
        hashMap.put("party", party);
        hashMap.put("image", image);

        if (name.isEmpty() || party.isEmpty() || po == "Position" || image.isEmpty()) {
            Toast.makeText(content.this, "No data to be updated! Please Select Position, Choose Photo and Fill-up the Field", Toast.LENGTH_LONG).show();
        } else {
            if (po == "C1") {
                candidate.child("Candidate1").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_LONG).show();
                        Name.setText("");
                        Party.setText("");
                        sample.setText("");
                        ImageView.setImageResource(R.drawable.avatars);
                    }
                });
            }
            if (po == "C2") {
                candidate.child("Candidate2").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_LONG).show();
                        Name.setText("");
                        Party.setText("");
                        sample.setText("");
                        ImageView.setImageResource(R.drawable.avatars);
                    }
                });
            }
            if (po == "C3") {
                candidate.child("Candidate3").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_LONG).show();
                        Name.setText("");
                        Party.setText("");
                        sample.setText("");
                        ImageView.setImageResource(R.drawable.avatars);
                    }
                });
            }
            if (po == "C4") {
                candidate.child("Candidate4").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(content.this, "Data has been Updated", Toast.LENGTH_LONG).show();
                        Name.setText("");
                        Party.setText("");
                        sample.setText("");
                        ImageView.setImageResource(R.drawable.avatars);
                    }
                });
            }
        }
    }
    public void onBackPressed() {
        Intent new_intent = new Intent(this, admin.class);
        this.startActivity(new_intent);
        finish();
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
                startActivity(new Intent(this,registered.class));
                finish();
                return true;
            case R.id.admin_update:
                Toast.makeText(this, "Update Section", Toast.LENGTH_SHORT).show();
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