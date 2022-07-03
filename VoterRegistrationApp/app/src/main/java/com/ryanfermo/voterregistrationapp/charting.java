package com.ryanfermo.voterregistrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Map;

import static android.content.ContentValues.TAG;

public class charting extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener{
    DatabaseReference BSIT, BACom, ABPolScie, BSPharm, BLIS, BSc, BMid, BSN, ACT, BCA, BSEd, BSTM, BSHRM, BSBA, BSOA, BSA, AACS, BSE, BArch, total, total1;
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navigationView;
    Integer totalbsit=0, totalbacom=0, totalabpolscie=0, totalbspharm=0, totalblis=0, totalbsc=0, totalbmid=0, totalbsn=0, totalact=0,
            totalbca=0, totalbsed=0, totalbstm=0, totalbshrm=0, totalbsba=0, totalbsoa=0, totalbsa=0, totalaacs=0, totalbse=0, totalbarch=0;
    Integer finalbsit, finalbacom, finalabpolscie, finalbspharm, finalblis, finalbsc, finalbmid, finalbsn, finalact, finalbca, finalbsed,
            finalbstm, finalbshrm, finalbsba, finalbsoa, finalbsa, finalaacs, finalbse, finalbarch;
    TextView bsit,bacom,abpolscie,bspharm,blis,bsc,bmid,bsn,act,bca,bsed,bstm,bshrm,bsba,bsoa,bsa,aacs,bse,barch,totalcount;
    Integer accutotal=0, accutotal1=0;
    Integer finaltotal;
    Integer c1=0, c2=0, c3=0, c4=0, c5=0, c6=0, c7=0, c8=0, c9=0, c10=0, c11=0, c12=0, c13=0, c14=0, c15=0, c16=0, c17=0, c18=0, c19=0;
    Button next;
    TextView pop1,pop2,pop3,pop4,pop5,pop6,pop7,pop8,pop9,pop10,pop11,pop12,pop13,pop14,pop15,pop16,pop17,pop18,pop19;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charting);

        bsit=(TextView)findViewById(R.id.bsit);
        bacom=(TextView)findViewById(R.id.bacom);
        abpolscie=(TextView)findViewById(R.id.abpolscie);
        bspharm=(TextView)findViewById(R.id.bspharm);
        blis=(TextView)findViewById(R.id.blis);
        bsc=(TextView)findViewById(R.id. bsc);
        bmid=(TextView)findViewById(R.id.bmid);
        bsn=(TextView)findViewById(R.id.bsn);
        act=(TextView)findViewById(R.id.act);
        bca=(TextView)findViewById(R.id.bca);
        bsed=(TextView)findViewById(R.id.bsed);
        bstm=(TextView)findViewById(R.id.bstm);
        bshrm=(TextView)findViewById(R.id.bshrm);
        bsba=(TextView)findViewById(R.id.bsba);
        bsoa=(TextView)findViewById(R.id.bsoa);
        bsa=(TextView)findViewById(R.id.bsa);
        aacs=(TextView)findViewById(R.id.aacs);
        bse=(TextView)findViewById(R.id.bse);
        barch=(TextView)findViewById(R.id.barch);

        totalcount=(TextView)findViewById(R.id.textView36);

        pop1=(TextView)findViewById(R.id.pop1);
        pop1.setOnClickListener(this);
        pop2=(TextView)findViewById(R.id.pop2);
        pop2.setOnClickListener(this);
        pop3=(TextView)findViewById(R.id.pop3);
        pop3.setOnClickListener(this);
        pop4=(TextView)findViewById(R.id.pop4);
        pop4.setOnClickListener(this);
        pop5=(TextView)findViewById(R.id.pop5);
        pop5.setOnClickListener(this);
        pop6=(TextView)findViewById(R.id.pop6);
        pop6.setOnClickListener(this);
        pop7=(TextView)findViewById(R.id.pop7);
        pop7.setOnClickListener(this);
        pop8=(TextView)findViewById(R.id.pop8);
        pop8.setOnClickListener(this);
        pop9=(TextView)findViewById(R.id.pop9);
        pop9.setOnClickListener(this);
        pop10=(TextView)findViewById(R.id.pop10);
        pop10.setOnClickListener(this);
        pop11=(TextView)findViewById(R.id.pop11);
        pop11.setOnClickListener(this);
        pop12=(TextView)findViewById(R.id.pop12);
        pop12.setOnClickListener(this);
        pop13=(TextView)findViewById(R.id.pop13);
        pop13.setOnClickListener(this);
        pop14=(TextView)findViewById(R.id.pop14);
        pop14.setOnClickListener(this);
        pop15=(TextView)findViewById(R.id.pop15);
        pop15.setOnClickListener(this);
        pop16=(TextView)findViewById(R.id.pop16);
        pop16.setOnClickListener(this);
        pop17=(TextView)findViewById(R.id.pop17);
        pop17.setOnClickListener(this);
        pop18=(TextView)findViewById(R.id.pop18);
        pop18.setOnClickListener(this);
        pop19=(TextView)findViewById(R.id.pop19);
        pop19.setOnClickListener(this);

        updateNavHeader();
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        next=(Button)findViewById(R.id.next);
        next.setOnClickListener(this);

        BSIT= FirebaseDatabase.getInstance().getReference().child("Users");
        BSIT.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("BSIT1") ||
                                    vpa.equals("BSIT2") ||
                                    vpa.equals("BSIT3") ||
                                    vpa.equals("BSIT4")) {
                        c1 = 1;
                        totalbsit += c1;
                        finalbsit = (8 - totalbsit) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        bsit.setText(String.valueOf(finalbsit + "%"));

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        BACom= FirebaseDatabase.getInstance().getReference().child("Users");
        BACom.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("BACom1") ||
                                    vpa.equals("BACom2") ||
                                    vpa.equals("BACom3") ||
                                    vpa.equals("BACom4")) {
                        c2 = 1;
                        totalbacom += c2;
                        finalbacom = (8 - totalbacom) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        bacom.setText(String.valueOf(finalbacom + "%"));
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        ABPolScie= FirebaseDatabase.getInstance().getReference().child("Users");
        ABPolScie.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("ABPolScie1") ||
                                    vpa.equals("ABPolScie2") ||
                                    vpa.equals("ABPolScie3") ||
                                    vpa.equals("ABPolScie4")) {
                        c3 = 1;
                        totalabpolscie += c3;
                        finalabpolscie = (8 - totalabpolscie) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        abpolscie.setText(finalabpolscie + "%");

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        BSPharm= FirebaseDatabase.getInstance().getReference().child("Users");
        BSPharm.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("BSPharm1") ||
                                    vpa.equals("BSPharm2") ||
                                    vpa.equals("BSPharm3") ||
                                    vpa.equals("BSPharm4")) {
                        c4 = 1;
                        totalbspharm += c4;
                        finalbspharm = (8 - totalbspharm) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        bspharm.setText(finalbspharm + "%");

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        BLIS= FirebaseDatabase.getInstance().getReference().child("Users");
        BLIS.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("BLIS1") ||
                                    vpa.equals("BLIS2") ||
                                    vpa.equals("BLIS3") ||
                                    vpa.equals("BLIS4")) {
                        c5 = 1;
                        totalblis += c5;
                        finalblis = (8 - totalblis) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        blis.setText(finalblis + "%");

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        BSc= FirebaseDatabase.getInstance().getReference().child("Users");
        BSc.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("BSc1") ||
                                    vpa.equals("BSc2") ||
                                    vpa.equals("BSc3") ||
                                    vpa.equals("BSc4")) {
                        c6 = 1;
                        totalbsc += c6;
                        finalbsc = (8 - totalbsc) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        bsc.setText(finalbsc + "%");

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        BMid= FirebaseDatabase.getInstance().getReference().child("Users");
        BMid.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("BMid1") ||
                                    vpa.equals("BMid2") ||
                                    vpa.equals("BMid3") ||
                                    vpa.equals("BMid4")) {
                        c7 = 1;
                        totalbmid += c7;
                        finalbmid = (8 - totalbmid) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        bmid.setText(finalbmid + "%");

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        BSN= FirebaseDatabase.getInstance().getReference().child("Users");
        BSN.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("BSN1") ||
                                    vpa.equals("BSN2") ||
                                    vpa.equals("BSN3") ||
                                    vpa.equals("BSN4")) {
                        c8 = 1;
                        totalbsn += c8;
                        finalbsn = (8 - totalbsn) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        bsn.setText(finalbsn + "%");

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        ACT= FirebaseDatabase.getInstance().getReference().child("Users");
        ACT.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("ACT1") ||
                                    vpa.equals("ACT2")) {
                        c9= 1;
                        totalact += c9;
                        finalact = (4 - totalact) * 100 / 4;
                        Log.d("course", ds.child("course").getValue().toString());
                        act.setText(finalact + "%");

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        BCA= FirebaseDatabase.getInstance().getReference().child("Users");
        BCA.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("BCA1") ||
                                    vpa.equals("BCA2") ||
                                    vpa.equals("BCA3") ||
                                    vpa.equals("BCA4")) {
                        c10 = 1;
                        totalbca += c10;
                        finalbca = (8 - totalbca) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        bca.setText(finalbca + "%");

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        BSEd= FirebaseDatabase.getInstance().getReference().child("Users");
        BSEd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("BSEd1") ||
                                    vpa.equals("BSEd2") ||
                                    vpa.equals("BSEd3") ||
                                    vpa.equals("BSEd4")) {
                        c11 = 1;
                        totalbsed += c11;
                        finalbsed = (8 - totalbsed) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        bsed.setText(finalbsed + "%");

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        BSTM= FirebaseDatabase.getInstance().getReference().child("Users");
        BSTM.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("BSTM1") ||
                                    vpa.equals("BSTM2") ||
                                    vpa.equals("BSTM3") ||
                                    vpa.equals("BSTM4")) {
                        c12 = 1;
                        totalbstm += c12;
                        finalbstm = (8 - totalbstm) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        bstm.setText(finalbstm + "%");

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        BSHRM= FirebaseDatabase.getInstance().getReference().child("Users");
        BSHRM.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("BSHRM1") ||
                                    vpa.equals("BSHRM2") ||
                                    vpa.equals("BSHRM3") ||
                                    vpa.equals("BSHRM4")) {
                        c13 = 1;
                        totalbshrm += c13;
                        finalbshrm = (8 - totalbshrm) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        bshrm.setText(finalbshrm + "%");

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        BSBA= FirebaseDatabase.getInstance().getReference().child("Users");
        BSBA.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("BSBA1") ||
                                    vpa.equals("BSBA2") ||
                                    vpa.equals("BSBA3") ||
                                    vpa.equals("BSBA4")) {
                        c14 = 1;
                        totalbsba += c14;
                        finalbsba = (8 - totalbsba) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        bsba.setText(finalbsba + "%");

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        BSOA= FirebaseDatabase.getInstance().getReference().child("Users");
        BSOA.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("BSOA1") ||
                                    vpa.equals("BSOA2") ||
                                    vpa.equals("BSOA3") ||
                                    vpa.equals("BSOA4")) {
                        c15 = 1;
                        totalbsoa += c5;
                        finalbsoa = (8 - totalbsoa) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        bsoa.setText(finalbsoa + "%");

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        BSA= FirebaseDatabase.getInstance().getReference().child("Users");
        BSA.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                            vpa.equals("BSA1") ||
                                    vpa.equals("BSA2") ||
                                    vpa.equals("BSA3") ||
                                    vpa.equals("BSA4")) {
                        c16 = 1;
                        totalbsa += c16;
                        finalbsa = (8 - totalbsa) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        bsa.setText(finalbsa + "%");

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        AACS= FirebaseDatabase.getInstance().getReference().child("Users");
        AACS.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                                    vpa.equals("AACS1") ||
                                    vpa.equals("AACS2")) {
                        c17 = 1;
                    totalaacs+=c17;
                    finalaacs=(4-totalaacs)*100/4;
                    Log.d("course",ds.child("course").getValue().toString());
                    aacs.setText(finalaacs+"%");

                   }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        BSE= FirebaseDatabase.getInstance().getReference().child("Users");
        BSE.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (
                                    vpa.equals("BSE1") ||
                                    vpa.equals("BSE2") ||
                                    vpa.equals("BSE3") ||
                                    vpa.equals("BSE4")) {
                        c18 = 1;
                        totalbse += c18;
                        finalbse = (8 - totalbse) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        bse.setText(finalbse + "%");

                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        BArch= FirebaseDatabase.getInstance().getReference().child("Users");
        BArch.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if(
                            vpa.equals("BArch1")||
                            vpa.equals("BArch2")||
                            vpa.equals("BArch3")||
                            vpa.equals("BArch4")) {
                        c19 = 1;
                        totalbarch += c19;
                        finalbarch = (8 - totalbarch) * 100 / 8;
                        Log.d("course", ds.child("course").getValue().toString());
                        barch.setText(finalbarch + "%");
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        total = FirebaseDatabase.getInstance().getReference().child("Votes");
        total.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object>map=(Map<String, Object>)ds.getValue();
                    Object vpb=map.get("prb");
                    int pValue=Integer.parseInt(String.valueOf(vpb));
                    accutotal1+=pValue;
                    Log.d("Sum",String.valueOf(accutotal1));
                    finaltotal=accutotal+accutotal1;
                    totalcount.setText(String.valueOf(finaltotal+"%"));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });
        total1 = FirebaseDatabase.getInstance().getReference().child("Votes");
        total1.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object>map=(Map<String, Object>)ds.getValue();
                    Object vpa=map.get("pra");
                    int pValue=Integer.parseInt(String.valueOf(vpa));
                    accutotal+=pValue;
                    Log.d("Sum",String.valueOf(accutotal));
                    finaltotal=(accutotal+accutotal1)*100/144;
                    totalcount.setText(String.valueOf(finaltotal+"%"));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });

    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.next:
                Intent intent=new Intent(this,records.class);
                startActivity(intent);
                finish();
                break;

            case R.id.pop1:
                String poppy1=bacom.getText().toString().trim();
                AlertDialog.Builder builder1 =new AlertDialog.Builder(charting.this);
                builder1.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy1+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert1=builder1.create();
                alert1.show();
                break;
            case R.id.pop2:
                String poppy2=abpolscie.getText().toString().trim();
                AlertDialog.Builder builder2 =new AlertDialog.Builder(charting.this);
                builder2.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy2+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert2=builder2.create();
                alert2.show();
                break;
            case R.id.pop3:
                String poppy3=bspharm.getText().toString().trim();
                AlertDialog.Builder builder3 =new AlertDialog.Builder(charting.this);
                builder3.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy3+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert3=builder3.create();
                alert3.show();
                break;
            case R.id.pop4:
                String poppy4=bshrm.getText().toString().trim();
                AlertDialog.Builder builder4 =new AlertDialog.Builder(charting.this);
                builder4.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy4+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert4=builder4.create();
                alert4.show();
                break;
            case R.id.pop5:
                String poppy5=blis.getText().toString().trim();
                AlertDialog.Builder builder5 =new AlertDialog.Builder(charting.this);
                builder5.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy5+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert5=builder5.create();
                alert5.show();
                break;
            case R.id.pop6:
                String poppy6=bsc.getText().toString().trim();
                AlertDialog.Builder builder6 =new AlertDialog.Builder(charting.this);
                builder6.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy6+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert6=builder6.create();
                alert6.show();
                break;
            case R.id.pop7:
                String poppy7=bmid.getText().toString().trim();
                AlertDialog.Builder builder7 =new AlertDialog.Builder(charting.this);
                builder7.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy7+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert7=builder7.create();
                alert7.show();
                break;
            case R.id.pop8:
                String poppy8=bsn.getText().toString().trim();
                AlertDialog.Builder builder8 =new AlertDialog.Builder(charting.this);
                builder8.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy8+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert8=builder8.create();
                alert8.show();
                break;
            case R.id.pop9:
                String poppy9=bsit.getText().toString().trim();
                AlertDialog.Builder builder9 =new AlertDialog.Builder(charting.this);
                builder9.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy9+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert9=builder9.create();
                alert9.show();
                break;
            case R.id.pop10:
                String poppy10=act.getText().toString().trim();
                AlertDialog.Builder builder10 =new AlertDialog.Builder(charting.this);
                builder10.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy10+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert10=builder10.create();
                alert10.show();
                break;
            case R.id.pop11:
                String poppy11=bca.getText().toString().trim();
                AlertDialog.Builder builder11 =new AlertDialog.Builder(charting.this);
                builder11.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy11+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11=builder11.create();
                alert11.show();
                break;
            case R.id.pop12:
                String poppy12=bsed.getText().toString().trim();
                AlertDialog.Builder builder12 =new AlertDialog.Builder(charting.this);
                builder12.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy12+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert12=builder12.create();
                alert12.show();
                break;
            case R.id.pop13:
                String poppy13=bstm.getText().toString().trim();
                AlertDialog.Builder builder13 =new AlertDialog.Builder(charting.this);
                builder13.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy13+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert13=builder13.create();
                alert13.show();
                break;
            case R.id.pop14:
                String poppy14=bsba.getText().toString().trim();
                AlertDialog.Builder builder14 =new AlertDialog.Builder(charting.this);
                builder14.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy14+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert14=builder14.create();
                alert14.show();
                break;
            case R.id.pop15:
                String poppy15=bsoa.getText().toString().trim();
                AlertDialog.Builder builder15 =new AlertDialog.Builder(charting.this);
                builder15.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy15+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert15=builder15.create();
                alert15.show();
                break;
            case R.id.pop16:
                String poppy16=bsa.getText().toString().trim();
                AlertDialog.Builder builder16 =new AlertDialog.Builder(charting.this);
                builder16.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy16+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert16=builder16.create();
                alert16.show();
                break;
            case R.id.pop17:
                String poppy17=aacs.getText().toString().trim();
                AlertDialog.Builder builder17 =new AlertDialog.Builder(charting.this);
                builder17.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy17+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert17=builder17.create();
                alert17.show();
                break;
            case R.id.pop18:
                String poppy18=bse.getText().toString().trim();
                AlertDialog.Builder builder18 =new AlertDialog.Builder(charting.this);
                builder18.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy18+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert18=builder18.create();
                alert18.show();
                break;
            case R.id.pop19:
                String poppy19=barch.getText().toString().trim();
                AlertDialog.Builder builder19 =new AlertDialog.Builder(charting.this);
                builder19.setMessage(Html.fromHtml("<center>The Overall percentage vote of BACom is <b>"+poppy19+"</center></b>."))
                        .setIcon(R.drawable.iconselec)
                        .setTitle("Vote Percentage")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert19=builder19.create();
                alert19.show();
                break;
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