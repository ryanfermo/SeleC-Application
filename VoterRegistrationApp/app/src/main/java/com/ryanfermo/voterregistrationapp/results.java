package com.ryanfermo.voterregistrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
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
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class results extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener{
    ImageButton candidate1, candidate2, candidate3, candidate4, candidate5, candidate6, candidate7, candidate8, candidate9, candidate10, candidate111, candidate112,candidate113,candidate114;
    TextView C1, C2, C3, C4, P1, P2, P3, P4,C5, C6, C7, C8, P5, P6, P7, P8,C9, C10, C11, C12, P9, P10, P11, P12,C13,C14,P13,P14;
    TextView PA, PB, VPA, VPB,SA, SB, TA, TB,OA, OB, PRA, PRB,RA, RB;
    DatabaseReference votes,votes2,votes3,votes4,votes5,votes6,votes7,votes8,votes9,votes10,votes11,votes12,votes13,votes14;
    DatabaseReference candidate,candidate12,candidate13,candidate14,can5,can6,can7,can8,can9,can10,can11,can12,can13,can14;
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navigationView;
    Button complete;
    DatabaseReference ItemsModel;
    int count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0,count9=0,count10=0,count11=0,count12=0,count13=0,count14=0;
    String archivedate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ItemsModel = FirebaseDatabase.getInstance().getReference("Archives");
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

        PA=(TextView)findViewById(R.id.PA);
        PB=(TextView)findViewById(R.id.PB);
        VPA=(TextView)findViewById(R.id.VPA);
        VPB=(TextView)findViewById(R.id.VPB);
        SA = (TextView) findViewById(R.id.SA);
        SB = (TextView) findViewById(R.id.SB);
        TA = (TextView) findViewById(R.id.TA);
        TB = (TextView) findViewById(R.id.TB);
        OA=(TextView)findViewById(R.id.OA);
        OB=(TextView)findViewById(R.id.OB);
        PRA=(TextView)findViewById(R.id.PRA);
        PRB=(TextView)findViewById(R.id.PRB);
        RA=(TextView)findViewById(R.id.RA);
        RB=(TextView)findViewById(R.id.RB);

        archivedate = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss", Locale.getDefault()).format(new Date());

        complete=(Button)findViewById(R.id.complete);
        complete.setOnClickListener(this);
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


        candidate1 = (ImageButton) findViewById(R.id.candidate1);
        candidate2 = (ImageButton) findViewById(R.id.candidate2);
        candidate3 = (ImageButton) findViewById(R.id.candidate3);
        candidate4 = (ImageButton) findViewById(R.id.candidate4);
        candidate5 = (ImageButton) findViewById(R.id.candidate5);
        candidate6 = (ImageButton) findViewById(R.id.candidate6);
        candidate7 = (ImageButton) findViewById(R.id.candidate7);
        candidate8 = (ImageButton) findViewById(R.id.candidate8);
        candidate9 = (ImageButton) findViewById(R.id.candidate9);
        candidate10 = (ImageButton) findViewById(R.id.candidate10);
        candidate111 = (ImageButton) findViewById(R.id.candidate11);
        candidate112 = (ImageButton) findViewById(R.id.candidate12);
        candidate113 = (ImageButton) findViewById(R.id.candidate13);
        candidate114 = (ImageButton) findViewById(R.id.candidate14);

        candidate= FirebaseDatabase.getInstance().getReference().child("Candidate").child("Candidate1");
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
                } else {
                    Log.d(TAG, "Data Snapshot is null");
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        votes = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object>map=(Map<String, Object>)ds.getValue();
                    Object pb=map.get("pb");
                    int pValue=Integer.parseInt(String.valueOf(pb));
                    count2+=pValue;
                    Log.d("Sum",String.valueOf(count2));
                    PB.setText(String.valueOf(count2));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });

        votes2 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes2.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object>map=(Map<String, Object>)ds.getValue();
                    Object pa=map.get("pa");
                    int pValue=Integer.parseInt(String.valueOf(pa));
                    count1+=pValue;
                    Log.d("Sum",String.valueOf(count1));
                    PA.setText(String.valueOf(count1));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });
        votes3 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes3.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object>map=(Map<String, Object>)ds.getValue();
                    Object vpb=map.get("vpb");
                    int pValue=Integer.parseInt(String.valueOf(vpb));
                    count4+=pValue;
                    Log.d("Sum",String.valueOf(count4));
                    VPB.setText(String.valueOf(count4));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });
        votes4 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes4.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object>map=(Map<String, Object>)ds.getValue();
                    Object vpa=map.get("vpa");
                    int pValue=Integer.parseInt(String.valueOf(vpa));
                    count3+=pValue;
                    Log.d("Sum",String.valueOf(count3));
                    VPA.setText(String.valueOf(count3));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });

        votes5 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object pb = map.get("sb");
                    int pValue = Integer.parseInt(String.valueOf(pb));
                    count6 += pValue;
                    Log.d("Sum", String.valueOf(count6));
                    SB.setText(String.valueOf(count6));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });

        votes6 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object pa = map.get("sa");
                    int pValue = Integer.parseInt(String.valueOf(pa));
                    count5 += pValue;
                    Log.d("Sum", String.valueOf(count5));
                    SA.setText(String.valueOf(count5));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });
        votes7 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpb = map.get("tb");
                    int pValue = Integer.parseInt(String.valueOf(vpb));
                    count8 += pValue;
                    Log.d("Sum", String.valueOf(count8));
                    TB.setText(String.valueOf(count8));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });
        votes8 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("ta");
                    int pValue = Integer.parseInt(String.valueOf(vpa));
                    count7 += pValue;
                    Log.d("Sum", String.valueOf(count7));
                    TA.setText(String.valueOf(count7));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });


        votes9 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes9.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map=(Map<String, Object>)ds.getValue();
                    Object pb=map.get("ob");
                    int pValue=Integer.parseInt(String.valueOf(pb));
                    count10+=pValue;
                    Log.d("Sum",String.valueOf(count10));
                    OB.setText(String.valueOf(count10));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });

        votes10 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes10.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object>map=(Map<String, Object>)ds.getValue();
                    Object pa=map.get("oa");
                    int pValue=Integer.parseInt(String.valueOf(pa));
                    count9+=pValue;
                    Log.d("Sum",String.valueOf(count9));
                    OA.setText(String.valueOf(count9));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });
        votes11 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes11.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object>map=(Map<String, Object>)ds.getValue();
                    Object vpb=map.get("prb");
                    int pValue=Integer.parseInt(String.valueOf(vpb));
                    count12+=pValue;
                    Log.d("Sum",String.valueOf(count12));
                    PRB.setText(String.valueOf(count12));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });
        votes12 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes12.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object>map=(Map<String, Object>)ds.getValue();
                    Object vpa=map.get("pra");
                    int pValue=Integer.parseInt(String.valueOf(vpa));
                    count11+=pValue;
                    Log.d("Sum",String.valueOf(count11));
                    PRA.setText(String.valueOf(count11));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });
        votes13 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes13.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map=(Map<String, Object>)ds.getValue();
                    Object pb=map.get("rb");
                    int pValue=Integer.parseInt(String.valueOf(pb));
                    count14+=pValue;
                    Log.d("Sum",String.valueOf(count14));
                    RB.setText(String.valueOf(count14));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });

        votes14 = FirebaseDatabase.getInstance().getReference().child("Votes");
        votes14.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object>map=(Map<String, Object>)ds.getValue();
                    Object pa=map.get("ra");
                    int pValue=Integer.parseInt(String.valueOf(pa));
                    count13+=pValue;
                    Log.d("Sum",String.valueOf(count13));
                    RA.setText(String.valueOf(count13));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });

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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.complete:
               sccomplete();
                break;
        }
    }

    private void sccomplete() {
        String president1= C1.getText().toString().trim();
        String president2= C2.getText().toString().trim();
        String vice1= C3.getText().toString().trim();
        String vice2= C4.getText().toString().trim();
        String secretary1= C5.getText().toString().trim();
        String secretary2= C6.getText().toString().trim();
        String treasurer1= C7.getText().toString().trim();
        String treasurer2= C8.getText().toString().trim();
        String auditor1= C9.getText().toString().trim();
        String auditor2= C10.getText().toString().trim();
        String pro1= C11.getText().toString().trim();
        String pro2= C12.getText().toString().trim();
        String rep1= C13.getText().toString().trim();
        String rep2= C14.getText().toString().trim();

        String president11= PA.getText().toString().trim();
        String president21= PB.getText().toString().trim();
        String vice11= VPA.getText().toString().trim();
        String vice21= VPB.getText().toString().trim();
        String secretary11= SA.getText().toString().trim();
        String secretary21= SB.getText().toString().trim();
        String treasurer11= TA.getText().toString().trim();
        String treasurer21= TB.getText().toString().trim();
        String auditor11= OA.getText().toString().trim();
        String auditor21= OB.getText().toString().trim();
        String pro11= PRA.getText().toString().trim();
        String pro21= PRB.getText().toString().trim();
        String rep11= RA.getText().toString().trim();
        String rep21= RB.getText().toString().trim();
        String ardate=archivedate;


            AlertDialog.Builder builder =new AlertDialog.Builder(results.this);
            builder.setMessage("Are you sure you want to end the election?")
                    .setIcon(R.drawable.iconselec)
                    .setTitle("Notice!")
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String id = ItemsModel.push().getKey();
                            ItemsModel archive = new ItemsModel(president1, president2, vice1, vice2, secretary1, secretary2,  treasurer1,  treasurer2,
                                    auditor1,  auditor2,  pro1, pro2,  rep1, rep2, president11,president21, vice11, vice21, secretary11, secretary21, treasurer11, treasurer21,
                                    auditor11,  auditor21, pro11, pro21, rep11, rep21, ardate, id);
                            ItemsModel.child(id).setValue(archive).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()) {
                                        DatabaseReference votes = FirebaseDatabase.getInstance().getReference("Votes");
                                        votes.removeValue();
                                        DatabaseReference candipre1 = FirebaseDatabase.getInstance().getReference("Candidate").child("Candidate1");
                                        candipre1.child("image").setValue("https://firebasestorage.googleapis.com/v0/b/authentication-f5930.appspot.com/o/image%2F854e8b03-4ff6-4c6c-b293-a6baada929f1?alt=media&token=d02cbf6e-9b8e-4eff-845c-51e27f8819a2");
                                        candipre1.child("name").setValue("Default Name");
                                        candipre1.child("party").setValue("Default Partylist");
                                        candipre1.child("advocacy").setValue("Default Advocacy");
                                        DatabaseReference candipre2 = FirebaseDatabase.getInstance().getReference("Candidate").child("Candidate2");
                                        candipre2.child("image").setValue("https://firebasestorage.googleapis.com/v0/b/authentication-f5930.appspot.com/o/image%2F854e8b03-4ff6-4c6c-b293-a6baada929f1?alt=media&token=d02cbf6e-9b8e-4eff-845c-51e27f8819a2");
                                        candipre2.child("name").setValue("Default Name");
                                        candipre2.child("party").setValue("Default Partylist");
                                        candipre2.child("advocacy").setValue("Default Advocacy");
                                        DatabaseReference candipre3 = FirebaseDatabase.getInstance().getReference("Candidate").child("Candidate3");
                                        candipre3.child("image").setValue("https://firebasestorage.googleapis.com/v0/b/authentication-f5930.appspot.com/o/image%2F854e8b03-4ff6-4c6c-b293-a6baada929f1?alt=media&token=d02cbf6e-9b8e-4eff-845c-51e27f8819a2");
                                        candipre3.child("name").setValue("Default Name");
                                        candipre3.child("party").setValue("Default Partylist");
                                        candipre3.child("advocacy").setValue("Default Advocacy");
                                        DatabaseReference candipre4 = FirebaseDatabase.getInstance().getReference("Candidate").child("Candidate4");
                                        candipre4.child("image").setValue("https://firebasestorage.googleapis.com/v0/b/authentication-f5930.appspot.com/o/image%2F854e8b03-4ff6-4c6c-b293-a6baada929f1?alt=media&token=d02cbf6e-9b8e-4eff-845c-51e27f8819a2");
                                        candipre4.child("name").setValue("Default Name");
                                        candipre4.child("party").setValue("Default Partylist");
                                        candipre4.child("advocacy").setValue("Default Advocacy");
                                        DatabaseReference candipre5 = FirebaseDatabase.getInstance().getReference("Candidate").child("Candidate5");
                                        candipre5.child("image").setValue("https://firebasestorage.googleapis.com/v0/b/authentication-f5930.appspot.com/o/image%2F854e8b03-4ff6-4c6c-b293-a6baada929f1?alt=media&token=d02cbf6e-9b8e-4eff-845c-51e27f8819a2");
                                        candipre5.child("name").setValue("Default Name");
                                        candipre5.child("party").setValue("Default Partylist");
                                        candipre5.child("advocacy").setValue("Default Advocacy");
                                        DatabaseReference candipre6 = FirebaseDatabase.getInstance().getReference("Candidate").child("Candidate6");
                                        candipre6.child("image").setValue("https://firebasestorage.googleapis.com/v0/b/authentication-f5930.appspot.com/o/image%2F854e8b03-4ff6-4c6c-b293-a6baada929f1?alt=media&token=d02cbf6e-9b8e-4eff-845c-51e27f8819a2");
                                        candipre6.child("name").setValue("Default Name");
                                        candipre6.child("party").setValue("Default Partylist");
                                        candipre6.child("advocacy").setValue("Default Advocacy");
                                        DatabaseReference candipre7 = FirebaseDatabase.getInstance().getReference("Candidate").child("Candidate7");
                                        candipre7.child("image").setValue("https://firebasestorage.googleapis.com/v0/b/authentication-f5930.appspot.com/o/image%2F854e8b03-4ff6-4c6c-b293-a6baada929f1?alt=media&token=d02cbf6e-9b8e-4eff-845c-51e27f8819a2");
                                        candipre7.child("name").setValue("Default Name");
                                        candipre7.child("party").setValue("Default Partylist");
                                        candipre7.child("advocacy").setValue("Default Advocacy");
                                        DatabaseReference candipre8 = FirebaseDatabase.getInstance().getReference("Candidate").child("Candidate8");
                                        candipre8.child("image").setValue("https://firebasestorage.googleapis.com/v0/b/authentication-f5930.appspot.com/o/image%2F854e8b03-4ff6-4c6c-b293-a6baada929f1?alt=media&token=d02cbf6e-9b8e-4eff-845c-51e27f8819a2");
                                        candipre8.child("name").setValue("Default Name");
                                        candipre8.child("party").setValue("Default Partylist");
                                        candipre8.child("advocacy").setValue("Default Advocacy");
                                        DatabaseReference candipre9 = FirebaseDatabase.getInstance().getReference("Candidate").child("Candidate9");
                                        candipre9.child("image").setValue("https://firebasestorage.googleapis.com/v0/b/authentication-f5930.appspot.com/o/image%2F854e8b03-4ff6-4c6c-b293-a6baada929f1?alt=media&token=d02cbf6e-9b8e-4eff-845c-51e27f8819a2");
                                        candipre9.child("name").setValue("Default Name");
                                        candipre9.child("party").setValue("Default Partylist");
                                        candipre9.child("advocacy").setValue("Default Advocacy");
                                        DatabaseReference candipre10 = FirebaseDatabase.getInstance().getReference("Candidate").child("Candidate10");
                                        candipre10.child("image").setValue("https://firebasestorage.googleapis.com/v0/b/authentication-f5930.appspot.com/o/image%2F854e8b03-4ff6-4c6c-b293-a6baada929f1?alt=media&token=d02cbf6e-9b8e-4eff-845c-51e27f8819a2");
                                        candipre10.child("name").setValue("Default Name");
                                        candipre10.child("party").setValue("Default Partylist");
                                        candipre10.child("advocacy").setValue("Default Advocacy");
                                        DatabaseReference candipre11 = FirebaseDatabase.getInstance().getReference("Candidate").child("Candidate11");
                                        candipre11.child("image").setValue("https://firebasestorage.googleapis.com/v0/b/authentication-f5930.appspot.com/o/image%2F854e8b03-4ff6-4c6c-b293-a6baada929f1?alt=media&token=d02cbf6e-9b8e-4eff-845c-51e27f8819a2");
                                        candipre11.child("name").setValue("Default Name");
                                        candipre11.child("party").setValue("Default Partylist");
                                        candipre11.child("advocacy").setValue("Default Advocacy");
                                        DatabaseReference candipre12 = FirebaseDatabase.getInstance().getReference("Candidate").child("Candidate12");
                                        candipre12.child("image").setValue("https://firebasestorage.googleapis.com/v0/b/authentication-f5930.appspot.com/o/image%2F854e8b03-4ff6-4c6c-b293-a6baada929f1?alt=media&token=d02cbf6e-9b8e-4eff-845c-51e27f8819a2");
                                        candipre12.child("name").setValue("Default Name");
                                        candipre12.child("party").setValue("Default Partylist");
                                        candipre12.child("advocacy").setValue("Default Advocacy");
                                        DatabaseReference candipre13 = FirebaseDatabase.getInstance().getReference("Candidate").child("Candidate13");
                                        candipre13.child("image").setValue("https://firebasestorage.googleapis.com/v0/b/authentication-f5930.appspot.com/o/image%2F854e8b03-4ff6-4c6c-b293-a6baada929f1?alt=media&token=d02cbf6e-9b8e-4eff-845c-51e27f8819a2");
                                        candipre13.child("name").setValue("Default Name");
                                        candipre13.child("party").setValue("Default Partylist");
                                        candipre13.child("advocacy").setValue("Default Advocacy");
                                        DatabaseReference candipre14 = FirebaseDatabase.getInstance().getReference("Candidate").child("Candidate14");
                                        candipre14.child("image").setValue("https://firebasestorage.googleapis.com/v0/b/authentication-f5930.appspot.com/o/image%2F854e8b03-4ff6-4c6c-b293-a6baada929f1?alt=media&token=d02cbf6e-9b8e-4eff-845c-51e27f8819a2");
                                        candipre14.child("name").setValue("Default Name");
                                        candipre14.child("party").setValue("Default Partylist");
                                        candipre14.child("advocacy").setValue("Default Advocacy");
                                        Toast.makeText(results.this, "ELECTION END", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(results.this, archive_votes.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(results.this, "Failed to END!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    })
                    .setNegativeButton("NO",null);
            AlertDialog alert=builder.create();
            alert.show();
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