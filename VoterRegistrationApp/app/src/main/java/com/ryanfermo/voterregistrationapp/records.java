package com.ryanfermo.voterregistrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class records extends AppCompatActivity implements  View.OnClickListener,NavigationView.OnNavigationItemSelectedListener{
    DatabaseReference BSIT, BACom, ABPolScie, BSPharm, BLIS, BSc, BMid, BSN, ACT, BCA, BSEd, BSTM, BSHRM, BSBA, BSOA, BSA, AACS, BSE, BArch;
    Button back;
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navigationView;
    TextView p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,p32,p33,p34,p35,p36,p37,
            p38,p39,p40,p41,p42,p43,p44,p45,p46,p47,p48,p49,p50,p51,p52,p53,p54,p55,p56,p57,p58,p59,p60,p61,p62,p63,p64,p65,p66,p67,p68,p69,p70,p71,p72;
    int finalbsit1=0,finalbsit2=0,finalbsit3=0,finalbsit4=0,finalbacom1=0,finalbacom2=0,finalbacom3=0,finalbacom4=0,finalabpolscie1=0,finalabpolscie2=0,finalabpolscie3=0,finalabpolscie4=0
            ,finalbspharm1=0,finalbspharm2=0,finalbspharm3=0,finalbspharm4=0,finalblis1=0,finalblis2=0,finalblis3=0,finalblis4=0,finalbsc1=0,finalbsc2=0,finalbsc3=0,finalbsc4=0
            ,finalbmid1=0,finalbmid2=0,finalbmid3=0,finalbmid4=0,finalbsn1=0,finalbsn2=0,finalbsn3=0,finalbsn4=0,finalact1=0,finalact2=0
            ,finalbca1=0,finalbca2=0,finalbca3=0,finalbca4=0,finalbsed1=0,finalbsed2=0,finalbsed3=0,finalbsed4=0,finalbstm1=0,finalbstm2=0,finalbstm3=0,finalbstm4=0
            ,finalbshrm1=0,finalbshrm2=0,finalbshrm3=0,finalbshrm4=0,finalbsba1=0,finalbsba2=0,finalbsba3=0,finalbsba4=0,finalbsoa1=0,finalbsoa2=0,finalbsoa3=0,finalbsoa4=0
            ,finalbsa1=0,finalbsa2=0,finalbsa3=0,finalbsa4=0,finalaacs1=0,finalaacs2=0,finalbse1=0,finalbse2=0,finalbse3=0,finalbse4=0
            ,finalbarch1=0,finalbarch2=0,finalbarch3=0,finalbarch4=0;
    int pfinalbsit1=0,pfinalbsit2=0,pfinalbsit3=0,pfinalbsit4=0,pfinalbacom1=0,pfinalbacom2=0,pfinalbacom3=0,pfinalbacom4=0,pfinalabpolscie1=0,pfinalabpolscie2=0,pfinalabpolscie3=0,pfinalabpolscie4=0
            ,pfinalbspharm1=0,pfinalbspharm2=0,pfinalbspharm3=0,pfinalbspharm4=0,pfinalblis1=0,pfinalblis2=0,pfinalblis3=0,pfinalblis4=0,pfinalbsc1=0,pfinalbsc2=0,pfinalbsc3=0,pfinalbsc4=0
            ,pfinalbmid1=0,pfinalbmid2=0,pfinalbmid3=0,pfinalbmid4=0,pfinalbsn1=0,pfinalbsn2=0,pfinalbsn3=0,pfinalbsn4=0,pfinalact1=0,pfinalact2=0
            ,pfinalbca1=0,pfinalbca2=0,pfinalbca3=0,pfinalbca4=0,pfinalbsed1=0,pfinalbsed2=0,pfinalbsed3=0,pfinalbsed4=0,pfinalbstm1=0,pfinalbstm2=0,pfinalbstm3=0,pfinalbstm4=0
            ,pfinalbshrm1=0,pfinalbshrm2=0,pfinalbshrm3=0,pfinalbshrm4=0,pfinalbsba1=0,pfinalbsba2=0,pfinalbsba3=0,pfinalbsba4=0,pfinalbsoa1=0,pfinalbsoa2=0,pfinalbsoa3=0,pfinalbsoa4=0
            ,pfinalbsa1=0,pfinalbsa2=0,pfinalbsa3=0,pfinalbsa4=0,pfinalaacs1=0,pfinalaacs2=0,pfinalbse1=0,pfinalbse2=0,pfinalbse3=0,pfinalbse4=0
            ,pfinalbarch1=0,pfinalbarch2=0,pfinalbarch3=0,pfinalbarch4=0;
    int c1=0, c2=0, c3=0, c4=0,c5=0, c6=0, c7=0, c8=0,c9=0, c10=0, c11=0, c12=0,c13=0, c14=0, c15=0, c16=0,c17=0, c18=0, c19=0, c20=0,c21=0, c22=0, c23=0, c24=0,c25=0, c26=0, c27=0, c28=0,c29=0, c30=0, c31=0, c32=0
            ,c33=0, c34=0, c35=0, c36=0,c37=0, c38=0, c39=0, c40=0,c41=0, c42=0, c43=0, c44=0,c45=0, c46=0, c47=0, c48=0,c49=0, c50=0, c51=0, c52=0,c53=0, c54=0, c55=0, c56=0,c57=0, c58=0, c59=0, c60=0
            ,c61=0, c62=0, c63=0, c64=0,c65=0, c66=0, c67=0, c68=0,c69=0, c70=0, c71=0, c72=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        ActivityCompat.requestPermissions(records.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        p1=(TextView)findViewById(R.id.p1);p21=(TextView)findViewById(R.id.p21);p41=(TextView)findViewById(R.id.p41);p57=(TextView)findViewById(R.id.p57);
        p2=(TextView)findViewById(R.id.p2);p22=(TextView)findViewById(R.id.p22);p42=(TextView)findViewById(R.id.p42);p58=(TextView)findViewById(R.id.p58);
        p3=(TextView)findViewById(R.id.p3);p23=(TextView)findViewById(R.id.p23);p43=(TextView)findViewById(R.id.p43);p59=(TextView)findViewById(R.id.p59);
        p4=(TextView)findViewById(R.id.p4);p24=(TextView)findViewById(R.id.p24);p44=(TextView)findViewById(R.id.p44);p60=(TextView)findViewById(R.id.p60);
        p5=(TextView)findViewById(R.id.p5);p25=(TextView)findViewById(R.id.p25);p45=(TextView)findViewById(R.id.p45);p61=(TextView)findViewById(R.id.p61);
        p6=(TextView)findViewById(R.id.p6);p26=(TextView)findViewById(R.id.p26);p46=(TextView)findViewById(R.id.p46);p62=(TextView)findViewById(R.id.p62);
        p7=(TextView)findViewById(R.id.p7);p27=(TextView)findViewById(R.id.p27);p47=(TextView)findViewById(R.id.p47);p63=(TextView)findViewById(R.id.p63);
        p8=(TextView)findViewById(R.id.p8);p28=(TextView)findViewById(R.id.p28);p48=(TextView)findViewById(R.id.p48);p64=(TextView)findViewById(R.id.p64);
        p9=(TextView)findViewById(R.id.p9);p29=(TextView)findViewById(R.id.p29);p49=(TextView)findViewById(R.id.p49);p65=(TextView)findViewById(R.id.p65);
        p10=(TextView)findViewById(R.id.p10);p30=(TextView)findViewById(R.id.p30);p50=(TextView)findViewById(R.id.p50);p66=(TextView)findViewById(R.id.p66);
        p11=(TextView)findViewById(R.id.p11);p31=(TextView)findViewById(R.id.p31);p51=(TextView)findViewById(R.id.p51);p67=(TextView)findViewById(R.id.p67);
        p12=(TextView)findViewById(R.id.p12);p32=(TextView)findViewById(R.id.p32);p52=(TextView)findViewById(R.id.p52);p68=(TextView)findViewById(R.id.p68);
        p13=(TextView)findViewById(R.id.p13);p33=(TextView)findViewById(R.id.p33);p53=(TextView)findViewById(R.id.p53);p69=(TextView)findViewById(R.id.p69);
        p14=(TextView)findViewById(R.id.p14);p34=(TextView)findViewById(R.id.p34);p54=(TextView)findViewById(R.id.p54);p70=(TextView)findViewById(R.id.p70);
        p15=(TextView)findViewById(R.id.p15);p35=(TextView)findViewById(R.id.p35);p55=(TextView)findViewById(R.id.p55);p71=(TextView)findViewById(R.id.p71);
        p16=(TextView)findViewById(R.id.p16);p36=(TextView)findViewById(R.id.p36);p56=(TextView)findViewById(R.id.p56);p72=(TextView)findViewById(R.id.p72);
        p17=(TextView)findViewById(R.id.p17);p37=(TextView)findViewById(R.id.p37);
        p18=(TextView)findViewById(R.id.p18);p38=(TextView)findViewById(R.id.p38);
        p19=(TextView)findViewById(R.id.p19);p39=(TextView)findViewById(R.id.p39);
        p20=(TextView)findViewById(R.id.p20);p40=(TextView)findViewById(R.id.p40);
        back=(Button)findViewById(R.id.back);
        back.setOnClickListener(this);
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

        BSIT= FirebaseDatabase.getInstance().getReference().child("Users");
        BSIT.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object vpa = map.get("course");
                    if (vpa.equals("BSIT1")){
                        c1 = 1;
                        pfinalbsit1 += c1;
                        finalbsit1 = (2 - pfinalbsit1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p1.setText("BSIT1: "+finalbsit1+"%");

                    }
                    if (vpa.equals("BSIT2")){
                         c2 = 1;
                        pfinalbsit2 += c2;
                        finalbsit2 = (2 - pfinalbsit2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p2.setText("BSIT2: "+finalbsit2+"%");
                    }
                    if (vpa.equals("BSIT3")){
                        c3 = 1;
                        pfinalbsit3 += c3;
                        finalbsit3 = (2 - pfinalbsit3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p3.setText("BSIT3: "+finalbsit3+"%");
                    }
                    if (vpa.equals("BSIT4")){
                        c4 = 1;
                        pfinalbsit4 += c4;
                        finalbsit4 = (2 - pfinalbsit4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p4.setText("BSIT4: "+finalbsit4+"%");
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
                    if (vpa.equals("BACom1")){
                        c5 = 1;
                        pfinalbacom1 += c5;
                        finalbacom1 = (2 - pfinalbacom1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p5.setText("BACom1: "+finalbacom1+"%");

                    }
                    if (vpa.equals("BACom2")){
                        c6 = 1;
                        pfinalbacom2 += c6;
                        finalbacom2 = (2 - pfinalbacom2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p6.setText("BACom2: "+finalbacom2+"%");
                    }
                    if (vpa.equals("BACom3")){
                        c7 = 1;
                        pfinalbacom3 += c7;
                        finalbacom3 = (2 - pfinalbacom3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p7.setText("BACom3: "+finalbacom3+"%");
                    }
                    if (vpa.equals("BACom4")){
                        c8 = 1;
                        pfinalbacom4 += c8;
                        finalbacom4 = (2 - pfinalbacom4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p8.setText("BACom4: "+finalbacom4+"%");
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
                    if (vpa.equals("ABPolScie1")){
                        c9 = 1;
                        pfinalabpolscie1 += c9;
                        finalabpolscie1 = (2 - pfinalabpolscie1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p9.setText("ABPolScie1: "+finalabpolscie1+"%");

                    }
                    if (vpa.equals("ABPolScie2")){
                        c10 = 1;
                        pfinalabpolscie2 += c10;
                        finalabpolscie2 = (2 - pfinalabpolscie2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p10.setText("ABPolScie2: "+finalabpolscie2+"%");
                    }
                    if (vpa.equals("ABPolScie3")){
                        c11 = 1;
                        pfinalabpolscie3 += c11;
                        finalabpolscie3 = (2 - pfinalabpolscie3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p11.setText("ABPolScie3: "+finalabpolscie3+"%");
                    }
                    if (vpa.equals("ABPolScie4")){
                        c12 = 1;
                        pfinalabpolscie4 += c12;
                        finalabpolscie4 = (2 - pfinalabpolscie4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p12.setText("ABPolScie4: "+finalabpolscie4+"%");
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
                    if (vpa.equals("BSPharm1")){
                        c13 = 1;
                        pfinalbspharm1 += c13;
                        finalbspharm1 = (2 - pfinalbspharm1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p13.setText("BSPharm1: "+finalbspharm1+"%");

                    }
                    if (vpa.equals("BSPharm2")){
                        c14 = 1;
                        pfinalbspharm2 += c14;
                        finalbspharm2 = (2 - pfinalbspharm2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p14.setText("BSPharm2: "+finalbspharm2+"%");
                    }
                    if (vpa.equals("BSPharm3")){
                        c15 = 1;
                        pfinalbspharm3 += c15;
                        finalbspharm3 = (2 - pfinalbspharm3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p15.setText("BSPharm3: "+finalbspharm3+"%");
                    }
                    if (vpa.equals("BSPharm4")){
                        c16 = 1;
                        pfinalbspharm4 += c16;
                        finalbspharm4 = (2 - pfinalbspharm4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p16.setText("BSPharm4: "+finalbspharm4+"%");
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
                    if (vpa.equals("BSHRM1")){
                        c17 = 1;
                        pfinalbshrm1 += c17;
                        finalbshrm1 = (2 - pfinalbshrm1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p17.setText("BSHRM1: "+finalbshrm1+"%");

                    }
                    if (vpa.equals("BSHRM2")){
                        c18 = 1;
                        pfinalbshrm2 += c18;
                        finalbshrm2 = (2 - pfinalbshrm2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p18.setText("BSHRM2: "+finalbshrm2+"%");
                    }
                    if (vpa.equals("BSHRM3")){
                        c19 = 1;
                        pfinalbshrm3 += c19;
                        finalbshrm3 = (2 - pfinalbshrm3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p19.setText("BSHRM3: "+finalbshrm3+"%");
                    }
                    if (vpa.equals("BSHRM4")){
                        c20 = 1;
                        pfinalbshrm4 += c20;
                        finalbshrm4 = (2 - pfinalbshrm4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p20.setText("BSHRM4: "+finalbshrm4+"%");
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
                    if (vpa.equals("BLIS1")){
                        c21 = 1;
                        pfinalblis1 += c21;
                        finalblis1 = (2 - pfinalblis1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p21.setText("BLIS1: "+finalblis1+"%");

                    }
                    if (vpa.equals("BLIS2")){
                        c22 = 1;
                        pfinalblis2 += c22;
                        finalblis2 = (2 - pfinalblis2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p22.setText("BLIS2: "+finalblis2+"%");
                    }
                    if (vpa.equals("BLIS3")){
                        c23 = 1;
                        pfinalblis3 += c23;
                        finalblis3 = (2 - pfinalblis3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p23.setText("BLIS3: "+finalblis3+"%");
                    }
                    if (vpa.equals("BLIS4")){
                        c24 = 1;
                        pfinalblis4 += c24;
                        finalblis4 = (2 - pfinalblis4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p24.setText("BLIS4: "+finalblis4+"%");
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
                    if (vpa.equals("BSc1")){
                        c25 = 1;
                        pfinalbsc1 += c25;
                        finalbsc1 = (2 - pfinalbsc1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p25.setText("BSc1: "+finalbsc1+"%");

                    }
                    if (vpa.equals("BSc2")){
                        c26 = 1;
                        pfinalbsc2 += c26;
                        finalbsc2 = (2 - pfinalbsc2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p26.setText("BSc2: "+finalbsc2+"%");
                    }
                    if (vpa.equals("BSc3")){
                        c27 = 1;
                        pfinalbsc3 += c27;
                        finalbsc3 = (2 - pfinalbsc3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p27.setText("BSc3: "+finalbsc3+"%");
                    }
                    if (vpa.equals("BSc4")){
                        c28 = 1;
                        pfinalbsc4 += c28;
                        finalbsc4 = (2 - pfinalbsc4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p28.setText("BSc4: "+finalbsc4+"%");
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
                    if (vpa.equals("BMid1")){
                        c29 = 1;
                        pfinalbmid1 += c29;
                        finalbmid1 = (2 - pfinalbmid1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p29.setText("BMid1: "+finalbmid1+"%");

                    }
                    if (vpa.equals("BMid2")){
                        c30 = 1;
                        pfinalbmid2 += c30;
                        finalbmid2 = (2 - pfinalbmid2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p30.setText("BMid2: "+finalbmid2+"%");
                    }
                    if (vpa.equals("BMid3")){
                        c31 = 1;
                        pfinalbmid3 += c31;
                        finalbmid3 = (2 - pfinalbmid3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p31.setText("BMid3: "+finalbmid3+"%");
                    }
                    if (vpa.equals("BMid4")){
                        c32 = 1;
                        pfinalbmid4 += c32;
                        finalbmid4 = (2 - pfinalbmid4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p32.setText("BMid4: "+finalbmid4+"%");
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
                    if (vpa.equals("BSN1")){
                        c33 = 1;
                        pfinalbsn1 += c33;
                        finalbsn1 = (2 - pfinalbsn1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p33.setText("BSN1: "+finalbsn1+"%");

                    }
                    if (vpa.equals("BSN2")){
                        c34 = 1;
                        pfinalbsn2 += c34;
                        finalbsn2 = (2 - pfinalbsn2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p34.setText("BSN2: "+finalbsn2+"%");
                    }
                    if (vpa.equals("BSN3")){
                        c35 = 1;
                        pfinalbsn3 += c35;
                        finalbsn3 = (2 - pfinalbsn3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p35.setText("BSN3: "+finalbsn3+"%");
                    }
                    if (vpa.equals("BSN4")){
                        c36 = 1;
                        pfinalbsn4 += c36;
                        finalbsn4 = (2 - pfinalbsn4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p36.setText("BSN4: "+finalbsn4+"%");
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
                    if (vpa.equals("ACT1")){
                        c37 = 1;
                        pfinalact1 += c37;
                        finalact1 = (2 - pfinalact1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p37.setText("ACT1: "+finalact1+"%");

                    }
                    if (vpa.equals("ACT2")){
                        c38 = 1;
                        pfinalact2 += c38;
                        finalact2 = (2 - pfinalact2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p38.setText("ACT2: "+finalact2+"%");
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
                    if (vpa.equals("BCA1")){
                        c39 = 1;
                        pfinalbca1 += c39;
                        finalbca1 = (2 - pfinalbca1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p39.setText("BCA1: "+finalbca1+"%");

                    }
                    if (vpa.equals("BCA2")){
                        c40 = 1;
                        pfinalbca2 += c40;
                        finalbca2 = (2 - pfinalbca2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p40.setText("BCA2: "+finalbca2+"%");
                    }
                    if (vpa.equals("BCA3")){
                        c41 = 1;
                        pfinalbca3 += c41;
                        finalbca3 = (2 - pfinalbca3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p41.setText("BCA3: "+finalbca3+"%");
                    }
                    if (vpa.equals("BCA4")){
                        c42 = 1;
                        pfinalbca4 += c42;
                        finalbca4 = (2 - pfinalbca4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p42.setText("BCA4: "+finalbca4+"%");
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
                    if (vpa.equals("BSEd1")){
                        c43 = 1;
                        pfinalbsed1 += c43;
                        finalbsed1 = (2 - pfinalbsed1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p43.setText("BSEd1: "+finalbsed1+"%");

                    }
                    if (vpa.equals("BSEd2")){
                        c44 = 1;
                        pfinalbsed2 += c44;
                        finalbsed2 = (2 - pfinalbsed2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p44.setText("BSEd2: "+finalbsed2+"%");
                    }
                    if (vpa.equals("BSEd3")){
                        c45 = 1;
                        pfinalbsed3 += c45;
                        finalbsed3 = (2 - pfinalbsed3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p45.setText("BSEd3: "+finalbsed3+"%");
                    }
                    if (vpa.equals("BSEd4")){
                        c46 = 1;
                        pfinalbsed4 += c46;
                        finalbsed4 = (2 - pfinalbsed4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p46.setText("BSEd4: "+finalbsed4+"%");
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
                    if (vpa.equals("BSTM1")){
                        c47 = 1;
                        pfinalbstm1 += c47;
                        finalbstm1 = (2 - pfinalbstm1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p47.setText("BSTM1: "+finalbstm1+"%");

                    }
                    if (vpa.equals("BSTM2")){
                        c48 = 1;
                        pfinalbstm2 += c48;
                        finalbstm2 = (2 - pfinalbstm2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p48.setText("BSTM2: "+finalbstm2+"%");
                    }
                    if (vpa.equals("BSTM3")){
                        c49 = 1;
                        pfinalbstm3 += c49;
                        finalbstm3 = (2 - pfinalbstm3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p49.setText("BSTM3: "+finalbstm3+"%");
                    }
                    if (vpa.equals("BSTM4")){
                        c50 = 1;
                        pfinalbstm4 += c50;
                        finalbstm4 = (2 - pfinalbstm4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p50.setText("BSTM4: "+finalbstm4+"%");
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
                    if (vpa.equals("BSBA1")){
                        c51 = 1;
                        pfinalbsba1 += c51;
                        finalbsba1 = (2 - pfinalbsba1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p51.setText("BSBA1: "+finalbsba1+"%");

                    }
                    if (vpa.equals("BSBA2")){
                        c52 = 1;
                        pfinalbsba2 += c52;
                        finalbsba2 = (2 - pfinalbsba2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p52.setText("BSBA2: "+finalbsba2+"%");
                    }
                    if (vpa.equals("BSBA3")){
                        c53 = 1;
                        pfinalbsba3 += c53;
                        finalbsba3 = (2 - pfinalbsba3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p53.setText("BSBA3: "+finalbsba3+"%");
                    }
                    if (vpa.equals("BSBA4")){
                        c54 = 1;
                        pfinalbsba4 += c54;
                        finalbsba4 = (2 - pfinalbsba4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p54.setText("BSBA4: "+finalbsba4+"%");
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
                    if (vpa.equals("BSOA1")){
                        c55 = 1;
                        pfinalbsoa1 += c55;
                        finalbsoa1 = (2 - pfinalbsoa1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p55.setText("BSOA1: "+finalbsoa1+"%");

                    }
                    if (vpa.equals("BSOA2")){
                        c56 = 1;
                        pfinalbsoa2 += c56;
                        finalbsoa2 = (2 - pfinalbsoa2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p56.setText("BSOA2: "+finalbsoa2+"%");
                    }
                    if (vpa.equals("BSOA3")){
                        c57 = 1;
                        pfinalbsoa3 += c57;
                        finalbsoa3 = (2 - pfinalbsoa3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p57.setText("BSOA3: "+finalbsoa3+"%");
                    }
                    if (vpa.equals("BSOA4")){
                        c58 = 1;
                        pfinalbsoa4 += c58;
                        finalbsoa4 = (2 - pfinalbsoa4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p58.setText("BSOA4: "+finalbsoa4+"%");
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
                    if (vpa.equals("BSA1")){
                        c59 = 1;
                        pfinalbsa1 += c59;
                        finalbsa1 = (2 - pfinalbsa1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p59.setText("BSA1: "+finalbsa1+"%");

                    }
                    if (vpa.equals("BSA2")){
                        c60 = 1;
                        pfinalbsa2 += c60;
                        finalbsa2 = (2 - pfinalbsa2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p60.setText("BSA2: "+finalbsa2+"%");
                    }
                    if (vpa.equals("BSA3")){
                        c61 = 1;
                        pfinalbsa3 += c61;
                        finalbsa3 = (2 - pfinalbsa3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p61.setText("BSA3: "+finalbsa3+"%");
                    }
                    if (vpa.equals("BSA4")){
                        c62 = 1;
                        pfinalbsa4 += c62;
                        finalbsa4 = (2 - pfinalbsa4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p62.setText("BSA4: "+finalbsa4+"%");
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
                    if (vpa.equals("AACS1")){
                        c63 = 1;
                        pfinalaacs1 += c63;
                        finalaacs1 = (2 - pfinalaacs1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p63.setText("AACS1: "+finalaacs1+"%");

                    }
                    if (vpa.equals("AACS2")){
                        c64 = 1;
                        pfinalaacs2 += c64;
                        finalaacs2 = (2 - pfinalaacs2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p64.setText("AACS2: "+finalaacs2+"%");
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
                    if (vpa.equals("BSE1")){
                        c65 = 1;
                        pfinalbse1 += c65;
                        finalbse1 = (2 - pfinalbse1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p65.setText("BSE1: "+finalbse1+"%");

                    }
                    if (vpa.equals("BSE2")){
                        c66 = 1;
                        pfinalbse2 += c66;
                        finalbse2 = (2 - pfinalbse2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p66.setText("BSE2: "+finalbse2+"%");
                    }
                    if (vpa.equals("BSE3")){
                        c67 = 1;
                        pfinalbse3 += c67;
                        finalbse3 = (2 - pfinalbse3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p67.setText("BSE3: "+finalbse3+"%");
                    }
                    if (vpa.equals("BSE4")){
                        c68 = 1;
                        pfinalbse4 += c68;
                        finalbse4 = (2 - pfinalbse4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p68.setText("BSE4: "+finalbse4+"%");
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
                    if (vpa.equals("BArch1")){
                        c69 = 1;
                        pfinalbarch1 += c69;
                        finalbarch1 = (2 - pfinalbarch1) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p69.setText("BArch1: "+finalbarch1+"%");

                    }
                    if (vpa.equals("BArch2")){
                        c70 = 1;
                        pfinalbarch2 += c70;
                        finalbarch2 = (2 - pfinalbarch2) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p70.setText("BArch2: "+finalbarch2+"%");
                    }
                    if (vpa.equals("BArch3")){
                        c71 = 1;
                        pfinalbarch3 += c71;
                        finalbarch3 = (2 - pfinalbarch3) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p71.setText("BArch3: "+finalbarch3+"%");
                    }
                    if (vpa.equals("BArch4")){
                        c72 = 1;
                        pfinalbarch4 += c72;
                        finalbarch4 = (2 - pfinalbarch4) * 100 / 2;
                        Log.d("course", ds.child("course").getValue().toString());
                        p72.setText("BArch4: "+finalbarch4+"%");
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.back:
                Intent intent = new Intent(this, charting.class);
                startActivity(intent);
                finish();
                break;
        }
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
            Intent intent4=new Intent(this,charting.class);
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