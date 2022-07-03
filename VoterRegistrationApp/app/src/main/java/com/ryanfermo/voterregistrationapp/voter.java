package com.ryanfermo.voterregistrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import static android.content.ContentValues.TAG;

public class voter extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener{
    ImageButton candidate1, candidate2, candidate3, candidate4, candidate5, candidate6, candidate7, candidate8, candidate9, candidate10, candidate111, candidate112,candidate113,candidate114;
    TextView C1, C2, C3, C4, P1, P2, P3, P4,C5, C6, C7, C8, P5, P6, P7, P8,C9, C10, C11, C12, P9, P10, P11, P12,C13,C14,P13,P14;
    String president = "", vicepresident = "",secretary="",treasurer="",auditor="",pro="",representative="";
    Integer PA,PB,VPA,VPB,SA,SB,TA,TB,OA,OB,PRA,PRB,RA,RB;
    DatabaseReference votes;
    Button back, submit;
    DatabaseReference candidate,candidate12,candidate13,candidate14,can5,can6,can7,can8,can9,can10,can11,can12,can13,can14;
    String N1,N2,N3,N4,N5,N6,N7;
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navigationView;
    FirebaseUser currentuUser;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voter);
        votes = FirebaseDatabase.getInstance().getReference().child("Votes");
        C1 = (TextView) findViewById(R.id.textView10);
        C2 = (TextView) findViewById(R.id.textView12);
        C3 = (TextView) findViewById(R.id.textView13);
        C4 = (TextView) findViewById(R.id.textView14);
        P1 = (TextView) findViewById(R.id.textView);
        P2 = (TextView) findViewById(R.id.textView3);
        P3 = (TextView) findViewById(R.id.textView5);
        P4 = (TextView) findViewById(R.id.textView6);
        C5 = (TextView) findViewById(R.id.namesecretary);
        C6 = (TextView) findViewById(R.id.namesecretary1);
        C7 = (TextView) findViewById(R.id.nametreasurer);
        C8 = (TextView) findViewById(R.id.nametreasurer1);
        P5 = (TextView) findViewById(R.id.partysecretary);
        P6 = (TextView) findViewById(R.id.partysecretary1);
        P7 = (TextView) findViewById(R.id.partytreasurer);
        P8 = (TextView) findViewById(R.id.partytreasurer1);
        C9 = (TextView) findViewById(R.id.nameauditor);
        C10 = (TextView) findViewById(R.id.nameauditor1);
        C11 = (TextView) findViewById(R.id.namepro);
        C12 = (TextView) findViewById(R.id.namepro1);
        P9 = (TextView) findViewById(R.id.partyauditor);
        P10 = (TextView) findViewById(R.id.partyauditor1);
        P11 = (TextView) findViewById(R.id.partypro);
        P12 = (TextView) findViewById(R.id.partypro1);
        C13 = (TextView) findViewById(R.id.namerep);
        C14 = (TextView) findViewById(R.id.namerep1);
        P13 = (TextView) findViewById(R.id.partyrep);
        P14 = (TextView) findViewById(R.id.partyrep1);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);

        mAuth=FirebaseAuth.getInstance();
        currentuUser=mAuth.getCurrentUser();
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

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);

        candidate1 = (ImageButton) findViewById(R.id.candidate1);
        candidate1.setOnClickListener(this);

        candidate2 = (ImageButton) findViewById(R.id.candidate2);
        candidate2.setOnClickListener(this);

        candidate3 = (ImageButton) findViewById(R.id.candidate3);
        candidate3.setOnClickListener(this);

        candidate4 = (ImageButton) findViewById(R.id.candidate4);
        candidate4.setOnClickListener(this);

        candidate5 = (ImageButton) findViewById(R.id.candidate5);
        candidate5.setOnClickListener(this);

        candidate6 = (ImageButton) findViewById(R.id.candidate6);
        candidate6.setOnClickListener(this);

        candidate7 = (ImageButton) findViewById(R.id.candidate7);
        candidate7.setOnClickListener(this);

        candidate8 = (ImageButton) findViewById(R.id.candidate8);
        candidate8.setOnClickListener(this);

        candidate9 = (ImageButton) findViewById(R.id.candidate9);
        candidate9.setOnClickListener(this);

        candidate10 = (ImageButton) findViewById(R.id.candidate10);
        candidate10.setOnClickListener(this);

        candidate111 = (ImageButton) findViewById(R.id.candidate11);
        candidate111.setOnClickListener(this);

        candidate112 = (ImageButton) findViewById(R.id.candidate12);
        candidate112.setOnClickListener(this);

        candidate113 = (ImageButton) findViewById(R.id.candidate13);
        candidate113.setOnClickListener(this);

        candidate114 = (ImageButton) findViewById(R.id.candidate14);
        candidate114.setOnClickListener(this);


        candidate=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate1");
        candidate.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C1.setText(name);
                    P1.setText(party);
                    Picasso.get().load(image).into(candidate1);
                    if(C1.getText().toString().equals("Default Name")){
                        candidate1.setEnabled(false);
                    }
                    else{
                        candidate1.setEnabled(true);
                    }
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        candidate12=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate2");
        candidate12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C2.setText(name);
                    P2.setText(party);
                    Picasso.get().load(image).into(candidate2);
                    if(C2.getText().toString().equals("Default Name")){
                        candidate2.setEnabled(false);
                    }
                    else{
                        candidate2.setEnabled(true);
                    }
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        candidate13=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate3");
        candidate13.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C3.setText(name);
                    P3.setText(party);
                    Picasso.get().load(image).into(candidate3);
                    if(C3.getText().toString().equals("Default Name")){
                        candidate3.setEnabled(false);
                    }
                    else{
                        candidate3.setEnabled(true);
                    }
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        candidate14=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate4");
        candidate14.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C4.setText(name);
                    P4.setText(party);
                    Picasso.get().load(image).into(candidate4);
                    if(C4.getText().toString().equals("Default Name")){
                        candidate4.setEnabled(false);
                    }
                    else{
                        candidate4.setEnabled(true);
                    }
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        can5=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate5");
        can5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C5.setText(name);
                    P5.setText(party);
                    Picasso.get().load(image).into(candidate5);
                    if(C5.getText().toString().equals("Default Name")){
                        candidate5.setEnabled(false);
                    }
                    else{
                        candidate5.setEnabled(true);
                    }
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can6=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate6");
        can6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C6.setText(name);
                    P6.setText(party);
                    Picasso.get().load(image).into(candidate6);
                    if(C6.getText().toString().equals("Default Name")){
                        candidate6.setEnabled(false);
                    }
                    else{
                        candidate6.setEnabled(true);
                    }
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can7=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate7");
        can7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C7.setText(name);
                    P7.setText(party);
                    Picasso.get().load(image).into(candidate7);
                    if(C7.getText().toString().equals("Default Name")){
                        candidate7.setEnabled(false);
                    }
                    else{
                        candidate7.setEnabled(true);
                    }
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can8=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate8");
        can8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C8.setText(name);
                    P8.setText(party);
                    Picasso.get().load(image).into(candidate8);
                    if(C8.getText().toString().equals("Default Name")){
                        candidate8.setEnabled(false);
                    }
                    else{
                        candidate8.setEnabled(true);
                    }
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can9=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate9");
        can9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C9.setText(name);
                    P9.setText(party);
                    Picasso.get().load(image).into(candidate9);
                    if(C9.getText().toString().equals("Default Name")){
                        candidate9.setEnabled(false);
                    }
                    else{
                        candidate9.setEnabled(true);
                    }
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can10=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate10");
        can10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C10.setText(name);
                    P10.setText(party);
                    Picasso.get().load(image).into(candidate10);
                    if(C10.getText().toString().equals("Default Name")){
                        candidate10.setEnabled(false);
                    }
                    else{
                        candidate10.setEnabled(true);
                    }
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can11=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate11");
        can11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C11.setText(name);
                    P11.setText(party);
                    Picasso.get().load(image).into(candidate111);
                    if(C11.getText().toString().equals("Default Name")){
                        candidate111.setEnabled(false);
                    }
                    else{
                        candidate111.setEnabled(true);
                    }
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can12=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate12");
        can12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C12.setText(name);
                    P12.setText(party);
                    Picasso.get().load(image).into(candidate112);
                    if(C12.getText().toString().equals("Default Name")){
                        candidate112.setEnabled(false);
                    }
                    else{
                        candidate112.setEnabled(true);
                    }
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can13=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate13");
        can13.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C13.setText(name);
                    P13.setText(party);
                    Picasso.get().load(image).into(candidate113);
                    if(C13.getText().toString().equals("Default Name")){
                        candidate113.setEnabled(false);
                    }
                    else{
                        candidate113.setEnabled(true);
                    }
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        can14=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate14");
        can14.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C14.setText(name);
                    P14.setText(party);
                    Picasso.get().load(image).into(candidate114);
                    if(C14.getText().toString().equals("Default Name")){
                        candidate114.setEnabled(false);
                    }
                    else{
                        candidate114.setEnabled(true);
                    }
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent new_intent = new Intent(this, advocacy.class);
        this.startActivity(new_intent);
        finish();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
               SignOut();
                break;
            case R.id.submit:
                submit();
                break;

            case R.id.candidate1:
                candidate1();
                break;
            case R.id.candidate2:
                candidate2();
                break;
            case R.id.candidate3:
                candidate3();
                break;
            case R.id.candidate4:
                candidate4();
                break;
            case R.id.candidate5:
                candidate5();
                break;
            case R.id.candidate6:
                candidate6();
                break;
            case R.id.candidate7:
                candidate7();
                break;
            case R.id.candidate8:
                candidate8();
                break;
            case R.id.candidate9:
                candidate9();
                break;
            case R.id.candidate10:
                candidate10();
                break;
            case R.id.candidate11:
                candidate11();
                break;
            case R.id.candidate12:
                candidate12();
                break;
            case R.id.candidate13:
                candidate13();
                break;
            case R.id.candidate14:
                candidate14();
                break;
        }
    }

    private void SignOut() {
        Intent new_intent = new Intent(this, MainActivity.class);
        this.startActivity(new_intent);
        finish();
    }

    private void candidate4() {
        candidate4.setImageResource(R.drawable.voted);
        vicepresident ="VicePresident B";
        N2=C4.getText().toString().trim();
        VPB=1;
        VPA=0;
        candidate13=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate3");
        candidate13.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C3.setText(name);
                    P3.setText(party);
                    Picasso.get().load(image).into(candidate3);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

    private void candidate3() {
        candidate3.setImageResource(R.drawable.voted);
        vicepresident ="VicePresident A";
        N2=C3.getText().toString().trim();
        VPA=1;
        VPB=0;
        candidate14=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate4");
        candidate14.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C4.setText(name);
                    P4.setText(party);
                    Picasso.get().load(image).into(candidate4);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void candidate2() {
        candidate2.setImageResource(R.drawable.voted);
        president = "President B";
        N1=C2.getText().toString().trim();
        PB=1;
        PA=0;
        candidate=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate1");
        candidate.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C1.setText(name);
                    P1.setText(party);
                    Picasso.get().load(image).into(candidate1);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void candidate1() {
        candidate1.setImageResource(R.drawable.voted);
        president = "President A";
        N1=C1.getText().toString().trim();
        PA=1;
        PB=0;
        candidate12=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate2");
        candidate12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C2.setText(name);
                    P2.setText(party);
                    Picasso.get().load(image).into(candidate2);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }


    private void candidate6() {
        candidate6.setImageResource(R.drawable.voted);
        secretary= "Secretary B";
        N3=C6.getText().toString().trim();
        SB=1;
        SA=0;
        can5=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate5");
        can5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C5.setText(name);
                    P5.setText(party);
                    Picasso.get().load(image).into(candidate5);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void candidate5() {
        candidate5.setImageResource(R.drawable.voted);
        secretary = "Secretary A";
        N3=C5.getText().toString().trim();
        SA=1;
        SB=0;
        can6=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate6");
        can6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C6.setText(name);
                    P6.setText(party);
                    Picasso.get().load(image).into(candidate6);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }


    private void candidate8() {
        candidate8.setImageResource(R.drawable.voted);
        treasurer= "Treasurer B";
        N4=C8.getText().toString().trim();
        TB=1;
        TA=0;
        can7=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate7");
        can7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C7.setText(name);
                    P7.setText(party);
                    Picasso.get().load(image).into(candidate7);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void candidate7() {
        candidate7.setImageResource(R.drawable.voted);
        treasurer = "Treasurer A";
        N4=C7.getText().toString().trim();
        TA=1;
        TB=0;
        can8=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate8");
        can8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C8.setText(name);
                    P8.setText(party);
                    Picasso.get().load(image).into(candidate8);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void candidate10() {
        candidate10.setImageResource(R.drawable.voted);
        auditor= "Auditor B";
        N5=C10.getText().toString().trim();
        OB=1;
        OA=0;
        can9=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate9");
        can9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C9.setText(name);
                    P9.setText(party);
                    Picasso.get().load(image).into(candidate9);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void candidate9() {
        candidate9.setImageResource(R.drawable.voted);
        auditor = "Auditor A";
        N5=C9.getText().toString().trim();
        OA=1;
        OB=0;
        can10=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate10");
        can10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C10.setText(name);
                    P10.setText(party);
                    Picasso.get().load(image).into(candidate10);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void candidate12() {
        candidate112.setImageResource(R.drawable.voted);
        N6=C12.getText().toString().trim();
        pro= "PRO B";
        PRB=1;
        PRA=0;
        can11=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate11");
        can11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C11.setText(name);
                    P11.setText(party);
                    Picasso.get().load(image).into(candidate111);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void candidate11() {
        candidate111.setImageResource(R.drawable.voted);
        N6=C11.getText().toString().trim();
        pro = "PRO A";
        PRA=1;
        PRB=0;
        can12=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate12");
        can12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C12.setText(name);
                    P12.setText(party);
                    Picasso.get().load(image).into(candidate112);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void candidate14() {
        candidate114.setImageResource(R.drawable.voted);
        representative= "Representative B";
        N7=C14.getText().toString().trim();
        RB=1;
        RA=0;
        can13=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate13");
        can13.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C13.setText(name);
                    P13.setText(party);
                    Picasso.get().load(image).into(candidate113);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void candidate13() {
        candidate113.setImageResource(R.drawable.voted);
        representative = "Representative A";
        N7=C13.getText().toString().trim();
        RA=1;
        RB=0;
        can14=FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate14");
        can14.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String party = dataSnapshot.child("party").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();
                    Log.d("name", name);
                    Log.d("name", party);
                    Log.d("image", image);
                    C6.setText(name);
                    P6.setText(party);
                    Picasso.get().load(image).into(candidate114);
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void submit() {
        if (president.isEmpty() || vicepresident.isEmpty()||secretary.isEmpty()||treasurer.isEmpty()||auditor.isEmpty()||pro.isEmpty()||representative.isEmpty()) {
            Toast.makeText(voter.this, "You missed to pick a candidate for certain position, No votes are submitted", Toast.LENGTH_LONG).show();
        } else {

            AlertDialog.Builder builder =new AlertDialog.Builder(voter.this);
            builder.setMessage(Html.fromHtml("Are you sure you want to submit your voted candidates?<br>You won't be able to undo changes after.<br><br>President: <b>"+N1+
                    "</b><br>Vicepresident: <b>"+N2+"</b><br>Secretary: <b>"+N3+"</b><br>Treasurer: <b>"+N4+"</b><br>Auditor: <b>"+N5+"</b><br>PRO: <b>"+N6+"</b><br>Representative: <b>"+N7+"</b>"))
                    .setIcon(R.drawable.iconselec)
                    .setTitle("Selected Candidates")
                    .setPositiveButton("submit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            votes voted = new votes(president,vicepresident,PA,PB,VPA,VPB,secretary,treasurer,SA,SB,TA,TB,auditor,pro,OA,OB,PRA,PRB,representative,RA,RB);
                            votes.push().setValue(voted);
                            Toast.makeText(voter.this, "Votes are submitted", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(voter.this, done.class);
                            startActivity(intent);
                            finish();
                            FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    FirebaseAuth.getInstance().getCurrentUser().delete();
                                }
                            });
                        }
                    })
                    .setNegativeButton("Back",null);
            AlertDialog alert=builder.create();
            alert.show();

        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.appvoter:
                Intent intent=new Intent(voter.this,advocacy.class );
                startActivity(intent);
                finish();
                break;
            case R.id.votingsec:
                Intent intent1=new Intent(voter.this,voter.class );
                startActivity(intent1);
                finish();
                break;
            case R.id.signout:
                Signout();
                break;
        }
        return true;
    }

    private void Signout() {
                Toast.makeText(voter.this, "Signed out Successfully", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(voter.this,MainActivity.class );
                startActivity(intent);
                finish();
    }

    public void updateNavHeader(){
        navigationView=findViewById(R.id.nav_view);
        View HeaderView=navigationView.getHeaderView(0);
        TextView navUserName= HeaderView.findViewById(R.id.nav_username);
        ImageView imageview = (ImageView) HeaderView.findViewById(R.id.nav_imageView);
        imageview.setImageResource(R.drawable.selecprofile);
        navUserName.setText(currentuUser.getEmail());

    }

}